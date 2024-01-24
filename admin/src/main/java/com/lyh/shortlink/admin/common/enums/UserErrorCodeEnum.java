package com.lyh.shortlink.admin.common.enums;

import com.lyh.shortlink.admin.common.convention.errorcode.IErrorCode;

/*
 *@title UserErrorCodeEnum
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 10:42
 */
public enum UserErrorCodeEnum implements IErrorCode {
    USER_NULL("A000200","用户不存在"),
    USER_EXIST("A000201","用户记录已存在");
    private final String code;

    private final String message;

    UserErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
