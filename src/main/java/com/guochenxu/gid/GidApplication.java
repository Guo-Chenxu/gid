package com.guochenxu.gid;

import com.guochenxu.gid.entity.AllocMap;
import com.guochenxu.gid.mapper.IdSegmentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@EnableAsync
@Slf4j
public class GidApplication {

    @Resource
    private IdSegmentMapper idSegmentMapper;

    public static void main(String[] args) {
        SpringApplication.run(GidApplication.class, args);
    }

    /**
     * 初始化内存号段
     */
    @PostConstruct
    public void init() {
        log.info("正在初始化内存号段...");
        List<String> tagList = idSegmentMapper.listTags();
        tagList.forEach(AllocMap::addTag);
        log.info("初始化内存号段结束");
    }
}
