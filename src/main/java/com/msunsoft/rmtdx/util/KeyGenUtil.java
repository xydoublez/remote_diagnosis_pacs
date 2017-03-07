package com.msunsoft.rmtdx.util;

import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/**
 * Copyright (C) 2016 山东众阳软件有限公司
 * 版权所有。
 * <p>
 * 文件名：KeyGenUtil
 * 文件功能描述：缓存key自定义类
 * <p>
 * <p>
 * <p>
 * 创建标识： 李志强  2016/12/20 16:02
 * 创建内容： 系统框架和注释
 * <p>
 * <p>
 * 修改标识：
 * 修改原因：
 *
 * @author 李志强
 */

public class KeyGenUtil extends SimpleKeyGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeyGenUtil.class);
    // custom cache key
    private static final int NO_PARAM_KEY = 0;
    private static final int NULL_PARAM_KEY = 53;

    @Override
    public Object generate(Object target, Method method, Object... params) {

        StringBuilder key = new StringBuilder();
        key.append(target.getClass().getSimpleName()).append(".").append(method.getName()).append(":");
        if (params.length == 0) {
            return key.append(NO_PARAM_KEY).toString();
        }
        for (Object param : params) {
            if (param == null) {
                LOGGER.warn("input null param for Spring cache, use default key={}", NULL_PARAM_KEY);
                key.append(NULL_PARAM_KEY);
            } else if (ClassUtils.isPrimitiveArray(param.getClass())) {
                int length = Array.getLength(param);
                for (int i = 0; i < length; i++) {
                    key.append(Array.get(param, i));
                    key.append(',');
                }
            } else if (ClassUtils.isPrimitiveOrWrapper(param.getClass()) || param instanceof String) {
                key.append(param);
            } else {
                LOGGER.warn("Using an object as a cache key may lead to unexpected results. " +
                        "Either use @Cacheable(key=..) or implement CacheKey. Method is " + target.getClass() + "#" + method.getName());
                key.append(param.hashCode());
            }
            key.append('-');
        }

        String finalKey = key.toString();
        long cacheKeyHash = Hashing.murmur3_128().hashString(finalKey, Charset.defaultCharset()).asLong();
        LOGGER.debug("using cache key={} hashCode={}", finalKey, cacheKeyHash);
        return key.toString();
    }
}