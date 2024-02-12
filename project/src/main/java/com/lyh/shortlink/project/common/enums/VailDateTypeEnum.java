package com.lyh.shortlink.project.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
 *@title VailDateTypeEnum
 *@description 有效期类型
 *@author LYH
 *@version 1.0
 *@create 2024/2/9 15:12
 */
@Getter
@RequiredArgsConstructor
public enum VailDateTypeEnum {
    /**
     * 永久有效期
     */
    PERMANENT(0),

    /**
     * 自定义有效期
     */
    CUSTOM(1);

    private final int type;
}
