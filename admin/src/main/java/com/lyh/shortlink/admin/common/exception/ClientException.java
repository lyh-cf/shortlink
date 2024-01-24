package com.lyh.shortlink.admin.common.exception;

/*
 *@title ClientException
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 10:54
 */


import com.lyh.shortlink.admin.common.convention.errorcode.BaseErrorCodeEnum;
import com.lyh.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * 客户端异常
 */
public class ClientException extends AbstractException {

    public ClientException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ClientException(String message) {
        this(message, null, BaseErrorCodeEnum.CLIENT_ERROR);
    }

    public ClientException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
