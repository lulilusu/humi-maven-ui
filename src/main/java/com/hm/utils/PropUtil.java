package com.hm.utils;

import java.io.*;
import java.util.Properties;

public class PropUtil {

    private Properties properties;
    private String filePath;

    /**
     *  new properties 从外部传入一个路径
     * @param filePath
     */
    public PropUtil(String filePath) {
        // 传入路径赋值给当前路径
        this.filePath = filePath;
        // 赋值properties
        this.properties = readProp();
    }

    /**
     *  读取配置文件
     * @return
     */
    public Properties readProp(){
        Properties prop = new Properties();
        BufferedInputStream buf = null;
        try {
            buf = new BufferedInputStream(new FileInputStream(filePath));
            prop.load(buf);
        } catch (FileNotFoundException e) {
            System.err.println("读取路径异常");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("配置文件读取异常");
            e.printStackTrace();
        }finally {
            try {
                buf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

    /**
     *  根据key获取值
     * @param key
     * @return
     */
    public String getProp(String key){
        if (properties.containsKey(key)){
            String property = properties.getProperty(key);
            return property;
        }else {
            System.out.println("key不存在");
            return "";
        }
    }

    /**
     *  写入配置文件
     * @param key
     * @param value
     */
    public void writeProp(String key,String value){
        Properties properties = new Properties();
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(filePath);
            properties.setProperty(key,value);
            properties.store(file,key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
