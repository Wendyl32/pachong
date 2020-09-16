package com.tyl.pachong;

import com.alibaba.fastjson.JSON;
import com.tyl.pachong.config.NameAndId;
import com.tyl.pachong.config.NameAndUrl;
import com.tyl.pachong.http.SendHttpUtil;
import com.tyl.pachong.model.Template;
import com.tyl.pachong.util.GetJson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static com.tyl.pachong.config.TemplateConfig.PAGE_SIZE;
import static com.tyl.pachong.util.GetImg.*;

//TODO 主要开启功能有     1.下载图片      2.发送http至localhost：8080 的后台，保存数据
//TODO                  3.替换template的 templateCode 中 src 内容文件
//TODO 到相应位置打开/关闭即可


public class TemplateQuest {
    public static void main(String[] args) {
        /*
        //TODO  获得Map并循环分解,k是中文标题，v是路径
        //TODO  请求路径，获得{data：{count：x}}，赋值最终个数
        //TODO  发起请求，获得多个元素
        //TODO  插入转义字符 \
        //TODO  1.下载图片
        //TODO  2.发送http至localhost：8080 的后台，保存数据
        //TODO  3.替换template的 templateCode 中 src 内容文件
         */


        //  获得Map并循环分解,k是中文标题，v是路径
        Map<String, String> NU = new NameAndUrl().getNU();
        Map<String, String> NI = new NameAndId().getNI();
        AtomicInteger AllCount = new AtomicInteger();
        NU.forEach((k, v) -> {
            //  请求路径，获得{data：{count：x}}，赋值最终个数
            try {
                int count = new GetJson().getHttpJson(v, 1).getJSONObject("data").getInt("count");
                for (int start = 0; start < count; ) {
                    //  发起请求，获得多个元素
                    JSONObject dayLine = new GetJson().getHttpJson(v + start / PAGE_SIZE, 1);
                    JSONObject data = dayLine.getJSONObject("data");
                    JSONArray templates = data.getJSONArray("templates");
                    List<Template> list = JSON.parseArray(templates.toString(), Template.class);
                    if (list.size() == 0) break;
                    int i = 0; //标志位i，用来阻断保存
                    for (Template template : list) {
                        if (start + i == count) break;
                        i++;
                        //TODO  1.下载图片
                        getImgFromEntity(template);

                        /*
                        //TODO 3.替换template的 templateCode 中 src 内容文件     （操作的是数据库）
                        Set<String> urls = new HashSet<String>();
                        urls = getUrlsByTemplate(template);
                        for (String url : urls) {
                            // @parameter  b  src里面要改成的字符串
                            // b 是src 里面的东西要替换成的内容
                            //这里的b就是文件名
                            String b = getFilename(url);
                            template.setRenderer_accelerate(template.getRenderer_accelerate().replace(url, b));
                        }
                        */


                        //TODO  2.发送http至localhost：8080 的后台，保存数据
                        SendHttpUtil.postItPaChong(NI.get(k), template.getRenderer_accelerate());
                    }
                    start += list.size();
                    AllCount.addAndGet(list.size());
                    System.out.println("正在爬取中---共抓取:" + start + "条数据");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("总共爬取数据：" + AllCount);
    }

}
