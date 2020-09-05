package com.tyl.pachong;

import com.alibaba.fastjson.JSON;
import com.tyl.pachong.config.NameAndId;
import com.tyl.pachong.config.NameAndUrl;
import com.tyl.pachong.http.SendHttpUtil;
import com.tyl.pachong.model.Template;
import com.tyl.pachong.util.GetJson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import static com.tyl.pachong.config.TemplateConfig.PAGE_SIZE;

public class TemplateQuest {
    public static void main(String[] args) {
        /*
        //TODO  获得Map并循环分解,k是中文标题，v是路径
        //TODO  请求路径，获得{data：{count：x}}，赋值最终个数
        //TODO  开启多线程（暂不实行）
        //TODO  发起请求，获得多个元素
        //TODO  插入转义字符 \
        //TODO  发送http至localhost：8080 的后台，保存数据
         */


        //TODO  获得Map并循环分解,k是中文标题，v是路径
        Map<String, String> NU = new NameAndUrl().getNU();
        Map<String, String> NI = new NameAndId().getNI();
        NU.forEach((k, v) -> {
            //TODO  请求路径，获得{data：{count：x}}，赋值最终个数
            try {
                int count =  new GetJson().getHttpJson(v, 1).getJSONObject("data").getInt("count");
            for (int start = 0;start < count;){
                //TODO  发起请求，获得多个元素
                JSONObject dayLine = new GetJson().getHttpJson(v+start/PAGE_SIZE, 1);
                JSONObject data = dayLine.getJSONObject("data");
                JSONArray templates = data.getJSONArray("templates");
                List<Template> list = JSON.parseArray(templates.toString(), Template.class);
                if (list.size()==0) break;
                int i = 0; //标志位i，用来阻断保存
                for (Template template : list) {
                    if (start + i == count) break;
                    i++;
                    //TODO  插入转义字符 \ -----------------start
//                    StringBuilder RA = new StringBuilder(template.getRenderer_accelerate());
//                    for (int j = RA.length() - 1; j > 1; j--) {
//                        if (RA.charAt(j) == (char) 34) {
//                            RA.insert(j, (char) 92);
//                        }
//                    }
//                    template.setRenderer_accelerate(RA.toString());
                    //TODO  插入转义字符 \ -----------------end
                    //TODO 传去客户端保存
                    //TODO  发送http至localhost：8080 的后台，保存数据
                    SendHttpUtil.postItPaChong(NI.get(k), template.getRenderer_accelerate());
                }
                start+= list.size();
                System.out.println("正在爬取中---共抓取:" + start + "条数据");

            }

            } catch (Exception e) {
                e.printStackTrace();
            }



        });


    }
}
