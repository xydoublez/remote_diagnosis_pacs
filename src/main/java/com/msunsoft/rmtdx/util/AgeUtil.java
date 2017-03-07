package com.msunsoft.rmtdx.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Copyright (C) 2016 山东众阳软件有限公司
 * 版权所有。
 * <p>
 * 文件名：
 * 文件功能描述：计算年龄的工具类
 * <p>
 * <p>
 * <p>
 * 创建标识： 李志强  2016/12/16 11:44
 * 创建内容： 系统框架和注释
 * <p>
 * <p>
 * 修改标识：
 * 修改原因：
 *
 * @author 李志强
 */
public class AgeUtil {

    /**
     * 岁
     */
    public static final String YEARS = "岁";

    /**
     * 月
     */
    public static final String MONTH = "月";
    /**
     * 周
     */
    public static final String WEEK = "周";
    /**
     * 天
     */
    public static final String DAY = "天";
    /**
     * 小时
     */
    public static final String HOUR = "时";
    /**
     * 分钏
     */
    public static final String MINUTE = "分";

    /**
     * 获取年龄
     *
     * @param birthday 年龄
     * @param ageUnit  是否返回年龄单位
     * @return 若ageUnit为true，则仅返回 年龄单位
     */
    public static final String getAge(Date birthday, boolean ageUnit) {
        String unit = YEARS;
        int age = 0;
        Calendar c1 = Calendar.getInstance();
        long nowmillSeconds = c1.getTimeInMillis();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(birthday);
        long birmillSeconds = c2.getTimeInMillis();
        Calendar c3 = Calendar.getInstance();
        long millis = nowmillSeconds - birmillSeconds;
        c3.setTimeInMillis(millis);
        int year = c3.get(Calendar.YEAR);
        int month = c3.get(Calendar.MONTH);
        int day = c3.get(Calendar.DAY_OF_MONTH);
        int hour = c3.get(Calendar.HOUR_OF_DAY);
        if (year > 1970) {
            age = year - 1970;
            unit = YEARS;
        } else if (month > Calendar.JANUARY) {
            age = month - Calendar.JANUARY;
            unit = MONTH;
        } else if (day > 1) {
            age = day - 1;
            unit = DAY;
        } else {
            age = 1;
            unit = DAY;
        }
        if (ageUnit) {
            return unit;
        } else {
            return String.valueOf(age);
        }
    }

}
