package com.lyh.shortlink.project.common.constant;

/*
 *@title RedisCacheConstant
 *@description 短链接后管 Redis 缓存常量类
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 21:03
 */
public class RedisCacheConstant {
     /**
      * 短链接布隆过滤器
      */
     public static final String SHORT_URI_BLOOMFILTER="shortlink:bloom-filter:short-uri-filter";
     /**
      * 短链接修改分组 ID 锁前缀 Key
      */
     public static final String LOCK_GID_UPDATE_KEY = "short-link:lock:update-gid:%s";
}
