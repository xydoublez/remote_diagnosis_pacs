/**
 * Copyright (C) 2016 山东众阳软件有限公司
 * 版权所有。
 *
 * 文件名：.java
 * 文件功能描述： 类
 *
 *
 *
 * 创建标识： 李志强  2016-10-28
 * 创建内容： 系统框架和注释
 *
 *
 * 修改标识：
 * 修改原因：
 *
 */
package com.msunsoft.rmtdx.util;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 调用webService,restfulapi 的工具类
 */
public class WebServiceUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceUtil.class);
    private static final JaxWsDynamicClientFactory FACTORY = JaxWsDynamicClientFactory.newInstance();

    /**
     * 动态调用webService
     *
     * @param webServiceUrl
     * @param webServiceMehtodName
     * @param webServiceArgs
     * @return
     */
    public static final Object[] invokeService(String webServiceUrl, String methodName, Object...  webServiceArgs) {
        Client client = FACTORY.createClient(webServiceUrl);
        try {
            Object[] obj = client.invoke(methodName, webServiceArgs);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 调用webService中的方法
     *
     * @param client
     * @param method
     * @param args
     * @return
     * @throws Exception
     */
    public static final Object[] invokeMethod(Client client, String methodName, Object... args) throws Exception {

        HTTPConduit http = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(3000);  //连接超时
        httpClientPolicy.setAllowChunking(false);    //取消块编码
        httpClientPolicy.setReceiveTimeout(3000);     //响应超时
        http.setClient(httpClientPolicy);
        LOGGER.info("开始调用webService接口方法{},参数为{}", methodName, args);
        Object[] objects = client.invoke(methodName, args);
        LOGGER.info("结束调用webService接口方法{},参数为{},结果为：{}", methodName,  args,  objects);
        return objects;
    }

    /**
     * 调用restful WebApi方法
     * //TODO 实现调用restful WebApi方法
     * @param url
     * @param args
     * @return
     */
    public static final Object[] invokeApi(String url, String args) {
        return null;
    }

}
