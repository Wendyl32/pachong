package com.tyl.pachong.util;

import com.tyl.pachong.mapper.TemplateMapper;
import com.tyl.pachong.model.Template;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.tyl.pachong.config.ImgConfig.*;


public final class GetImg {
    static String imgUrl = "//statics.xiumi.us/stc/images/templates-assets/tpl-paper/image/ac58137c5b1632c8f70093f2fb428bd4-sz_506803.jpg";

    public static void main(String args[]) {
        Template template = new Template();
        template.setRenderer_accelerate("<div class=\"tn-comp-anim-pin tn-comp tn-from-house-paper-cp\" style=\"\"><section class=\"tn-comp-pin tn-comp-style-pin\" style=\"margin: 0.5em 0px;\"><div tn-cell-type=\"group\" class=\"tn-cell tn-cell-group tn-child-position-static tn-state-active\" style=\"display: inline-block; vertical-align: top; width: 50%; padding-right: 2px;\"> <div class=\"tn-comp-anim-pin tn-comp tn-from-house-paper-cp\" style=\"\"><section class=\"tn-comp-pin tn-comp-style-pin\" style=\"text-align: center;\"><div tn-cell-type=\"image\" style=\"max-width: 100%; vertical-align: middle; display: inline-block; line-height: 0;\" class=\"tn-cell tn-cell-image tn-child-position-absolute tn-state-active\"><img class=\"tn-image-presenter raw-image\" src=\"//statics.xiumi.us/stc/images/templates-assets/parts/110-image/imgtxt-a-02-02-img1.jpg?x-oss-process=style/xmwebp\" style=\"vertical-align: middle; max-width: 100%;\"></div></section></div><div class=\"tn-comp-anim-pin tn-comp tn-from-house-paper-cp\" style=\"\"><section class=\"tn-comp-pin tn-comp-style-pin\" style=\"padding: 5px;\"><div style=\"text-align: left; font-size: 90%; color: rgb(102, 102, 102);\" tn-cell-type=\"text\" class=\"tn-cell tn-cell-text tn-child-position-absolute horizontal-tb tn-state-active\" tn-yzk-font-usage-id=\"cell.style.tnYzkFontUsageId\"><p>秀米上传的图片，用到图文里后，需要先保存图文，之后图库里面的就可以删除了</p></div></section></div> </div><div tn-cell-type=\"group\" class=\"tn-cell tn-cell-group tn-child-position-static tn-state-active\" style=\"width: 50%; display: inline-block; vertical-align: top; padding-left: 2px;\"> <div class=\"tn-comp-anim-pin tn-comp tn-from-house-paper-cp\" style=\"\"><section class=\"tn-comp-pin tn-comp-style-pin\" style=\"text-align: center;\"><div tn-cell-type=\"image\" style=\"max-width: 100%; vertical-align: middle; display: inline-block; line-height: 0;\" class=\"tn-cell tn-cell-image tn-child-position-absolute tn-state-active\"><img class=\"tn-image-presenter raw-image\" src=\"//statics.xiumi.us/stc/images/templates-assets/parts/110-image/imgtxt-a-02-02-img1.jpg?x-oss-process=style/xmwebp\" style=\"vertical-align: middle; max-width: 100%;\"></div></section></div><div class=\"tn-comp-anim-pin tn-comp tn-from-house-paper-cp\" style=\"\"><section class=\"tn-comp-pin tn-comp-style-pin\" style=\"padding: 5px;\"><div style=\"text-align: left; font-size: 90%; color: rgb(102, 102, 102);\" tn-cell-type=\"text\" class=\"tn-cell tn-cell-text tn-child-position-absolute horizontal-tb tn-state-active\" tn-yzk-font-usage-id=\"cell.style.tnYzkFontUsageId\"><p>图库的图片，定期清理，是个好习惯。</p></div></section></div> </div> </section></div>");
        getImgFromEntity(template);
    }

    @Deprecated
    //     获得图片---------数据库
    public static void getImgFromSql() {
    }

    //     获得图片--------实体
    public static void getImgFromEntity(Template template) {
        Set<String> imgUrls = new HashSet<String>();
        imgUrls = getUrlsByTemplate(template);
        //imgUrls.forEach(GetImg::downloadImg);

        //本身上面的就可以用了，但是要多线程

        //标志位，用于判断是否开启下载
        final boolean[] canDownloadNow = {true};
        imgUrls.forEach(imgurl -> {
            canDownloadNow[0] = false;
            canDownloadNow[0] = downloadImg(imgurl);
        });
    }

