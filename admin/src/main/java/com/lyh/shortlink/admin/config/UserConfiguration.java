package com.lyh.shortlink.admin.config;

/*
 *@title UserConfiguration
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/26 0:39
 */

import com.lyh.shortlink.admin.common.biz.user.UserTransmitFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 用户配置自动装配
 */
@Configuration
public class UserConfiguration {

    /**
     * 用户信息传递过滤器
     */
    @Bean
    public FilterRegistrationBean<UserTransmitFilter> globalUserTransmitFilter(StringRedisTemplate stringRedisTemplate) {
        FilterRegistrationBean<UserTransmitFilter> registration = new FilterRegistrationBean<>();
        //这个是自己创建的一个过滤器类
        registration.setFilter(new UserTransmitFilter(stringRedisTemplate));
        //设置过滤器要起作用的路径
        registration.addUrlPatterns("/*");
        //设置过滤器执行的顺序，如果有同样的过滤器，先执行order最大的，然后依次执行
        registration.setOrder(0);
        return registration;
    }
}
