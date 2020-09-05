package com.tyl.pachong.http;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class HttpRequestPostServiceImpl{
    static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static String doPostHttpRequest(String url, Map<String, String> headerMap, String requestBody) {
        String entityStr = null;
        CloseableHttpResponse response = null;
        try {
            HttpPost post = new HttpPost(url);
            //添加头部信息
            for (Map.Entry<String, String> header : headerMap.entrySet()) {
                post.addHeader(header.getKey(), header.getValue());
            }
            HttpEntity entity = new StringEntity(requestBody, "UTF-8");
            System.out.println("请求体是：" + requestBody);
            post.setEntity(entity);
            response = httpClient.execute(post);
            // 获得响应的实体对象
            HttpEntity httpEntity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            entityStr = EntityUtils.toString(httpEntity, "UTF-8");
            System.out.println("POST请求路径：" + post);
            System.out.println("POST请求结果：" + entityStr);
        } catch (ClientProtocolException e) {
            System.err.println("Http协议出现问题");
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("解析错误");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO异常");
            e.printStackTrace();
        }
        return entityStr;
    }

    public static void main(String[] args) {
        //TODO 测试inputstream能不能读中文
        doPost1("http://localhost:8080/esmartxx/web/mi/pcSaveUeditorContentTemplate","1","哈哈");
    }
    public static void doPost(String url,String categoryId,String templateCode){
        Map<String, String> map=new LinkedHashMap<String, String>();
        map.put("categoryId",categoryId);
        map.put("templateCode",templateCode);
        doPostHttpRequest(url, map ,"哈");
    }
    public static void doPost1(String url,String categoryId,String templateCode){
        Map<String, String> map=new LinkedHashMap<String, String>();
//        map.put("categoryId",categoryId);
//        map.put("templateCode",templateCode);
        doPostHttpRequest(url, map ,"{\"categoryId\":\""+categoryId+"\",\"templateCode\":\""+templateCode+"\"}");
    }
}
