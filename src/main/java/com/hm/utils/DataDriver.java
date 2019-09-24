package com.hm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class DataDriver {

    public static void Drive(){

        try {
            int caseCount = 0;
            ArrayList<String[]> allData = Excel.readExcel();
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
            System.out.println("一共执行了" + caseCount + "用例");
        } catch (InstantiationException e) {
            log.error("无法反射实例化对象");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            log.error("无法调用实例化对象方法");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            log.error("获取不到实体方法");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            log.error("获取不到反射类");
            e.printStackTrace();
        }


    }
}
