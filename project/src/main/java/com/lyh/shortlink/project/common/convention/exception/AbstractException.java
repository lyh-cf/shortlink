package com.lyh.shortlink.project.common.convention.exception;

/*
 *@title AbstractException
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 10:54
 */


import com.lyh.shortlink.project.common.convention.errorcode.IErrorCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * 抽象项目中三类异常体系，客户端异常、服务端异常以及远程服务调用异常
 *
 * @see ClientException
 * @see ServiceException
 * @see RemoteException
 */
@Getter
public abstract class AbstractException extends RuntimeException {

    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable);
        this.errorCode = errorCode.code();
        //.orElse(errorCode.message()) 方法指定当包装的值为 null 时，返回一个默认的替代值，即 errorCode.message()
        this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
    }
}