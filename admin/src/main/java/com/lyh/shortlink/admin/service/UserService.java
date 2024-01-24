package com.lyh.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyh.shortlink.admin.dao.entity.UserDO;
import com.lyh.shortlink.admin.dto.response.UserRespDTO;

/*
 *@title UserService
 *@description 用户接口层
 *@author LYH
 *@version 1.0
 *@create 2024/1/23 22:13
 */
public interface UserService extends IService<UserDO> {
    UserRespDTO getUserByUserName(String username);
}
