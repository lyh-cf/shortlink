package com.lyh.shortlink.admin.dto.response;

import lombok.Data;

/*
 *@title UserActualRespDTO
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 16:02
 */
@Data
public class UserActualRespDTO {
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
