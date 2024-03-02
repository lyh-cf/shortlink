package com.lyh.shortlink.project.mq.producer;
import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
 *@title ShortLinkStatsSaveProducer
 *@description 短链接监控状态保存消息队列生产者
 *@author LYH
 *@version 1.0
 *@create 2024/3/2 17:37
 */
@Component
@RequiredArgsConstructor
public class ShortLinkStatsSaveProducer {

    private final StringRedisTemplate stringRedisTemplate;

    @Value("${spring.data.redis.channel-topic.short-link-stats}")
    private String topic;

    /**
     * 发送短链接监控状态保存消息
     */
    public void send(Map<String, String> producerMap) {
        //往topic中发
        stringRedisTemplate.opsForStream().add(topic, producerMap);
    }
}