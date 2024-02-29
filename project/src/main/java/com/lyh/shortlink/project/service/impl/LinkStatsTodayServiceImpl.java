package com.lyh.shortlink.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.shortlink.project.dao.entity.LinkStatsTodayDO;
import com.lyh.shortlink.project.dao.mapper.LinkStatsTodayMapper;
import com.lyh.shortlink.project.service.LinkStatsTodayService;
import org.springframework.stereotype.Service;

/*
 *@title LinkStatsTodayServiceImpl
 *@description 短链接今日统计接口实现层
 *@author LYH
 *@version 1.0
 *@create 2024/2/29 10:33
 */
@Service
public class LinkStatsTodayServiceImpl extends ServiceImpl<LinkStatsTodayMapper, LinkStatsTodayDO> implements LinkStatsTodayService {
}