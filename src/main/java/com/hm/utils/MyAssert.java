package com.hm.utils;

public class MyAssert {

    public static int succCount = 0;
    public static int failCount = 0;

    public static void succ(){
        System.out.println("test case pass");
        succCount ++;
    }
    public static void fail(){
        System.out.println("test case fail");
        failCount ++;
    }

}
