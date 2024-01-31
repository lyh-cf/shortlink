package com.lyh.shortlink.admin.common.exception;

/*
 *@title GlobalExceptionHandler
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 11:14
 */

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.lyh.shortlink.admin.common.convention.errorcode.BaseErrorCodeEnum;
import com.lyh.shortlink.admin.common.convention.result.BaseResponse;
import com.lyh.shortlink.admin.common.convention.result.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.util.StringUtils;
import java.util.Optional;

/**
 * 全局异常处理器
 *
 */
@Component
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截参数验证异常
     */
    @SneakyThrows
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result validExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        FieldError firstFieldError = CollectionUtil.getFirst(bindingResult.getFieldErrors());
        String exceptionStr = Optional.ofNullable(firstFieldError)
                .map(FieldError::getDefaultMessage)
                .orElse(StrUtil.EMPTY);
        log.error("[{}] {} [ex] {}", request.getMethod(), getUrl(request), exceptionStr);
        return BaseResponse.failure(BaseErrorCodeEnum.CLIENT_ERROR.code(), exceptionStr);
    }

    /**
     * 拦截应用内抛出的异常
     */
    //拦截该类及其所有子类的异常
    @ExceptionHandler(value = {AbstractException.class})
    public Result abstractException(HttpServletRequest request, AbstractException ex) {
        if (ex.getCause() != null) {
            //打印样例：[GET] http://127.0.0.1:8002/api/shortlink/user/yh1 [ex] ClientException{code='A000200',message='用户不存在'}
            log.error("[{}] {} [ex] {}", request.getMethod(), request.getRequestURL().toString(), ex, ex.getCause());
            return BaseResponse.failure(ex);
        }
        log.error("[{}] {} [ex] {}", request.getMethod(), request.getRequestURL().toString(), ex.toString());
        return BaseResponse.failure(ex);
    }
    /**
     * 拦截未捕获异常
     */
    @ExceptionHandler(value = Throwable.class)
    public Result defaultErrorHandler(HttpServletRequest request, Throwable throwable) {
        log.error("[{}] {} ", request.getMethod(), getUrl(request), throwable);
        return BaseResponse.failure();
    }

    private String getUrl(HttpServletRequest request) {
        if (StringUtils.hasLength(request.getQueryString())) {
            return request.getRequestURL().toString();
        }
        return request.getRequestURL().toString() + "?" + request.getQueryString();
    }
}