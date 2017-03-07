/**
 * Copyright (C) 2016 山东众阳软件有限公司
 * 版权所有。
 *
 * 文件名：.java
 * 文件功能描述： 类
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
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * Created by Administrator on 2016-10-26.
 */
public class XmlConfigReader {
    //勤汉式。
    //私有的静态的成员变量。
    private static XmlConfigReader instance = new XmlConfigReader();

    //PacsConfig相关配置信息对象。
    private PacsConfig pacsConfig = new PacsConfig();

    //私有的构造方法。
    private XmlConfigReader() {
        SAXReader reader = new SAXReader();

        //拿到当前线程。
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("PacsConfig.xml");
        try {
            Document doc = reader.read(in);

            Element pacsIp = (Element) doc.selectObject("/configuration/appSettings/add[@key='pacsappip']");
            Element serverPot = (Element) doc.selectObject("/configuration/appSettings/add[@key='PACS_SERVER_PORT']");
            Element hisIp = (Element) doc.selectObject("/configuration/appSettings/add[@key='hisappip']");
            Element emrIp = (Element) doc.selectObject("/configuration/appSettings/add[@key='emrappip']");
            Element lisIp = (Element) doc.selectObject("/configuration/appSettings/add[@key='lisappip']");
            Element lisPath = (Element) doc.selectObject("/configuration/appSettings/add[@key='lispath']");
            Element areaModel = (Element) doc.selectObject("/configuration/appSettings/add[@key='AreaModel']");
            Element medicalViewerXml = (Element) doc.selectObject("/configuration/appSettings/add[@key='MedicalViewerXml']");
            Element pacsServiceUrl = (Element) doc.selectObject("/configuration/appSettings/add[@key='PacsServiceUrl']");
            Element hisServiceCardPayUrl = (Element) doc.selectObject("/configuration/appSettings/add[@key='HisServiceCardPayUrl']");
            Element hisLabServiceUrl = (Element) doc.selectObject("/configuration/appSettings/add[@key='HisLabServiceUrl']");
            Element hisOutCallUrl = (Element) doc.selectObject("/configuration/appSettings/add[@key='HisOutCallUrl']");
            Element mobileUrl = (Element) doc.selectObject("/configuration/appSettings/add[@key='MobileUrl']");
            Element tjUrl = (Element) doc.selectObject("/configuration/appSettings/add[@key='TjServiceUrl']");
            Element isOpenTj = (Element) doc.selectObject("/configuration/appSettings/add[@key='IsOpenTj']");
            Element dcmGetImageSite = (Element) doc.selectObject("/configuration/appSettings/add[@key='DcmGetImageSite']");


            pacsConfig.setPacsAppIp(pacsIp.attribute("value").getValue());
            pacsConfig.setPacsServerPort(serverPot.attribute("value").getValue());
            pacsConfig.setEmrAppIp(emrIp.attribute("value").getValue());
            pacsConfig.setHisAppIp(hisIp.attribute("value").getValue());
            pacsConfig.setLisAppIp(lisIp.attribute("value").getValue());
            pacsConfig.setLisPath(lisPath.attribute("value").getValue());
            pacsConfig.setAreaModel(areaModel.attribute("value").getValue());
            pacsConfig.setMedicalViewerXml(medicalViewerXml.attribute("value").getValue());
            pacsConfig.setPacsServiceUrl(pacsServiceUrl.attribute("value").getValue());
            pacsConfig.setHisLabServiceUrl(hisLabServiceUrl.attribute("value").getValue());
            pacsConfig.setHisServiceCardPayUrl(hisServiceCardPayUrl.attribute("value").getValue());
            pacsConfig.setHisOutCallUrl(hisOutCallUrl.attribute("value").getValue());
            pacsConfig.setMobileUrl(mobileUrl.attribute("value").getValue());
            pacsConfig.setTjServiceUrl(tjUrl.attribute("value").getValue());
            pacsConfig.setOpenTj(isOpenTj.attribute("value").getValue().equals("1") ? true : false);
            pacsConfig.setDcmGetImageSite(dcmGetImageSite.attribute("value").getValue());


        } catch (DocumentException e) {
            // 打印错误
            e.printStackTrace();
        }

    }

    //公共的静态的入口方法。
    public static XmlConfigReader getInstance() {
        return instance;
    }

    /**
     * 返回PacsConfig相关配置。
     *
     * @return
     */
    public PacsConfig getPacsConfig() {

        return pacsConfig;
    }

}
