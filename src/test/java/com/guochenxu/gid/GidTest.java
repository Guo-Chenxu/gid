package com.guochenxu.gid;

import com.guochenxu.gid.service.GIdService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 连续自增id测试
 *
 * @author: 郭晨旭
 * @create: 2024-01-10 13:46
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class GidTest {

    @Resource
    private GIdService idSegmentService;

    @Test
    public void testMultiSameTag() {
        String tag = "test";

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<Long> task = () -> idSegmentService.getId(tag);
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
