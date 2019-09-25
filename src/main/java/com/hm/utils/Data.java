package com.hm.utils;

import java.util.HashMap;

public class Data {

    public static HashMap<String,String> getMap(String data){
        HashMap<String,String> map = new HashMap<>();
        String[] buf = data.split("\n");
        for (String line: buf){
            log.info("测试用例：" + line);
            if (line.contains("=")){
                map.put(line.split("=")[0], line.split("=")[1]);
            }
        }
        return map;
    }
}
