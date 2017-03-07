/**
 * Copyright (C) 2016 山东众阳软件有限公司
 * 版权所有。
 *
 * 文件名：.java
 * 文件功能描述：spring返回json格式数据时，自定义映射类
 *
 *
 *
 * 创建标识： 李志强  2016-10-15
 * 创建内容： 系统框架和注释
 *
 *
 * 修改标识：
 * 修改原因：
 *
 */
package com.msunsoft.rmtdx.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * spring返回json格式数据时，自定义映射类
 */
public class ObjectMappingCustomer extends ObjectMapper {

    public ObjectMappingCustomer() {
        super();
        // 允许单引号
        //this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 字段和值都加引号
        //this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 数字也加引号
        //this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
        //this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.setDateFormat(simpleDateFormat);
        // 空值处理为空串
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

            @Override
            public void serialize(
                    Object value,
                    JsonGenerator jg,
                    SerializerProvider sp) throws IOException {
                jg.writeString("");
            }
        });


    }
}