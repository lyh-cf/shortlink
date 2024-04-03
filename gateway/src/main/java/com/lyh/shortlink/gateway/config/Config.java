package com.lyh.shortlink.gateway.config;

import lombok.Data;

import java.util.List;

/*
 *@title Config
 *@description 过滤器配置
 *@author LYH
 *@version 1.0
 *@create 2024/4/3 19:38
 */
@Data
public class Config {

    /**
     * 白名单前置路径
     */
    private List<String> whitePathList;
}
