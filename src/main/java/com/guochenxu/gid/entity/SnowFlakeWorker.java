package com.guochenxu.gid.entity;

import com.guochenxu.gid.utils.SnowFlakeUtil;
import lombok.Data;

/**
 * 雪花id工作者
 *
 * @author: 郭晨旭
 * @create: 2024-01-09 12:13
 * @version: 1.0
 */
@Data
public class SnowFlakeWorker {

    private static final SnowFlakeWorker worker = new SnowFlakeWorker(System.currentTimeMillis(), 1L, 0L);

    /**
     * 上次分配id时的时间错
     */
    private long timestamp;
    /**
     * 工作机器id
     */
    private long workerId;
    /**
     * 当前已经分配了多少id
     */
    private long number;

    private SnowFlakeWorker() {
    }

    private SnowFlakeWorker(long _timestamp, long _workerId, long _number) {
        this.timestamp = _timestamp;
        this.workerId = _workerId;
        this.number = _number;
    }

    public static long getSnowFlakeId() {
        return SnowFlakeUtil.generateId(worker);
    }
}
