package com.lyh.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.shortlink.admin.dao.entity.GroupDO;
import com.lyh.shortlink.admin.dao.mapper.GroupMapper;
import com.lyh.shortlink.admin.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
 *@title GroupServiceImpl
 *@description 短链接分组接口实现层
 *@author LYH
 *@version 1.0
 *@create 2024/1/25 21:25
 */
@Service
@Slf4j
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
}
