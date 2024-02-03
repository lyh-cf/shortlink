package com.lyh.shortlink.admin.common.biz.user;

/*
 *@title UserTransmitFilter
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/26 0:26
 */

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Lists;
import com.lyh.shortlink.admin.common.convention.exception.ClientException;
import com.lyh.shortlink.admin.common.convention.result.BaseResponse;
import com.lyh.shortlink.admin.common.enums.UserErrorCodeEnum;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

import static com.lyh.shortlink.admin.common.constant.RedisCacheConstant.LOCK_TOKEN_KEY;

/**
 * 用户信息传输过滤器
 */
@RequiredArgsConstructor
public class UserTransmitFilter implements Filter {
    private final StringRedisTemplate stringRedisTemplate;
    private static final List<String> IGNORE_URI = Lists.newArrayList(
            "/api/shortlink/admin/user/login",
            "/api/shortlink/admin/user/has-username"
    );

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();
        if (!IGNORE_URI.contains(requestURI)) {
            String method = httpServletRequest.getMethod();
            //区分注册和修改用户的请求
            if (!(Objects.equals(requestURI, "/api/shortlink/admin/user") && Objects.equals(method, "POST"))) {
                String username = httpServletRequest.getHeader("username");
                String token = httpServletRequest.getHeader("token");
                Object userInfoJsonStr;
                try {
                    if (!StrUtil.isAllNotBlank(username, token)) {
                        throw new ClientException(UserErrorCodeEnum.USER_TOKEN_FAIL);
                    }
                    userInfoJsonStr = stringRedisTemplate.opsForHash().get(LOCK_TOKEN_KEY + username, token);
                    if (userInfoJsonStr == null) {
                        throw new ClientException(UserErrorCodeEnum.USER_TOKEN_FAIL);
                    }
                } catch (Exception e) {
                    returnJson((HttpServletResponse) servletResponse, JSON.toJSONString(BaseResponse.failure(new ClientException(UserErrorCodeEnum.USER_TOKEN_FAIL))));
                    return;
                }
                UserInfoDTO userInfoDTO = JSON.parseObject(userInfoJsonStr.toString(), UserInfoDTO.class);
                UserContext.setUser(userInfoDTO);
            }
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.removeUser();
        }
    }

    private void returnJson(HttpServletResponse response, String json) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(json);
        }
    }
}