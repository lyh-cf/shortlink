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
    GROUP_UPDATE_ERROR("B000301","短链接分组修改失败"),
    GROUP_DELETE_ERROR("B000302","短链接分组删除失败"),
    GROUP_SORT_ERROR("B000303","短链接分组排序失败"),
    GROUP_USER_NULL("B000400","用户无分组信息");
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
