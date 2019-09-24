package com.hm.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class DataDriver {

    public static void Drive(){

        try {
            int caseCount = 0;
            ArrayList<String[]> allData = new ArrayList<>();
            allData.remove(0);
            for (String[] data: allData) {
                HashMap<String, String> map = Data.getMap(data[2]);
                if (!data.equals("")){
                    Class<?> clazz = Class.forName("com.hm.test" + data[0]);
                    Method mth = clazz.getDeclaredMethod(data[1], HashMap.class, String.class);
                    Object obj = clazz.newInstance();
                    mth.invoke(obj,map,data[3]);
                    caseCount ++;
                }
            }
        }catch (Exception e){
            log.error("反射异常");
            e.printStackTrace();
        }


    }
}
