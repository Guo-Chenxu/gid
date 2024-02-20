package com.guochenxu.gid.config;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Aspect
@Component
@Order(1)
@Slf4j
public class AspectConfig {

    @Around("@within(org.springframework.web.bind.annotation.RestController)" +
            "||@within(org.springframework.stereotype.Controller)")
    public Object after(ProceedingJoinPoint joinPoint) throws Throwable {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // 忽略 swagger 相关文档的日志
        if (request.getRequestURI().contains("/v2/api-docs") || request.getRequestURI().contains("/swagger-resources")) {
            return joinPoint.proceed(joinPoint.getArgs());
        }

        String traceId = IdUtil.getSnowflakeNextIdStr();

        log.info("\n============================Request Come In============================\n" +
                        "Trace Id={}\n" +
                        "Time={}\n" +
                        "URL={}\n" +
                        "Request Method={}\n" +
                        "Signature={}\n" +
                        "Parameter={}\n",
                traceId,
                new Date(),
                Optional.of(request.getRequestURI().toString()).orElse(null), request.getMethod(),
                joinPoint.getSignature(),
                JSONObject.toJSONString(filterArgs(joinPoint.getArgs())));

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(joinPoint.getArgs());
        long end = System.currentTimeMillis();

        log.info("\n============================Response Return============================\n" +
                        "Trace Id={}\n" +
                        "Time={}\n" +
                        "Consume Time={}ms\n" +
                        "Response={}\n",
                traceId, new Date(), end - start, JSONObject.toJSONString(result));

        return result;
    }

    private List<Object> filterArgs(Object[] objects) {
        return Arrays.stream(objects).filter(obj -> !(obj instanceof MultipartFile)
                && !(obj instanceof HttpServletResponse)
                && !(obj instanceof HttpServletRequest)).collect(Collectors.toList());
    }
}
