/**
 * Copyright (C) 2016 山东众阳软件有限公司
 * 版权所有。
 *
 * 文件名：.java
 * 文件功能描述： 获取PacsConfig.xml的配置类
 *
 *
 *
 * 创建标识： 李志强  2016-10-26
 * 创建内容： 系统框架和注释
 *
 *
 * 修改标识：李志强 2017年1月18日
 * 修改原因：添加获取DCM图片站点地址 dcmGetImageSite
 *
 */
package com.msunsoft.rmtdx.util;

/**
 * 获取PacsConfig.xml的配置类
 */
public class PacsConfig {
    private String pacsAppIp;
    private String hisAppIp;
    private String lisAppIp;
    private String lisPath;
    private String emrAppIp;
    private String pacsServerPort;
    /**
     * 1则业务独立模式 （彼此分开独立）如沂南 2则业务共用模式（即分院下检查申请可以到总院来做）如兖州，莒县人民医院
     */
    private String areaModel;
    private String medicalViewerXml;
    private String pacsServiceUrl;
    private String hisServiceCardPayUrl;
    private String hisLabServiceUrl;
    private String hisOutCallUrl;
    private String mobileUrl;
    private String tjServiceUrl;
    /**
     * 是否上新体检系统
     */
    private boolean openTj;
    /**
     * 获取DCM图片站点地址
     */
    private String dcmGetImageSite;
    public String getPacsAppIp() {
        return pacsAppIp;
    }

    public void setPacsAppIp(String pacsAppIp) {
        this.pacsAppIp = pacsAppIp;
    }

    public String getHisAppIp() {
        return hisAppIp;
    }

    public void setHisAppIp(String hisAppIp) {
        this.hisAppIp = hisAppIp;
    }

    public String getLisAppIp() {
        return lisAppIp;
    }

    public void setLisAppIp(String lisAppIp) {
        this.lisAppIp = lisAppIp;
    }

    public String getLisPath() {
        return lisPath;
    }

    public void setLisPath(String lisPath) {
        this.lisPath = lisPath;
    }

    public String getEmrAppIp() {
        return emrAppIp;
    }

    public void setEmrAppIp(String emrAppIp) {
        this.emrAppIp = emrAppIp;
    }

    public String getPacsServerPort() {
        return pacsServerPort;
    }

    public void setPacsServerPort(String pacsServerPort) {
        this.pacsServerPort = pacsServerPort;
    }

    /**
     * 1则业务独立模式 （彼此分开独立）如沂南 2则业务共用模式（即分院下检查申请可以到总院来做）如兖州，莒县人民医院
     * @return
     */
    public String getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(String areaModel) {
        this.areaModel = areaModel;
    }

    public String getMedicalViewerXml() {
        return medicalViewerXml;
    }

    public void setMedicalViewerXml(String medicalViewerXml) {
        this.medicalViewerXml = medicalViewerXml;
    }

    public String getPacsServiceUrl() {
        return pacsServiceUrl;
    }

    public void setPacsServiceUrl(String pacsServiceUrl) {
        this.pacsServiceUrl = pacsServiceUrl;
    }

    public String getHisServiceCardPayUrl() {
        return hisServiceCardPayUrl;
    }

    public void setHisServiceCardPayUrl(String hisServiceCardPayUrl) {
        this.hisServiceCardPayUrl = hisServiceCardPayUrl;
    }

    public String getHisLabServiceUrl() {
        return hisLabServiceUrl;
    }

    public void setHisLabServiceUrl(String hisLabServiceUrl) {
        this.hisLabServiceUrl = hisLabServiceUrl;
    }

    public String getHisOutCallUrl() {
        return hisOutCallUrl;
    }

    public void setHisOutCallUrl(String hisOutCallUrl) {
        this.hisOutCallUrl = hisOutCallUrl;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public String getTjServiceUrl() {
        return tjServiceUrl;
    }

    public void setTjServiceUrl(String tjServiceUrl) {
        this.tjServiceUrl = tjServiceUrl;
    }

    public boolean isOpenTj() {
        return openTj;
    }

    public void setOpenTj(boolean openTj) {
        this.openTj = openTj;
    }

    /**
     * 获取采集图片站点地址
     * @return
     */
    public String getDcmGetImageSite() {
        return dcmGetImageSite;
    }

    public void setDcmGetImageSite(String dcmGetImageSite) {
        this.dcmGetImageSite = dcmGetImageSite;
    }
}
