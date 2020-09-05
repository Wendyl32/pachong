package com.tyl.pachong.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpTest {
    static String  uri = "http://localhost:8080/esmartxx/web/mi/pcSaveUeditorContentTemplate";

    /**
     * Get方法
     */

    public void test1() {
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                HttpGet httpGet = new HttpGet(uri + "/test1?code=001&name=测试");

                client = HttpClients.createDefault();
                response = client.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Post发送form表单数据
     */

    public static void main(String[] args) {
        test2();
    }
    public static void test2() {
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                // 创建一个提交数据的容器
                List<BasicNameValuePair> parames = new ArrayList<>();
                parames.add(new BasicNameValuePair("categoryId", "001"));
                parames.add(new BasicNameValuePair("templateCode", "测试"));

                HttpPost httpPost = new HttpPost(uri + "");
//                httpPost.setEntity(new StringEntity("categoryId=hello&templateCode=发","UTF-8"));
                httpPost.setEntity(new UrlEncodedFormEntity(parames, "UTF-8"));
                httpPost.setHeader("Content-Type","application/x-www-form-urlencoded; charset=\"UTF-8\"");


                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                System.out.println("?::?"+result);

            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Post发送json数据
     */

    public void test3() {
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> data = new HashMap<String, Object>();
                data.put("code", "001");
                data.put("name", "测试");

                HttpPost httpPost = new HttpPost(uri + "/test2");
                httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
                httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(data),
                        ContentType.create("text/json", "UTF-8")));

                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
