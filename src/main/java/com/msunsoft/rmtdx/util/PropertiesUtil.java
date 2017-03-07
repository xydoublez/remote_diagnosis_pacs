package com.msunsoft.rmtdx.util;

import org.apache.ibatis.io.Resources;

import java.io.Reader;
import java.util.Properties;

/**
 * Copyright (C) 2016 山东众阳软件有限公司
 * 版权所有。
 * <p>
 * 文件名：PropertiesUtil
 * 文件功能描述： 对属性文件操作的工具类
 * <p>
 * <p>
 * <p>
 * 创建标识： 李志强  2016/12/22 15:58
 * 创建内容： 系统框架和注释
 * <p>
 * <p>
 * 修改标识：
 * 修改原因：
 *
 * @author 李志强
 */
public class PropertiesUtil {

    /**
     * 获取db.config.properties文件内容的方法
     *
     * @param key 键值名称
     * @return
     */
    public static String getDbConfigPropertiesKey(String key) {

        try {
            Properties prop = getDbConfigProperties();
            return prop.getProperty(key);
        } catch (Exception e) {
            return "";
        }

    }

    private static Properties getDbConfigProperties() {
        Properties prop = new Properties();
        try {
            Reader reader = Resources.getResourceAsReader("db.config.properties");
            prop.load(reader);
            reader.close();
        } catch (Exception e) {
            return null;
        }
        return prop;
    }
}
