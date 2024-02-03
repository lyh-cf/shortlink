package com.lyh.shortlink.project.common.convention.errorcode;

/*
 *@title IErrorCode
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 10:33
 */
/**
 * 平台错误码
 */
public interface IErrorCode {

    /**
     * 错误码
     */
    String code();

    /**
     * 错误信息
     */
    String message();
}