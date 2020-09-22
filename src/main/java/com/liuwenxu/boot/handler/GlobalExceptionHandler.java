package com.liuwenxu.boot.handler;

import com.liuwenxu.boot.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Copyright (C), 2015-2020, https://liuwenxu.com/
 * FileName: GlobalExceptionHandler
 * Author: liuwenxu
 * Date: 2020/7/3 15:09
 * Description:
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = Exception.class)
    public CommonResult handler(Exception e) {
        log.error("运行时异常：----------------{}", e.getMessage());
        return CommonResult.failed(500, e.getMessage(), null);
    }

}
