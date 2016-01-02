package com.bdc.util;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/1/2.
 */
public class ComponentGenerator {

    private static final String MODEL_PATH = "src/main/java/com/bdc/model/";
    private static final String JAVA_SUFFIX = ".java";
    private static String modelName;
    private static Map<String,String> propertiesMap;

    public static void main(String[] args) throws IOException, TemplateException {

        //1.Template
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        FreeMarkerConfig freeMarkerConfig = (FreeMarkerConfig) applicationContext.getBean("freemarker");
        Template template = freeMarkerConfig.getConfiguration().getTemplate("model.ftl");

        input();

        //2.Writer
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(MODEL_PATH + modelName + JAVA_SUFFIX));

        //3.Map
        Map<String,Object> map = new HashMap<>();
        map.put("model", modelName);
        map.put("properties", propertiesMap);

        //4.Process
        template.process(map,bufferedWriter);
    }

    private static void input() {
        System.out.println("input model class name: ");
        modelName = new Scanner(System.in).nextLine();
        System.out.println("input properties: ");
        String[] properties = new Scanner(System.in).nextLine().split(", ");
        propertiesMap = new LinkedHashMap<>();
        for (String property : properties) {
            propertiesMap.put(property.split(" ")[1], property.split(" ")[0]);
        }
    }
}
