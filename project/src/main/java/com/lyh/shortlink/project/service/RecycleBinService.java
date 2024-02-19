package com.lyh.shortlink.project.service;

import com.lyh.shortlink.project.dto.request.RecycleBinSaveReqDTO;

/*
 *@title RecycleBinService
 *@description 回收站管理接口层
 *@author LYH
 *@version 1.0
 *@create 2024/2/19 21:25
 */
public interface RecycleBinService {
    /**
     * 保存回收站
     *
     * @param requestParam 请求参数
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);
}
