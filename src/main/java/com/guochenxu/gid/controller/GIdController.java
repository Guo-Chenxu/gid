package com.guochenxu.gid.controller;

import cn.hutool.core.bean.BeanUtil;
import com.guochenxu.gid.dto.R;
import com.guochenxu.gid.dto.req.CreateTagReq;
import com.guochenxu.gid.dto.resp.GetIdResp;
import com.guochenxu.gid.entity.IdSegment;
import com.guochenxu.gid.service.GIdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * gid的http接口
 *
 * @author: 郭晨旭
 * @create: 2024-01-06 16:45
 * @version: 1.0
 */
@RestController
@Api(tags = "gid")
public class GIdController {

    @Resource
    private GIdService gIdService;

    /**
     * 检测接口
     */
    @GetMapping("/ping")
    @ApiOperation("测试接口")
    public R<Object> ping() {
        return new R<>().success(gIdService.ping());
    }

    /**
     * 创建tag
     */
    @PostMapping("/tag")
    @ApiOperation("创建tag")
    public R<Object> createTag(CreateTagReq createTagReq) {
        IdSegment idSegment = new IdSegment();
        BeanUtil.copyProperties(createTagReq, idSegment);
        if (gIdService.createTag(idSegment)) {
            return new R<>().success("创建成功");
        }
        return new R<>().error("创建失败");
    }

    /**
     * 获取指定tag的id
     */
    @GetMapping("/id/{tag}")
    @ApiOperation("获取指定tag的id,如果tag不存在则创建")
    public R<GetIdResp> getId(@PathVariable("tag") String tag) {
        long id = gIdService.getId(tag);
        if (id == -1) {
            throw new RuntimeException("获取id失败, 请稍后重试");
        }
        GetIdResp resp = GetIdResp.builder().id(id).tag(tag).build();
        return new R<GetIdResp>().success(resp);
    }

    /**
     * 获取雪花id
     */
    @GetMapping("/snowId")
    @ApiOperation("获取雪花id")
    public R<Long> getSnowId() {
        long snowId = gIdService.getSnowId();
        return new R<Long>().success(snowId);
    }
}
