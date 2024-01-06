package com.guochenxu.gid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.guochenxu.gid.entity.IdSegment;
import com.guochenxu.gid.mapper.IdSegmentMapper;
import com.guochenxu.gid.service.IdSegmentService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (IdSegment)表服务实现类
 *
 * @author: guochenxu
 * @create: 2024-01-06 16:11:28
 * @version: 1.0
 */
@Service("idSegmentService")
@Slf4j
public class IdSegmentServiceImpl extends ServiceImpl<IdSegmentMapper, IdSegment> implements IdSegmentService {

    @Resource
    private IdSegmentMapper idSegmentMapper;

    @Transactional(rollbackFor = Exception.class)
    public long updateIdSegment(String tag) {
        int change = idSegmentMapper.updateTag(tag);
        if (change <= 0) {
            throw new RuntimeException(tag + " 号段更新失败");
        }
        return idSegmentMapper.getStartIdByTag(tag);
    }

    @Override
    public String ping() {
        return "pong";
    }

    @Override
    public boolean createTag(IdSegment idSegment) {

        return false;
    }

    @Override
    public long getId(String tag) {
        return 0;
    }

    @Override
    public long getSnowId() {
        return 0;
    }
}

