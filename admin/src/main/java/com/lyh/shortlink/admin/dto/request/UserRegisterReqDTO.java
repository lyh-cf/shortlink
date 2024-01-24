package com.lyh.shortlink.admin.dto.request;

import lombok.Data;

/*
 *@title UserRegisterReqDTO
 *@description 用户注册请求参数
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 17:20
 */
@Data
public class UserRegisterReqDTO {
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
