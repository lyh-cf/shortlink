package com.lyh.shortlink.project.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lyh.shortlink.project.common.convention.result.Result;
import com.lyh.shortlink.project.dto.request.ShortLinkCreateReqDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkCreateRespDTO;

/*
 *@title CustomBlockHandler
 *@description 自定义流控策略
 *@author LYH
 *@version 1.0
 *@create 2024/3/1 15:36
 */
public class CustomBlockHandler {
    public static Result<ShortLinkCreateRespDTO> createShortLinkBlockHandlerMethod(ShortLinkCreateReqDTO requestParam, BlockException exception) {
        return new Result<ShortLinkCreateRespDTO>().setCode("B100000").setMessage("当前访问网站人数过多，请稍后再试...");
    }
}
