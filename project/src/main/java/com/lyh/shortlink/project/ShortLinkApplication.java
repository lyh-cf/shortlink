package com.lyh.shortlink.project;

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
@MapperScan("com.lyh.shortlink.project.dao.mapper")
public class ShortLinkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortLinkApplication.class, args);
    }
}
