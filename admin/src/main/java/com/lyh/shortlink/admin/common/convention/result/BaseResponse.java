package com.lyh.shortlink.admin.common.convention.result;

/*
 *@title BaseResponse
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 11:02
 */

import com.lyh.shortlink.admin.common.convention.errorcode.BaseErrorCodeEnum;
import com.lyh.shortlink.admin.common.convention.exception.AbstractException;

import java.util.Optional;

/**
 * 全局返回对象构造器
 */
public final class BaseResponse {

    /**
     * 构造成功响应
     */
    public static Result<Void> success() {
        return new Result<Void>()
                .setCode(Result.SUCCESS_CODE);
    }

    /**
     * 构造带返回数据的成功响应
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .setCode(Result.SUCCESS_CODE)
                .setData(data);
    }

    /**
     * 构建服务端失败响应
     */
    public static Result<Void> failure() {
        return new Result<Void>()
                .setCode(BaseErrorCodeEnum.SERVICE_ERROR.code())
                .setMessage(BaseErrorCodeEnum.SERVICE_ERROR.message());
    }

    /**
     * 通过 {@link AbstractException} 构建失败响应
     */
    public static Result<Void> failure(AbstractException abstractException) {
        String errorCode = Optional.ofNullable(abstractException.getErrorCode())
                .orElse(BaseErrorCodeEnum.SERVICE_ERROR.code());
        String errorMessage = Optional.ofNullable(abstractException.getErrorMessage())
                .orElse(BaseErrorCodeEnum.SERVICE_ERROR.message());
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }

    /**
     * 通过 errorCode、errorMessage 构建失败响应
     */
    public static Result<Void> failure(String errorCode, String errorMessage) {
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }
}