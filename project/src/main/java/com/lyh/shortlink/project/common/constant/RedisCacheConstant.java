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
     * 短链接跳转前缀 Key
     */
    public static final String GOTO_SHORT_LINK_KEY = "shortlink:goto:%s";
    public static final String LOCK_GOTO_SHORT_LINK_KEY = "shortlink:lock:goto:%s";
    /**
     * 永久短链接默认缓存有效时间，默认一个月，单位毫秒
     */
    public static final long DEFAULT_CACHE_VALID_TIME = 2626560000L;
    /**
     * 短链接空值跳转前缀 Key
     */
    public static final String GOTO_IS_NULL_SHORT_LINK_KEY = "shortlink:is-null:goto_%s";
    /**
     * 短链接布隆过滤器
     */
    public static final String SHORT_URI_BLOOMFILTER = "shortlink:bloom-filter:short-uri-filter";

    /**
     * 短链接修改分组 ID 锁前缀 Key
     */
    public static final String LOCK_GID_UPDATE_KEY = "shortlink:lock:update-gid:%s";
    /**
     * 短链接延迟队列消费统计 Key
     */
    public static final String DELAY_QUEUE_STATS_KEY = "short-link_delay-queue:stats";
    /**
     * 短链接统计判断是否新用户缓存标识
     */
    public static final String SHORT_LINK_STATS_UV_KEY = "shortlink:stats:uv:";
    /**
     * 短链接统计判断是否新 IP 缓存标识
     */
    public static final String SHORT_LINK_STATS_UIP_KEY = "shortlink:stats:uip:";
}
