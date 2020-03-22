package com.xnyc.blog.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : 郑杜
 * @date : 2020/03/15
 */
@Slf4j
public class FreemarkerUtil {
    /**
     * 模板渲染
     * （模板不可以放在类的包下，因为编译或打包时都不会处理非java文件，故放在resources目录下）
     * @param ftl 模板名称，模板放在：src/main/resources/templates/mail
     * @param jsonStr 渲染模板所需要的参数值，是个json字符串
     */
    public static String getContent(String ftl, String jsonStr) {
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
            configuration.setClassForTemplateLoading(FreemarkerUtil.class, "/templates/mail");
            configuration.setLogTemplateExceptions(false);
            configuration.setWrapUncheckedExceptions(true);
            Template t = configuration.getTemplate(ftl, "UTF-8");

            HashMap<String, Object> map = new Gson().fromJson(jsonStr, new TypeToken<HashMap<String, Object>>() {}.getType());
            return FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        log.info("=====:" + getContent("email.ftl", "{\"name\":\"xiao杜杜\"}"));
    }
}

