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
    USER_NAME_EXIST("A000201","用户名已存在"),
    USER_LOGIN_ERROR("A000202","用户名或密码错误"),
    USER_LOGIN_ALREADY("A000203","用户已登录"),
    USER_NOT_LOGIN("A000204","用户未登录"),
    USER_SAVE_ERROR("B000200","用户记录新增失败"),
    USER_UPDATE_ERROR("B000201","用户记录修改失败"),
    USER_UPDATE_EXCEPTION("B000202","用户修改请求异常");

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
