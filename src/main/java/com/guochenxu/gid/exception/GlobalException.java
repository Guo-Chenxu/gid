package com.guochenxu.gid.exception;

import com.guochenxu.gid.constants.HttpCode;
import com.guochenxu.gid.dto.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * sa-token异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {

    // 拦截：空指针异常
    @ExceptionHandler(NullPointerException.class)
    public R handlerException(NullPointerException e) {
        log.error("出现空指针异常: ", e);
        return new R().error(e.getMessage());
    }

    // 拦截：其它所有异常
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public R handlerException(MissingServletRequestParameterException e) {
        log.error("缺少参数异常: ", e);
        return new R(HttpCode.REQUEST_PARAM_BLANK, e.getMessage(), null);
    }

    // 拦截：其它所有异常
    @ExceptionHandler(Exception.class)
    public R handlerException(Exception e) {
        log.error("出现异常: ", e);
        return new R().error(e.getMessage());
    }
}