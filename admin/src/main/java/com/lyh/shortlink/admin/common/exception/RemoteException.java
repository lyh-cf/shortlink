package com.lyh.shortlink.admin.common.exception;

/*
 *@title RemoteException
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 10:54
 */


import com.lyh.shortlink.admin.common.convention.errorcode.BaseErrorCodeEnum;
import com.lyh.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * 远程服务调用异常
 */
public class RemoteException extends AbstractException {

    public RemoteException(String message) {
        this(message, null, BaseErrorCodeEnum.REMOTE_ERROR);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}