package com.lyh.shortlink.admin.config;

/*
 *@title UserConfiguration
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/26 0:39
 */

import com.lyh.shortlink.admin.common.biz.user.UserFlowRiskControlFilter;
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
    public FilterRegistrationBean<UserTransmitFilter> globalUserTransmitFilter() {
        FilterRegistrationBean<UserTransmitFilter> registration = new FilterRegistrationBean<>();
        //这个是自己创建的一个过滤器类
        registration.setFilter(new UserTransmitFilter());
        //设置过滤器要起作用的路径
        registration.addUrlPatterns("/*");
        //设置过滤器执行的顺序，先执行order最小的
        registration.setOrder(0);
        return registration;
    }
    /**
     * 用户操作流量风控过滤器
     */
    @Bean
    //条件注解
//    @ConditionalOnProperty(name = "shortlink.flow-limit.enable", havingValue = "true")
    public FilterRegistrationBean<UserFlowRiskControlFilter> globalUserFlowRiskControlFilter(StringRedisTemplate stringRedisTemplate,
            UserFlowRiskControlConfiguration userFlowRiskControlConfiguration) {
        FilterRegistrationBean<UserFlowRiskControlFilter> registration = new FilterRegistrationBean<>();
        //这个是自己创建的一个过滤器类，并没有通过spring管理，不能通过spring注入
        registration.setFilter(new UserFlowRiskControlFilter(stringRedisTemplate, userFlowRiskControlConfiguration));
        registration.addUrlPatterns("/*");
        //设置过滤器执行的顺序，先执行order最小的
        registration.setOrder(10);
        return registration;
    }
}
