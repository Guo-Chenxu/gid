package com.guochenxu.gid.controller;

import cn.hutool.core.bean.BeanUtil;
import com.guochenxu.gid.dto.R;
import com.guochenxu.gid.dto.req.CreateTagReq;
import com.guochenxu.gid.dto.resp.GetIdResp;
import com.guochenxu.gid.entity.IdSegment;
import com.guochenxu.gid.service.IdSegmentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 接口
 *
 * @author: 郭晨旭
 * @create: 2024-01-06 16:45
 * @version: 1.0
 */
@RestController
@RequestMapping("id")
public class IdSegmentController {

    @Resource
    private IdSegmentService idSegmentService;

    /**
     * 检测接口
     */
    @GetMapping("/ping")
    public R<Object> ping() {
        return new R<>().success(idSegmentService.ping());
    }

    /**
     * 创建tag
     */
    @PostMapping("/tag")
    public R<Object> createTag(CreateTagReq createTagReq) {
        IdSegment idSegment = new IdSegment();
        BeanUtil.copyProperties(createTagReq, idSegment);
        if (idSegmentService.createTag(idSegment)) {
            return new R<>().success("创建成功");
        }
        return new R<>().error("创建失败");
    }

    /**
     * 获取指定tag的id
     */
    @GetMapping("/id/{tag}")
    public R<GetIdResp> getId(@PathVariable("tag") String tag) {
        long id = idSegmentService.getId(tag);
        GetIdResp resp = GetIdResp.builder().id(id).tag(tag).build();
        return new R<GetIdResp>().success(resp);
    }

    /**
     * 获取雪花id
     */
    @GetMapping("/snowId")
    public R<Long> getSnowId() {
        long snowId = idSegmentService.getSnowId();
        return new R<Long>().success(snowId);
    }
}
