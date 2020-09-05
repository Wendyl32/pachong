//package com.tyl.pachong;
//
//import com.alibaba.fastjson.JSON;
//import com.tyl.pachong.http.SendHttpUtil;
//import com.tyl.pachong.model.Template;
//import com.tyl.pachong.util.GetJson;
//import org.apache.ibatis.exceptions.PersistenceException;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.List;
//
//import static com.tyl.pachong.config.TemplateConfig.*;
//
//
//public class TemplateMain {
//    public static void main(String[] args) {
//        //TODO 本地保存
//        /*
//        String resource = "mybatis-config.xml"; //定义配置文件路径
//        InputStream inputStream = null;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);//读取配置文件
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//注册mybatis 工厂
//        SqlSession sqlSession = sqlSessionFactory.openSession();//得到连接对象
//
//
//        TemplateMapper templateMapper = sqlSession.getMapper(TemplateMapper.class);//从mybatis中得到dao对象
//*/
//        int start;//记录数
//        int total = TOTAL;//记录数
//        int end = END;
//        String db_ids = "1301335451511443458";
//        int tag_ids = 3227;
//        for (start = 0; total < end && start <= 210; start += 1) {
//            try {
//                //https://movie.douban.com/explore#!type=movie&tag=%E7%83%AD%E9%97%A8&sort=time&page_limit=20&page_start=0
//                String address = "https://xiumi.us/api/templates?tag_ids=3242&tag_category&q&template_category=paper-cp&template_category=booklet-cp&sort=DESC&limit=20&page=0"+start;
//
//                JSONObject dayLine = new GetJson().getHttpJson(address, 1);
//                System.out.println("dayline:" + dayLine);
//
//                System.out.println("start:" + start);
//                //JSONArray json = dayLine.getJSONArray("templates");
//                //https://blog.csdn.net/Alex19961223/article/details/91955116
//
//                //在data的templates里面挖出来 {"data":{"templates":[{对象},{对象}]}}
//                JSONObject packageJsonObject = dayLine.getJSONObject("data");// 定位到package json对象
//                JSONArray bodyJsonArray = packageJsonObject.getJSONArray("templates");//采用getJSONArray方法， 定位到body json集合
//
//
//                List<Template> list = JSON.parseArray(bodyJsonArray.toString(), Template.class);
//
//                //                System.out.println("TemplateList:"+list.toString());
//
//
//                int i = 0; //标志位i，用来阻断保存
//                for (Template template : list) {
//                    if (start + i == end) break;
//                    i++;
//                    //mysql插入的时候有 insert into """ ,这样插入错误
//                    // TODO 帮冒号插入\ 转义字符 -----------------start
//                    StringBuilder RA = new StringBuilder(template.getRenderer_accelerate());
//                    for (int j = RA.length() - 1; j > 1; j--) {
//                        if (RA.charAt(j) == (char) 34) {
//                            RA.insert(j, (char) 92);
//                        }
//                    }
//                    template.setRenderer_accelerate(RA.toString());
//                    // TODO 帮冒号插入\ 转义字符 -----------------end
////                    templateMapper.insert(template);
////                    sqlSession.commit();
//                    //TODO 传去客户端保存
//                    if (template.getRenderer_accelerate()==null||template.getRenderer_accelerate()=="") break;
//                    SendHttpUtil.postItPaChong(db_ids, template.getRenderer_accelerate());
//                }
//                total += list.size();
//                System.out.println("正在爬取中---共抓取:" + total + "条数据");
//
//
//            } catch (PersistenceException e) {
//                System.out.println("发生了异常");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        //for循环爬完后才关闭
//        System.out.println("已经爬取到底了");
//        //查询
//        /*
////        List<Template> templates = templateMapper.findAll();
//        //查询完才关闭
////        sqlSession.close();
//        //前面使用char做更改，后面使用String类的replaceAll做
//        // TODO 解除\"，将转义字符 \" 改为 "   ----------start
////        templates.forEach(template -> {
////            template.setRenderer_accelerate(template.getRenderer_accelerate().replaceAll("\\\\\"", "\""));
////        });
//
//        // TODO 解除\"，将转义字符 \" 改为 "   ----------end
////        templates.forEach(template -> System.out.println(template.toString()));
// */
//    }
//
//
//}
