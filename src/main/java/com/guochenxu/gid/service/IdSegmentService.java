package com.guochenxu.gid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guochenxu.gid.entity.IdSegment;

/**
 * (IdSegment)表服务接口
 *
 * @author: guochenxu
 * @create: 2024-01-06 16:11:28
 * @version: 1.0
 */
public interface IdSegmentService extends IService<IdSegment> {

    /**
     * 检测接口
     */
    String ping();

    /**
     * 新建tag
     */
    boolean createTag(IdSegment idSegment);

    /**
     * 获取id
     */
    long getId(String tag);


    /**
     * 获取雪花id
     */
    long getSnowId();
}

