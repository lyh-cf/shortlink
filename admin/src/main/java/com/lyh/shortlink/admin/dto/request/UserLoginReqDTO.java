package com.lyh.shortlink.admin.dto.request;

import lombok.Data;

/*
 *@title UserLoginReqDTO
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 15:36
 */
@Data
public class UserLoginReqDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
