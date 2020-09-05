package com.tyl.pachong.config;

import java.util.HashMap;
import java.util.Map;

public final class NameAndUrl {
    private static Map<String,String> NU;

    public Map<String, String> getNU() {
        return NU;
    }

    public void setNU(Map<String, String> NU) {
        this.NU = NU;
    }

    //TODO 塞url和DB的id进去，给别人一次拿完然后读取数据
    public NameAndUrl(){
        NU=new HashMap<>();
        //标题
        NU.put("基础标题","https://xiumi.us/api/templates?tag_ids=3242&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("框线标题","https://xiumi.us/api/templates?tag_ids=708&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("图片标题","https://xiumi.us/api/templates?tag_ids=739&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("底色标题","https://xiumi.us/api/templates?tag_ids=2443&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("符号标题","https://xiumi.us/api/templates?tag_ids=2050&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("主副标题","https://xiumi.us/api/templates?tag_ids=3006&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("编号标题","https://xiumi.us/api/templates?tag_ids=3119&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("竖排标题","https://xiumi.us/api/templates?tag_ids=542&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
//        NU.put("全部标题","https://xiumi.us/api/templates?tag_ids=3227&tag_category=paper-cp&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");

        //卡片
        NU.put("基础卡片","https://xiumi.us/api/templates?tag_ids=2234&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("框线卡片","https://xiumi.us/api/templates?tag_ids=2692&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("底色卡片","https://xiumi.us/api/templates?tag_ids=356&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("底纹卡片","https://xiumi.us/api/templates?tag_ids=3240&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("图文卡片","https://xiumi.us/api/templates?tag_ids=3241&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("对话/问答","https://xiumi.us/api/templates?tag_ids=72&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("轴线卡片","https://xiumi.us/api/templates?tag_ids=81&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
//        NU.put("全部卡片","https://xiumi.us/api/templates?tag_ids=3228&tag_category=paper-cp&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");

        //图片
//        NU.put("图片","https://xiumi.us/api/templates?tag_ids=3229&tag_category=paper-cp&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("基础图片","https://xiumi.us/api/templates?tag_ids=3320&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("单图","https://xiumi.us/api/templates?tag_ids=20&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("双图","https://xiumi.us/api/templates?tag_ids=1135&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("三图","https://xiumi.us/api/templates?tag_ids=747&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("多图","https://xiumi.us/api/templates?tag_ids=25&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("圆形图","https://xiumi.us/api/templates?tag_ids=2764&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("背景图","https://xiumi.us/api/templates?tag_ids=29&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");

        //布局
//        NU.put("布局","https://xiumi.us/api/templates?tag_ids=3230&tag_category=paper-cp&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("基础布局","https://xiumi.us/api/templates?tag_ids=35&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("组合","https://xiumi.us/api/templates?tag_ids=3235&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("表格","https://xiumi.us/api/templates?tag_ids=3236&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("滑动","https://xiumi.us/api/templates?tag_ids=78&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("SVG互动","https://xiumi.us/api/templates?tag_ids=897&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");

        //引导
//        NU.put("引导","https://xiumi.us/api/templates?tag_ids=3231&tag_category=paper-cp&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("关注和原文","https://xiumi.us/api/templates?tag_ids=34&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("二维码名片","https://xiumi.us/api/templates?tag_ids=76&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");

        //组件
//        NU.put("组件","https://xiumi.us/api/templates?tag_ids=3232&tag_category=paper-cp&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("分割线","https://xiumi.us/api/templates?tag_ids=32&tag_category&q&template_category=paper-cp&template_category=booklet-cp&template_category=material-img&sort=DESC&limit=20&page=0");
        NU.put("贴纸","https://xiumi.us/api/templates?tag_ids=68&tag_category&q&template_category=paper-cp&template_category=booklet-cp&template_category=material-img&sort=DESC&limit=20&page=0");
        NU.put("SVG贴纸","https://xiumi.us/api/templates?tag_ids=70&tag_category&q&template_category=paper-cp&template_category=booklet-cp&template_category=material-img&sort=DESC&limit=20&page=0");
        NU.put("零件","https://xiumi.us/api/templates?tag_ids=66&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("视频","https://xiumi.us/api/templates?tag_ids=71&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("小程序","https://xiumi.us/api/templates?tag_ids=14145&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
        NU.put("表单组件","https://xiumi.us/api/templates?tag_ids=79&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");


//        //热门
////        NU.put("热门","https://xiumi.us/api/templates?tag_ids=3233&tag_category=paper-cp&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
//        NU.put("校园","https://xiumi.us/api/templates?tag_ids=771&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
//        NU.put("简约","https://xiumi.us/api/templates?tag_ids=671&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
//        NU.put("秋天","https://xiumi.us/api/templates?tag_ids=1126&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
//        NU.put("教师节","https://xiumi.us/api/templates?tag_ids=555&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
//        NU.put("商务","https://xiumi.us/api/templates?tag_ids=2011&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
//        NU.put("党政","https://xiumi.us/api/templates?tag_ids=196&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0");
    }

    public static void main(String[] args) {
        new NameAndUrl().getNU().forEach((k, v)->System.out.println(k+"::"+v));
    }
}
