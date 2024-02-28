package com.lyh.shortlink.admin.remote.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 *@title ShortLinkBatchCreateRespDTO
 *@description 短链接批量创建响应对象
 *@author LYH
 *@version 1.0
 *@create 2024/2/28 19:52
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkBatchCreateRespDTO {

    /**
     * 成功数量
     */
    private Integer total;

    /**
     * 批量创建返回参数
     */
    private List<ShortLinkBaseInfoRespDTO> baseLinkInfos;
}
