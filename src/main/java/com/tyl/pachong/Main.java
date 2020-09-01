package com.tyl.pachong;


import com.alibaba.fastjson.JSON;
import com.tyl.pachong.mapper.MovieMapper;
import com.tyl.pachong.model.Movie;
import com.tyl.pachong.util.GetJson;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.tyl.pachong.config.Config.END;
import static com.tyl.pachong.config.Config.TOTAL;


public class Main {
    public static  void  main(String [] args) {

        String resource = "mybatis-config.xml"; //定义配置文件路径
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);//读取配置文件
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//注册mybatis 工厂
        SqlSession sqlSession = sqlSessionFactory.openSession();//得到连接对象


        MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);//从mybatis中得到dao对象

        int start ;//记录数
        int total = TOTAL;//记录数
        int end = END;//查询数据 数据为20的倍数
        for (start  = 0; start < end; start += 20)  {
            try {
                //https://movie.douban.com/explore#!type=movie&tag=%E7%83%AD%E9%97%A8&sort=time&page_limit=20&page_start=0
                String address = "https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=time&page_limit=20&page_start=" + start;

                JSONObject dayLine = new GetJson().getHttpJson(address, 1);
                System.out.println("dayline:"+dayLine);

                System.out.println("start:" + start);
                JSONArray json = dayLine.getJSONArray("subjects");
                List<Movie> list = JSON.parseArray(json.toString(), Movie.class);
//                if (start >= end){
//                    System.out.println("已经爬取到底了");
//                    sqlSession.close();
//                }

                int i=0; //标志位i，用来阻断保存
                for (Movie movie : list) {
                    if (start+i==end) break;
                    i++;
                    movieMapper.insert(movie);
                    sqlSession.commit();
                }
                total += list.size();
                System.out.println("正在爬取中---共抓取:" + total + "条数据");

            } catch (PersistenceException e) {
                System.out.println("设置了题目为主键");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        //for循环爬完后才关闭
        System.out.println("已经爬取到底了");
        //查询
        List<Movie> movies = movieMapper.findAll();
        //查询完才关闭
        sqlSession.close();
        movies.forEach(movie -> System.out.println(movie.toString()));

    }

}
