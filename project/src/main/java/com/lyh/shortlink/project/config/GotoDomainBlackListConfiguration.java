package com.lyh.shortlink.project.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 *@title GotoDomainBlackListConfiguration
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/2/29 20:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "shortlink.goto-domain.black-list")
public class GotoDomainBlackListConfiguration {

    /**
     * 是否开启跳转原始链接域名黑名单验证
     */
    private Boolean enable;

    /**
     * 跳转原始域名黑名单网站名称集合
     */
    private String names;

    /**
     * 不可跳转的原始链接域名
     */
    private List<String> details;
}