package com.msunsoft.rmtdx.util;

import com.github.stuxuhai.jpinyin.ChineseHelper;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Copyright (C) 2017 山东众阳软件有限公司
 * 版权所有。
 * <p/>
 * 文件名：PinyinUtil.java
 * 文件功能描述：处理拼音的工具类
 * <p/>
 * <p/>
 * <p/>
 * 创建标识： 李志强  2017/2/13 9:16
 * 创建内容： 系统框架和注释
 * <p/>
 * <p/>
 * 修改标识：李志强　2017年2月13日　15时53分
 * 修改原因：完成实现
 *
 * @author 李志强
 */
public class PinyinUtil {

    public PinyinUtil() {
        try {
            PinyinHelper.addPinyinDict("classpath:PinyinDict/pinyin.dict");
            PinyinHelper.addMutilPinyinDict("classpath:PinyinDict/pinyin_multi.dict");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指定字符串拼音简码
     *
     * @param str
     * @return
     * @throws com.github.stuxuhai.jpinyin.PinyinException
     */
    public static String getShort(String str) throws PinyinException {
        if (ChineseHelper.containsChinese(str)) {
            return PinyinHelper.getShortPinyin(str);
        } else {
            return str;
        }
    }

    /**
     * 获取指定字符串拼音简码数组　即支持多音字
     *
     * @param str
     * @return
     */
    public static String[] getShortMulti(String str) throws PinyinException {
        StringBuilder result = new StringBuilder();
        //多音字数量
        int multiCount = 1;
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            if (ChineseHelper.isChinese(c)) {
                String[] hanziPinyin = PinyinHelper.convertToPinyinArray(c, PinyinFormat.WITHOUT_TONE);
                if (hanziPinyin != null && hanziPinyin.length > 1) {
                    multiCount *= hanziPinyin.length;
                }
            }
        }
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            int j = 0;
            while (j < multiCount) {
                // 首先判断是否为汉字或者〇，不是的话直接将该字符返回
                if (!ChineseHelper.isChinese(c) && c != '〇') {
                    result.append(c);
                    j++;
                } else {
                    String[] pinyinArray = PinyinHelper.convertToPinyinArray(c, PinyinFormat.WITHOUT_TONE);
                    if (pinyinArray.length > 1) {
                        //多音字
                        for (int k = 0, len1 = pinyinArray.length; k < len1; k++) {
                            //取第一个字母，为获取简拼
                            result.append(pinyinArray[k].charAt(0));
                            j++;
                        }
                    } else {
                        //非多音字
                        result.append(pinyinArray[0].charAt(0));
                        j++;
                    }
                }
                if (j == multiCount) {
                    result.append(",");
                }

            }

        }
        result.substring(0, result.length() - 1);
        String[] temp = String.valueOf(result).split(",");
        //最后处理，并返回最终结果
        result.setLength(0);
        for (int i = 0, len = multiCount; i < len; i++) {
            for (int j = 0, len1 = str.length(); j < len1; j++) {
                result.append(temp[j].charAt(i));
            }
            result.append(',');
        }


        String[] resultArray = String.valueOf(result).split(",");
        //数组去重处理
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < resultArray.length; i++) {
            set.add(resultArray[i]);
        }
        return set.toArray(new String[set.size()]);
    }

    /**
     * 获取指定字符串拼音全码
     *
     * @param str
     * @return
     * @throws com.github.stuxuhai.jpinyin.PinyinException
     */
    public static String getFull(String str) throws PinyinException {
        if (ChineseHelper.containsChinese(str)) {
            return PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITHOUT_TONE);
        } else {
            return str;
        }
    }

    /**
     * 获取指定字符串拼音全码数组　即支持多音字
     *
     * @param str
     * @return
     */
    public static String[] getFullMulti(String str) {
        StringBuilder result = new StringBuilder();
        //多音字数量
        int multiCount = 1;
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            if (ChineseHelper.isChinese(c)) {
                String[] hanziPinyin = PinyinHelper.convertToPinyinArray(c, PinyinFormat.WITHOUT_TONE);
                if (hanziPinyin != null && hanziPinyin.length > 1) {
                    multiCount *= hanziPinyin.length;
                }
            }
        }
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            int j = 0;
            while (j < multiCount) {
                // 首先判断是否为汉字或者〇，不是的话直接将该字符返回
                if (!ChineseHelper.isChinese(c) && c != '〇') {
                    result.append(c);
                    j++;
                } else {
                    String[] pinyinArray = PinyinHelper.convertToPinyinArray(c, PinyinFormat.WITHOUT_TONE);
                    if (pinyinArray.length > 1) {
                        //多音字
                        for (int k = 0, len1 = pinyinArray.length; k < len1; k++) {
                            //取第一个字母，为获取简拼
                            result.append(pinyinArray[k]).append(",");
                            j++;
                        }
                    } else {
                        //非多音字
                        result.append(pinyinArray[0]).append(",");
                        j++;
                    }
                }
                if (j == multiCount) {
                    result.append("#");
                }

            }

        }
        result.substring(0, result.length() - 1);
        String[] temp = String.valueOf(result).split("#");
        //最后处理，并返回最终结果
        result.setLength(0);
        for (int i = 0, len = multiCount; i < len; i++) {
            for (int j = 0, len1 = str.length(); j < len1; j++) {
                String[] tempArr = temp[j].split(",");
                result.append(tempArr[i]);
            }
            result.append('#');
        }
        String[] resultArray = String.valueOf(result).split("#");
        //数组去重处理
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < resultArray.length; i++) {
            set.add(resultArray[i]);
        }
        return set.toArray(new String[set.size()]);
    }
}
