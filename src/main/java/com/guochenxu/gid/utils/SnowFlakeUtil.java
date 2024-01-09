package com.guochenxu.gid.utils;

import com.guochenxu.gid.entity.SnowFlakeWorker;

/**
 * 雪花算法
 *
 * @author: 郭晨旭
 * @create: 2024-01-09 12:02
 * @version: 1.0
 */
public class SnowFlakeUtil {

    private static final int WORKER_BITS = 10; // 工作机器位数
    private static final int NUMBER_BITS = 12; // 每个节点每秒可产生的id数量
    private static final long WORKER_MAX = ~(-1L << WORKER_BITS); // 最大机器号
    private static final long NUMBER_MAX = ~(-1L << NUMBER_BITS); //  每个节点最大id数量
    private static final int TIME_SHIFT = WORKER_BITS + NUMBER_BITS; // 时间戳向左的偏移量
    private static final int WORKER_SHIFT = NUMBER_BITS; // 工作机器号向左偏移量
    private static final long EPOCH = 1704776499106L; // 起始时间戳变量, 减少id浪费. 不可修改, 否则会出现重复id

    /**
     * 雪花算法生成id
     *
     * @param worker 工作机器信息
     */
    public static long generateId(SnowFlakeWorker worker) {
        if (worker.getWorkerId() > WORKER_MAX) {
            throw new RuntimeException("workId 不正确, 工作机器编号不允许大于 " + WORKER_MAX);
        }

        long now = getNowTime();

        if (now == worker.getTimestamp()) {
            /*
                所有id都在这同1ms内生成
                需要判断生成id的个数是否大于最大个数, 如果大于则需要等一毫秒再生成
             */
            worker.setNumber(worker.getNumber() + 1);
            if (worker.getNumber() > NUMBER_MAX) {
                worker.setNumber(0);
                while (now <= worker.getTimestamp()) {
                    now = getNowTime();
                }
                worker.setTimestamp(now);
            }
        } else if (now > worker.getTimestamp()) {
            /*
                在1ms之前生成过, 直接生成即可
             */
            worker.setNumber(0);
            worker.setTimestamp(now);
        } else {
            /*
                时钟被回拨, 需要等到系统时钟和worker时钟相等
                然后再执行操作
             */
            while (now < worker.getTimestamp()) {
                now = getNowTime();
            }

            worker.setNumber(worker.getNumber() + 1);
            if (worker.getNumber() > NUMBER_MAX) {
                worker.setNumber(0);
                while (now <= worker.getTimestamp()) {
                    now = getNowTime();
                }
                worker.setTimestamp(now);
            }
        }

        // 雪花算法生成id
        // 1位标识位 + 41位时间戳 + 10位工作机器id + 12位序号 = 64位id
        return (now - EPOCH) << TIME_SHIFT | (worker.getWorkerId() << WORKER_SHIFT) | (worker.getNumber());
    }

    private static long getNowTime() {
        return System.currentTimeMillis();
    }
}
