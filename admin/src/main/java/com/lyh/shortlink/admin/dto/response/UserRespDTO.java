package com.lyh.shortlink.admin.dto.response;

import lombok.Data;

/*
 *@title UserRespDTO
 *@description 用户返回参数响应
 *@author LYH
 *@version 1.0
 *@create 2024/1/23 22:27
 */
@Data
public class UserRespDTO {
    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;


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
