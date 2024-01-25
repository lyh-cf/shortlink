package com.lyh.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyh.shortlink.admin.dao.entity.UserDO;
import com.lyh.shortlink.admin.dto.request.UserLoginReqDTO;
import com.lyh.shortlink.admin.dto.request.UserRegisterReqDTO;
import com.lyh.shortlink.admin.dto.request.UserUpdateReqDTO;
import com.lyh.shortlink.admin.dto.response.UserLoginRespDTO;
import com.lyh.shortlink.admin.dto.response.UserRespDTO;

/*
 *@title UserService
 *@description 用户接口层
 *@author LYH
 *@version 1.0
 *@create 2024/1/23 22:13
 */
public interface UserService extends IService<UserDO> {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    UserRespDTO getUserByUserName(String username);
    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    Boolean hasUserName(String username);
    /**
     * 注册用户
     * @param requestParam
     * @return
     */
    void register(UserRegisterReqDTO requestParam);
    /**
     * 根据用户名修改用户
     * @param requestParam
     * @return
     */
    void update(UserUpdateReqDTO requestParam);
    /**
     * 用户登录
     * @param requestParam
     * @return
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);
    /**
    * 检查用户是否登录
    * @Param: * @param[1] username
     * @param[2] token
    */
    Boolean checkLogin(String username,String token);
    /**
     * 退出登录
     * @Param: * @param[1] username
     * @param[2] token
     */
    void logout(String username, String token);
}
