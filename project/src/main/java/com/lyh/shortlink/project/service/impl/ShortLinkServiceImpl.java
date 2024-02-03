package com.lyh.shortlink.project.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.text.StrBuilder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyh.shortlink.project.common.convention.exception.ServiceException;
import com.lyh.shortlink.project.common.enums.ShortLinkErrorCodeEnum;
import com.lyh.shortlink.project.dao.entity.ShortLinkDO;
import com.lyh.shortlink.project.dao.mapper.ShortLinkMapper;
import com.lyh.shortlink.project.dto.request.ShortLinkCreateReqDTO;
import com.lyh.shortlink.project.dto.response.ShortLinkCreateRespDTO;
import com.lyh.shortlink.project.service.ShortLinkService;
import com.lyh.shortlink.project.util.HashUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBloomFilter;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/*
 *@title ShortLinkServiceImpl
 *@description 短链接接口实现层
 *@author LYH
 *@version 1.0
 *@create 2024/2/1 17:04
 */
@Slf4j
@Service
@AllArgsConstructor
public class ShortLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLinkDO> implements ShortLinkService {
    private final RBloomFilter<String> shortUriCreateCachePenetrationBloomFilter;
    @Override
    public ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam) {
        String shortLinkUri=generateShortLinkUri(requestParam);
        String fullShortUrl = StrBuilder.create(requestParam.getDomain())
                .append("/")
                .append(shortLinkUri)
                .toString();
        ShortLinkDO shortLinkDO = ShortLinkDO.builder()
                .domain(requestParam.getDomain())
                .originUrl(requestParam.getOriginUrl())
                .gid(requestParam.getGid())
                .createdType(requestParam.getCreatedType())
                .validDateType(requestParam.getValidDateType())
                .validDate(requestParam.getValidDate())
                .describe(requestParam.getDescribe())
                .shortUri(shortLinkUri)
                .fullShortUrl(fullShortUrl)
                .build();
        try {
            baseMapper.insert(shortLinkDO);
            //唯一索引，重复插入异常
        } catch (DuplicateKeyException ex) {
            throw new ServiceException(String.format("短链接：%s 生成重复", fullShortUrl));
        }
        //添加到布隆过滤器中
        shortUriCreateCachePenetrationBloomFilter.add(fullShortUrl);
        return ShortLinkCreateRespDTO.builder()
                .fullShortUrl(shortLinkDO.getFullShortUrl())
                .originUrl(shortLinkDO.getOriginUrl())
                .gid(shortLinkDO.getGid())
                .build();
    }
    private String generateShortLinkUri(ShortLinkCreateReqDTO requestParam){
        int customGenerateCount=0;//生成次数
        String shortLinkUri;
        while (true){
            if(customGenerateCount>10){
                throw new ServiceException(ShortLinkErrorCodeEnum.LINK_CREATE_FREQUENT_ERROR);
            }
            String originUrl=requestParam.getOriginUrl();
            //降低hash冲突概率
            originUrl+= UUID.randomUUID().toString();
            shortLinkUri=HashUtil.hashToBase62(originUrl);
            if(!shortUriCreateCachePenetrationBloomFilter.contains(requestParam.getDomain()+"/"+shortLinkUri)){
                break;
            }
            customGenerateCount++;
        }
        return shortLinkUri;
    }
}
