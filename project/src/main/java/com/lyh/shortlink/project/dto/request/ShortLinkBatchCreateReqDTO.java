package com.lyh.shortlink.project.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/*
 *@title ShortLinkBatchCreateReqDTO
 *@description 短链接批量创建请求对象
 *@author LYH
 *@version 1.0
 *@create 2024/2/28 19:53
 */
@Data
public class ShortLinkBatchCreateReqDTO {

    /**
     * 原始链接集合
     */
    private List<String> originUrls;

    /**
     * 描述集合
     */
    private List<String> describes;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 创建类型 0：接口创建 1：控制台创建
     */
    private Integer createdType;

    /**
     * 有效期类型 0：永久有效 1：自定义
     */
    private Integer validDateType;

    /**
     * 有效期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;
}
