package com.hm.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class DataDriver {

    public static void Drive(){

        try {
            ArrayList<String[]> allData = new ArrayList<>();
            allData.remove(0);
            for (String[] data: allData) {
                HashMap<String, String> map = Data.getMap(data[2]);
                if (!data.equals("")){
                    Class<?> clazz = Class.forName("com.hm.test" + data[0]);
                    Method mth = clazz.getDeclaredMethod(data[1], HashMap.class, String.class);
                    Object obj = clazz.newInstance();

                }

            }
        }catch (ClassNotFoundException e){
            System.err.println("反射实列化对象失败");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.err.println("反射获取类方法失败");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("实例化有私有方法拒绝访问");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("实例化失败");
            e.printStackTrace();
        }


    }
}
