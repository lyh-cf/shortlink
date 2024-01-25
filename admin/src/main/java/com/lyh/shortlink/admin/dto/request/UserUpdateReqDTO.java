package com.lyh.shortlink.admin.dto.request;

import lombok.Data;

/*
 *@title UserUpdateReqDTO
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 15:06
 */
@Data
public class UserUpdateReqDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
