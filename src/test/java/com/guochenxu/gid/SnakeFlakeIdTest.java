package com.guochenxu.gid;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.guochenxu.gid.entity.SnowFlakeWorker;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.*;

/**
 * 雪花id测试
 *
 * @author: 郭晨旭
 * @create: 2024-01-09 12:21
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class SnakeFlakeIdTest {


    @Test
    public void testOneThread() {
        for (int i = 0; i < 100; i++) {
            long snowFlakeId = SnowFlakeWorker.getSnowFlakeId();
            System.out.println(snowFlakeId);
        }

        long start = System.currentTimeMillis();
        Set<Long> set = new HashSet<>();
        long count = 0, id = -1;
        while (System.currentTimeMillis() - start <= 1000) {
            id = SnowFlakeWorker.getSnowFlakeId();
            count++;

            if (set.contains(id)) {
                log.error("重复id: {}", id);
                break;
            }
            set.add(id);
        }
        log.info("1秒生成id个数: {}", count);
    }

    @Test
    public void testMultiThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<Long> task = SnowFlakeWorker::getSnowFlakeId;
        List<Future<Long>> futures = new ArrayList<>();

        int num = 100;
        for (int i = 0; i < num; i++) {
            Future<Long> future = executorService.submit(task);
            futures.add(future);
        }

        // 等待所有任务完成，并获取结果
        Set<Long> set = new ConcurrentSkipListSet<>();
        for (Future<Long> future : futures) {
            try {
                long id = future.get();

                if (set.contains(id)) {
                    log.error("重复id: {}", id);
                    return;
                }
                set.add(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

        if (set.size() == num) {
            log.info("并发安全");
        }
    }
}
