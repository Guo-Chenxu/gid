package com.guochenxu.gid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.guochenxu.gid.entity.AllocMap;
import com.guochenxu.gid.entity.IdSegment;
import com.guochenxu.gid.entity.SnowFlakeWorker;
import com.guochenxu.gid.mapper.IdSegmentMapper;
import com.guochenxu.gid.service.GIdService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import javax.annotation.Resource;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * (IdSegment)表服务实现类
 *
 * @author: guochenxu
 * @create: 2024-01-06 16:11:28
 * @version: 1.0
 */
@Service("idSegmentService")
@Slf4j
public class GIdServiceImpl extends ServiceImpl<IdSegmentMapper, IdSegment> implements GIdService {

    @Resource
    private IdSegmentMapper idSegmentMapper;

    @Resource
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Resource
    private TransactionDefinition transactionDefinition;
    private static final long DEFAULT_START_ID = 0L; // 默认起始id
    private static final long DEFAULT_STEP = 2000L; // 默认step
    private static final int TRY_NUM = 3; // 默认失败重试次数
    private static final int MAX_WAITING_TIME = 3000; // 等待超时最大时间, 3000ms

    // 线程池, 用于提交更新号段任务
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 60, 3000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    @Override
    public String ping() {
        return "pong";
    }

    @Override
    public boolean createTag(IdSegment idSegment) {
        int res = idSegmentMapper.insert(idSegment);
        if (res != 1) {
            return false;
        }
        AllocMap.addTag(idSegment.getTag(), idSegment.getStartId(), idSegment.getStep());
        return true;
    }

    @Override
    public long getId(String tag) {
        // 不存在先创建
        synchronized (AllocMap.class) {
            if (!AllocMap.containsTag(tag)) {
                boolean created = this.createTag(IdSegment.builder().tag(tag).startId(DEFAULT_START_ID).step(DEFAULT_STEP).build());
                if (!created) {
                    throw new RuntimeException("创建tag失败");
                }
            }
        }

        AllocMap.Alloc alloc = AllocMap.getByTag(tag);
        long id = -1;

        // 先看是否能获取id
        boolean canGetId = false;
        synchronized (alloc) {
            long count = countIds(alloc);
            if (count > 0) {
                canGetId = true;
                id = nextId(alloc);
            }

            if (alloc.getIdSegs().size() <= 1 && !alloc.isGetDB()) {
                alloc.setGetDB(true);
                // 改用线程池
                executor.submit(new Thread(() -> {
                    updateIds(alloc.getTag());
                    alloc.notify();
                }));
            }
        }

        if (canGetId) {
            return id;
        }


        // 再次获取id
        synchronized (alloc) {
            // 等待内存更新id号段
            try {
                alloc.wait(MAX_WAITING_TIME);
            } catch (InterruptedException e) {
                log.error("tag: {} 获取号段等待超时, {}", alloc.getTag(), e.getMessage());
            }

            if (countIds(alloc) > 0) {
                id = nextId(alloc);
            } else {
                return -1;
            }
        }
        return id;
    }

    /**
     * 更新内存中的id号段
     */
    private void updateIds(String tag) {
        AllocMap.Alloc alloc = AllocMap.getByTag(tag);
        for (int i = 0; i < TRY_NUM; i++) {
            synchronized (alloc) {
                if (alloc.getIdSegs().size() > 1) {
                    break;
                }
                IdSegment idSegment = updateIdSegment(alloc.getTag());
                if (idSegment != null) {
                    alloc.getIdSegs().add(new AllocMap.IdSeg(0, idSegment.getStartId(), idSegment.getStartId() + idSegment.getStep()));
                    if (alloc.getIdSegs().size() > 1) {
                        break;
                    }
                }
            }
        }
        alloc.setGetDB(false);
    }


    /**
     * 更新数据库的号段
     */
    public IdSegment updateIdSegment(String tag) {
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            int change = idSegmentMapper.updateTag(tag);
            if (change <= 0) {
                throw new RuntimeException(tag + " 号段更新失败");
            }

            dataSourceTransactionManager.commit(transaction);
            return idSegmentMapper.getStartIdByTag(tag);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transaction);
            throw new RuntimeException(tag + " 号段更新失败");
        }
    }

    /**
     * 计算内存中剩余的id个数
     */
    private long countIds(AllocMap.Alloc alloc) {
        long count = 0;
        for (AllocMap.IdSeg ids : alloc.getIdSegs()) {
            count += ids.getEnd() - ids.getStart() - ids.getCur();
        }
        return count;
    }

    /**
     * 获取下一个id
     */
    private long nextId(AllocMap.Alloc alloc) {
        AllocMap.IdSeg idSeg = alloc.getIdSegs().get(0);
        long id = idSeg.getStart() + idSeg.getCur();
        idSeg.setCur(idSeg.getCur() + 1);
        if (id + 1 >= idSeg.getEnd()) {
            alloc.getIdSegs().remove(0);
        }
        return id;
    }

    @Override
    public long getSnowId() {
        return SnowFlakeWorker.getSnowFlakeId();
    }
}

