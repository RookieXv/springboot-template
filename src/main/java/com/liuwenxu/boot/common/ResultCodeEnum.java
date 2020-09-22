package com.liuwenxu.boot.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Copyright (C), 2015-2020, https://liuwenxu.com/
 * FileName: ResultCodeEnum
 * Author: liuwenxu
 * Date: 2020/6/29 18:12
 * Description:
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    SUCCESS(200, "操作成功"),
    REMBERME(201, "登录成功"),
    REMBERMEFAILED(405, "登录失败"),
    FAILED(500, "操作失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    VALIDATE_FAILED(404, "参数检验失败");

    public final long code;
    public final String message;
}
