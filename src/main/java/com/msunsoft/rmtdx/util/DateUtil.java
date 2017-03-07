/**
 * Copyright (C) 2016 山东众阳软件有限公司
 * 版权所有。
 *
 * 文件名：.java
 * 文件功能描述： 类
 *
 *
 *
 * 创建标识： 李志强  2016-10-13
 * 创建内容： 系统框架和注释
 *
 *
 * 修改标识：
 * 修改原因：
 *
 */
package com.msunsoft.rmtdx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式工具类
 */
public class DateUtil {
    /**
     * 返回当前日期yyyy-MM-dd HH:mm:ss格式的字符串
     *
     * @return
     */
    public static String dateTimeNow(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * 返回指定日期格式的字符串
     *
     * @return
     */
    public static String toStr(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }
    /**
     * 返回指定日期yyyy-MM-dd HH:mm:ss格式的字符串
     *
     * @return
     */
    public static String toStr(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
    /**
     * 返回当前日期添加指定天数后的日期
     *
     * @return
     */
    public static Date addDay(Integer day) {
        Date date = new Date();
        return new Date(date.getTime() + day * 24 * 60 * 60 * 1000);

    }

    /**
     * 返回当前日期减去指定天数后的日期
     *
     * @param day
     * @return
     */
    public static Date minusDay(Integer day) {
        Date date = new Date();
        return new Date(date.getTime() - day * 24 * 60 * 60 * 1000);
    }

    /**
     * 将字符串yyyy-MM-dd HH:mm:ss解析成日期
     *
     * @param date
     * @return
     */
    public static Date parse(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将指定格式的字符串解析成日期
     * @param date
     * @param format yyyy-MM-dd
     * @return
     */
    public static Date parse(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (Exception e) {
            return null;
        }
    }
}
