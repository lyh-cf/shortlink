package com.lyh.shortlink.project.config;

/*
 *@title RBloomFilterConfiguration
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 17:01
 */

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.lyh.shortlink.project.common.constant.RedisCacheConstant.SHORT_URI_BLOOMFILTER;


/**
 * 布隆过滤器配置
 */
@Configuration
public class RBloomFilterConfiguration {

    /**
     * 防止短链接创建查询数据库的布隆过滤器
     */
    @Bean
    public RBloomFilter<String> shortUriCreateCachePenetrationBloomFilter(RedissonClient redissonClient) {
        //默认没有，需要自定义
        RBloomFilter<String> cachePenetrationBloomFilter = redissonClient.getBloomFilter(SHORT_URI_BLOOMFILTER);
        /**
         * tryInit 有两个核心参数：
         * ● expectedInsertions：预估布隆过滤器存储的元素长度。
         * ● falseProbability：运行的误判率。
         * 错误率越低，位数组越长，布隆过滤器的内存占用越大。
         * 错误率越低，散列 Hash 函数越多，计算耗时较长。
         */
        cachePenetrationBloomFilter.tryInit(100000000, 0.001);
        return cachePenetrationBloomFilter;
    }
}