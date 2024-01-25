package com.lyh.shortlink.admin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@title UserLoginRespDTO
 *@description 用户登录接口返回响应
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRespDTO {
    /**
     * 用户 Token
     */
    private String token;
}
