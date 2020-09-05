package com.tyl.pachong.http;

import com.tyl.pachong.config.TemplateConfig;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public final class SendHttpUtil {

    public static void main(String[] args) {
        postItPaChong("1", "发");
    }

    public static void postItPaChong(String categoryId, String templateCode) {
        List<BasicNameValuePair> parames = new ArrayList<>();
        parames.add(new BasicNameValuePair("categoryId", categoryId));
        parames.add(new BasicNameValuePair("templateCode", templateCode));
        postIt(TemplateConfig.url, parames);
    }

    public static void postIt(String url, List<BasicNameValuePair> parames) {
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                // 创建一个提交数据的容器
//                List<BasicNameValuePair> parames = new ArrayList<>();
//                parames.add(new BasicNameValuePair("categoryId", "001"));
//                parames.add(new BasicNameValuePair("templateCode", "测试"));

                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(parames, "UTF-8"));
                httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=\"UTF-8\"");
                httpPost.setHeader("Cache-Control","max-age=0");

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
            System.out.println("SendHttpUtil发生错误");
        }
    }
}
