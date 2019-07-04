package com.hm.module;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Iterator;

public class SwitchWindow {

    // 适合切换两个窗口
    public static void changeWindowTwo(WebDriver driver)  {
        String wh = driver.getWindowHandle();// 当前窗口句柄
        Iterator<String> it = driver.getWindowHandles().iterator();
        while (it.hasNext()) {
            if (wh == it.next()) continue;
            driver.switchTo().window(it.next());
            System.out.println("Two切换: " + driver.getCurrentUrl());
        }
    }

    // 根据索引切换窗口
    public static void changeWindowIndex(WebDriver driver , int num)  {
        ArrayList<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(num));
        System.out.println("index切换："+ driver.getCurrentUrl());
    }

    // 根据url切换窗口
    public static void changeWindowUrl(WebDriver driver, String url)  {
        Iterator<String> it = driver.getWindowHandles().iterator();
        while (it.hasNext()){
            if (driver.switchTo().window(it.next()).getCurrentUrl().contains(url)){
                System.out.println("url切换：" + driver.getCurrentUrl());
            }
        }


    }
}

