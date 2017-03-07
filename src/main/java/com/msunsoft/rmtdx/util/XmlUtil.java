/**
 * Copyright (C) 2016 山东众阳软件有限公司
 * 版权所有。
 *
 * 文件名：.java
 * 文件功能描述： xml操作工具类
 *
 *
 *
 * 创建标识： 李志强  2016-10-26
 * 创建内容： 系统框架和注释
 *
 *
 * 修改标识：
 * 修改原因：
 *
 */
package com.msunsoft.rmtdx.util;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;

/**
 * xml操作工具类
 */
public class XmlUtil {
    /**
     * 获取XML文档的字符串
     *
     * @param document
     * @return
     * @throws java.io.IOException
     */
    public static String getString(Document document) throws IOException {
        StringWriter stringWriter = new StringWriter();
        //设置文件编码
        OutputFormat xmlFormat = new OutputFormat();
        xmlFormat.setEncoding("UTF-8");
        // 设置换行
        xmlFormat.setNewlines(true);
        // 生成缩进
        xmlFormat.setIndent(true);
        // 使用4个空格进行缩进, 可以兼容文本编辑器
        xmlFormat.setIndent("    ");
        //创建写文件方法
        XMLWriter xmlWriter = new XMLWriter(stringWriter, xmlFormat);
        //写入文件
        xmlWriter.write(document);
        //关闭
        xmlWriter.close();
        return stringWriter.toString();
    }

    public static String getPacsConfig(String key) {
        return null;
    }
}