    //---------------------------------从单个对象获得url的工具---------------start
    // 通过单个template对象 获得所有templateCode 再获得秀米所有图片的url
    public static Set<String> getUrlsByTemplate(Template template) {
        Set<String> imgUrls = new HashSet<String>();
        String code = template.getRenderer_accelerate();
        if (!StringUtils.hasText(code)) {
            System.out.println("这里是空的" + template.getTemplate_id());
//            System.out.println(code.length());
            return imgUrls;
        }
        for (int i = 0; i < code.length(); ++i) {
            int src = code.indexOf("src", i);
            if (src != -1) {//i找到，找下一个"和再下一个“
                int start = code.indexOf("\"", src + 4);
                int end = code.indexOf("\"", start + 1);
                i = end;
                imgUrls.add(code.substring(start + 1, end));
            } else {
                break;
            }
        }
        return imgUrls;
    }


    //---------------------------------从单个对象获得url的工具---------------end

    //---------------------------------从数据库获得url的工具---------------start
    @Deprecated
    // 通过数据库 获得所有templateCode 再获得秀米所有图片的url
    public static Set<String> getImgUrlsByTemplateCodes(List<String> templateCodes) {
        Set<String> imgUrls = new HashSet<String>();
        templateCodes.forEach(code -> {
            for (int i = 0; i < code.length(); ++i) {
                int img = code.indexOf("img", i);
                if (img != -1) {
                    int src = code.indexOf("src", img);
                    if (src != -1) {//i找到，找下一个"和再下一个“
                        int start = code.indexOf("\"", src + 4);
                        int end = code.indexOf("\"", start + 1);
                        i = end;
                        imgUrls.add(code.substring(start + 1, end));
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        });
        return imgUrls;
    }

    @Deprecated
    public static List<Template> getTemplates() {
        String resource = "/mybatis-config.xml"; //定义配置文件路径
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);//读取配置文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//注册mybatis 工厂
        SqlSession sqlSession = sqlSessionFactory.openSession();//得到连接对象
        TemplateMapper templateMapper = sqlSession.getMapper(TemplateMapper.class);//从mybatis中得到dao对象
        return templateMapper.findAll();
    }

    //---------------------------------从数据库获得url的工具---------------end
    //---------------------------------下载图片的工具---------------start

    public static boolean downloadImg(String imgUrl) {
        return downloadImg(imgUrl, connectHttp);
    }

    // 根据图片路径url下载图片
    public static boolean downloadImg(String imgUrl, String connectMethod) {
        // Hurl = Http + url
        String Hurl = connectMethod + imgUrl;
        File file = new File(storePath + File.separator + getFilename(Hurl));
        if (file.exists()) {
            System.out.println("文件已存在:" + Hurl);
            System.out.println("文件位置是:" + file.getPath());
            return true;
        }
        System.out.println("文件下载:" + Hurl);
        return CreateGetHttp(Hurl, file);
    }

    // 创建http的get方法连接，返回一个HttpEntity
    public static boolean CreateGetHttp(String HUrl, File file) {
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                HttpGet httpGet = new HttpGet(HUrl);
                ChromeMap.forEach(httpGet::setHeader);
                client = HttpClients.createDefault();
                response = client.execute(httpGet);
                // 获得实体
                HttpEntity entity = response.getEntity();
                // TODO 实现下载
                entity.writeTo(new FileOutputStream(file));
                return true;
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
        return true;
    }

    // 根据Url获得filename
    public static String getFilename(String HUrl) {
        //--------------第一版错误
        //文件已存在:http://statics.xiumi.us/imgtxt-a-02-02-img1.jpg?x-oss-process=style/xmwebp
        //最后的一个/ 所以下载的是xmwebp
        // 获得url最后一个/之后的一位。就是文件名字
        //return HUrl.substring(HUrl.lastIndexOf("/") + 1);


        //第二版
        // quest就是问号的位置
        // ？后面的参数可能带/ ，通过切除？后面参数来进行文件名保存
        int quest = HUrl.lastIndexOf("?");
        if (quest != -1) {
            HUrl = HUrl.substring(1, quest);
        }
        return HUrl.substring(HUrl.lastIndexOf("/") + 1);
    }
    //---------------------------------下载图片的工具---------------end
}
