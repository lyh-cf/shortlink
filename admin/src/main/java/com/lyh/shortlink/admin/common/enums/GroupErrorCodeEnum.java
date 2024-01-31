package com.lyh.shortlink.admin.common.enums;

import com.lyh.shortlink.admin.common.convention.errorcode.IErrorCode;

/*
 *@title GroupErrorCodeEnum
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 22:13
 */
public enum GroupErrorCodeEnum implements IErrorCode {
    GROUP_SAVE_ERROR("B000300","短链接分组新增失败"),
    GROUP_UPDATE_ERROR("B000301","短链接分组修改失败"),;
    private final String code;

    private final String message;
    GroupErrorCodeEnum(String code, String message) {
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
