package com.lyh.shortlink.admin.remote;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyh.shortlink.admin.common.convention.result.Result;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkBatchCreateReqDTO;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkCreateReqDTO;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkPageReqDTO;
import com.lyh.shortlink.admin.remote.dto.request.ShortLinkUpdateReqDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkBatchCreateRespDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkCreateRespDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkGroupCountQueryRespDTO;
import com.lyh.shortlink.admin.remote.dto.response.ShortLinkPageRespDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@title ShortLinkRemoteService
 *@description 短链接中台远程调用服务
 *@author LYH
 *@version 1.0
 *@create 2024/2/5 20:42
 */
public interface ShortLinkRemoteService {
    /**
     * 创建短链接
     */
    default Result<ShortLinkCreateRespDTO> createShortLink(ShortLinkCreateReqDTO requestParam) {
        String resultBodyStr = HttpUtil.post("http://127.0.0.1:8001/api/shortlink/project/create", JSON.toJSONString(requestParam));
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {
        });
    }
    /**
     * 批量创建短链接
     *
     * @param requestParam 批量创建短链接请求参数
     * @return 短链接批量创建响应
     */
    default Result<ShortLinkBatchCreateRespDTO> batchCreateShortLink(ShortLinkBatchCreateReqDTO requestParam) {
        String resultBodyStr = HttpUtil.post("http://127.0.0.1:8001/api/shortlink/project/create/batch", JSON.toJSONString(requestParam));
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {
        });
    }

    /**
     * 修改短链接
     */
    default void updateShortLink(ShortLinkUpdateReqDTO requestParam) {
        HttpUtil.post("http://127.0.0.1:8001/api/shortlink/project/update", JSON.toJSONString(requestParam));
    }

    /**
     * 分页查询短链接
     */
    default Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        Map<String, Object> requstMap = new HashMap<>();
        requstMap.put("orderTag",requestParam.getOrderTag());
        requstMap.put("gid", requestParam.getGid());
        requstMap.put("current", requestParam.getCurrent());
        requstMap.put("size", requestParam.getSize());
        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/shortlink/project/page", requstMap);
        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }

    /**
     * 查询短链接分组内短链接数量
     */
    default Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(List<String> requestParam) {
        Map<String, Object> requstMap = new HashMap<>();
        requstMap.put("requestParam", requestParam);
        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/shortlink/project/count", requstMap);
        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }

    /**
     * 分页查询回收站短链接
     */
    default Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(List<String> gidList, Long current, Long size) {
        Map<String, Object> requstMap = new HashMap<>();
        requstMap.put("gidList", gidList);
        requstMap.put("current", current);
        requstMap.put("size", size);
        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/shortlink/project/recycle-bin/page", requstMap);
        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }
}
