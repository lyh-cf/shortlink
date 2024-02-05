package com.lyh.shortlink.admin.remote;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkCreateReqDTO;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkPageReqDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShorLinkPageRespDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkCreateRespDTO;

import java.util.HashMap;
import java.util.Map;

/*
 *@title ShortLinkRemoteService
 *@description 短链接中台远程调用服务
 *@author LYH
 *@version 1.0
 *@create 2024/2/5 20:42
 */
public interface ShortLinkRemoteService {
    default Result<ShortLinkCreateRespDTO> createShortLink(ShortLinkCreateReqDTO requestParam){
        String resultBodyStr = HttpUtil.post("http://127.0.0.1:8001/api/shortlink/project/create", JSON.toJSONString(requestParam));
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {
        });
    }
    default Result<IPage<ShorLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        Map<String, Object> requstMap = new HashMap<>();
        requstMap.put("gid", requestParam.getGid());
        requstMap.put("current", requestParam.getCurrent());
        requstMap.put("size", requestParam.getSize());
        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/shortlink/project/page", requstMap);
        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }
}
