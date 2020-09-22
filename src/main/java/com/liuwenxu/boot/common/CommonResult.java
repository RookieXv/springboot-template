package com.liuwenxu.boot.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Copyright (C), 2015-2020, https://liuwenxu.com/
 * FileName: CommonResult
 * Author: liuwenxu
 * Date: 2020/6/29 17:52
 * Description: 统一Restful返回对象
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "统一Restful返回对象")
public class CommonResult<T> {

    @ApiModelProperty(value = "请求状态")
    private long code;

    @ApiModelProperty(value = "请求信息")
    private String message;

    @ApiModelProperty(value = "请求返回数据")
    private T data;

    /**
     * 请求成功
     *
     * @param data 返回结果
     * @param <T>  类型
     * @return CommonResult
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCodeEnum.SUCCESS.code, ResultCodeEnum.SUCCESS.message, data);
    }

    /**
     * 登录成功
     *
     * @param data 返回结果
     * @param <T>  类型
     * @return CommonResult
     */
    public static <T> CommonResult<T> loginSuccess(T data) {
        return new CommonResult<T>(ResultCodeEnum.REMBERME.code, ResultCodeEnum.REMBERME.message, data);
    }

    /**
     * 登录失败
     *
     * @param data 返回结果
     * @param <T>  类型
     * @return CommonResult
     */
    public static <T> CommonResult<T> loginFailed(T data) {
        return new CommonResult<T>(ResultCodeEnum.REMBERMEFAILED.code, ResultCodeEnum.REMBERMEFAILED.message, data);
    }

    /**
     * 请求失败
     *
     * @param data 返回结果
     * @param <T>  类型
     * @return CommonResult
     */
    public static <T> CommonResult<T> failed(T data) {
        return new CommonResult<T>(ResultCodeEnum.FAILED.code, ResultCodeEnum.FAILED.message, data);
    }

    /**
     * 请求失败
     *
     * @param code    状态码
     * @param message 错误信息
     * @param data    返回结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(long code, String message, T data) {
        return new CommonResult<T>(code, message, data);
    }

    /**
     * 参数校验失败返回
     *
     * @param <T> 类型
     * @return CommonResult
     */
    public static <T> CommonResult<T> validateFailed() {
        return new CommonResult<T>(ResultCodeEnum.VALIDATE_FAILED.code, ResultCodeEnum.VALIDATE_FAILED.message, null);
    }

    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCodeEnum.VALIDATE_FAILED.code, message, null);
    }
}
