package com.lyh.shortlink.project.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
 *@title SentinelRuleConfig
 *@description 初始化限流配置
 *@author LYH
 *@version 1.0
 *@create 2024/3/1 15:35
 */
@Component
public class SentinelRuleConfig implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule createOrderRule = new FlowRule();
        createOrderRule.setResource("create_short-link");
        //基于QPS流量控制
        createOrderRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //每秒最多允许通过1次请求
        createOrderRule.setCount(1);
        rules.add(createOrderRule);
        FlowRuleManager.loadRules(rules);
    }
}
