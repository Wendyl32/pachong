package com.tyl.pachong.config;

import java.util.HashMap;

public class ImgConfig {
    public final static String storePath = "E:\\store";

    //通过http或者https连接
    public final static String connectHttp = "http:";
    public final static String connectHttps = "https:";


    //浏览器的头文件Map
    public final static HashMap<String,String> ChromeMap = new HashMap<>();

    private ImgConfig(){
        ChromeMap.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        ChromeMap.put("Accept-Encoding","gzip, deflate");
        ChromeMap.put("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8");
        ChromeMap.put("Cache-Control","max-age=0");
        ChromeMap.put("Connection","keep-alive");
        ChromeMap.put("Cookie","_ga=GA1.2.293316840.1598685017");
        ChromeMap.put("Host","statics.xiumi.us");
        ChromeMap.put("If-Modified-Since","Tue, 01 Sep 2020 02:12:53 GMT");
        ChromeMap.put("If-None-Match","AC58137C5B1632C8F70093F2FB428BD4");
        ChromeMap.put("Upgrade-Insecure-Requests","");
        ChromeMap.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.83 Safari/537.36");
    }


}
