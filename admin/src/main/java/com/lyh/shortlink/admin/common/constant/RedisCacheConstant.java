package com.lyh.shortlink.admin.common.constant;

/*
 *@title RedisCacheConstant
 *@description 短链接后管 Redis 缓存常量类
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 21:03
 */
public class RedisCacheConstant {
     public static final String USER_NAME_BLOOMFILTER="shortlink:bloom-filter:username-filter";
     /**
      * 用户注册分布式锁
      */
     public static final String LOCK_USER_REGISTER_KEY="shortlink:lock:user-register:";
     public static final String USER_LOGIN_TOKEN_KEY="shortlink:user-login:";
     public static final int USER_TOKEN_TTL=30;
}
