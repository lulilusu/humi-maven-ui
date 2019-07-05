package com.hm.utils;

import org.openqa.selenium.By;

import java.io.*;
import java.util.Properties;

public class ProFileUtil {

    Properties properties;

    public ProFileUtil() {
    }

    /**
     *  读取配置文件信息
     * @param proFile
     */
    public ProFileUtil(String proFile){
        properties = new Properties();
        BufferedInputStream buf = null;
        try {
            buf  = new BufferedInputStream(new FileInputStream(proFile));
            properties.load(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (buf != null){
                try {
                    buf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public By parseProFile(String eleName){
        String by = properties.getProperty(eleName);
        String byType = by.split(",")[0];
        String byValue = by.split(",")[1];

        switch (byType){
            case "id":
                return By.id(byValue);
            case "name":
                return By.name(byValue);
            case "tag":
                return By.tagName(byType);
            case "link":
                return By.linkText(byValue);
            case "xpath":
                return By.xpath(byValue);
            case "css":
                return By.cssSelector(byValue);
            case "cssName":
                return By.className(byValue);
        }
        return null;
    }

}
