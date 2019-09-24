package com.hm.utils;

public class MyAssert {

    public static int succCount = 0;
    public static int failCount = 0;

    public static void succ(){
        log.info("test case succ");
        log.error("333");
        succCount ++;
    }
    public static void fail(){
        log.info("test case fail");
        failCount ++;
    }

}
