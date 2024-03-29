package com.lyh.shortlink.project.common.enums;


import com.lyh.shortlink.project.common.convention.errorcode.IErrorCode;

/*
 *@title UserErrorCodeEnum
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 10:42
 */
public enum ShortLinkErrorCodeEnum implements IErrorCode {
    LINK_CREATE_FREQUENT_ERROR("B000400","短链接创建频繁，请稍后再试"),
    LINK_NULL("A000400","短链接记录不存在"),
    LINK_FILL_ERROR("A000600","跳转链接填写错误"),
    ILLEGAL_LINK_ERROR("A000601","跳转链接非法");
    private final String code;

    private final String message;

    ShortLinkErrorCodeEnum(String code, String message) {
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
