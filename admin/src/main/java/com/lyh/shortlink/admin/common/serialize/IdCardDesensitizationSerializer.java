package com.lyh.shortlink.admin.common.serialize;

/*
 *@title IdCardDesensitizationSerializer
 *@description
 *@author LYH
 *@version 1.0
 *@create 2024/1/24 15:50
 */
import cn.hutool.core.util.DesensitizedUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 身份证号脱敏反序列化
 */
public class IdCardDesensitizationSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String idCard, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String phoneDesensitization = DesensitizedUtil.idCardNum(idCard, 4, 4);
        jsonGenerator.writeString(phoneDesensitization);
    }
}