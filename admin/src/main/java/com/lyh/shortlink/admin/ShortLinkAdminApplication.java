package com.lyh.shortlink.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *@title ShortLinkAdminApplication
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/23 21:03
 */
@SpringBootApplication
@MapperScan("com.lyh.shortlink.admin.dao.mapper")
public class ShortLinkAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortLinkAdminApplication.class, args);
    }
}
