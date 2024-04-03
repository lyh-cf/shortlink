package com.lyh.shortlink.gateway;

/*
 *@title GatewayServiceApplication
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/4/3 17:45
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 网关服务应用启动器
 */
@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}