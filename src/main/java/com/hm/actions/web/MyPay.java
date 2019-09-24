package com.hm.actions.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class MyPay {

    WebDriver driver = null;

    public MyPay() {
    }

    public MyPay(WebDriver driver) {
        this.driver = driver;
    }

    public String withdraw(HashMap<String, String> params){
        driver.findElement(By.linkText("雇主中心")).click();
        driver.findElement(By.linkText("我的钱包")).click();
        driver.findElement(By.xpath(" //div[2]/button ")).click();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // 金额
        if (params.containsKey("tradeAmount")){
            driver.findElement(By.xpath(" //input ")).sendKeys(params.get("tradeAmount"));
        }
        // 备注
        if (params.containsKey("tradeRemark")){
            driver.findElement(By.xpath("//textarea")).sendKeys(params.get("tradeRemark"));
        }
        // 支付密码
        if (params.containsKey("verifyPassword")){

        }


        // 确认提交
        driver.findElement(By.xpath("//div[4]/div[2]/div[2]/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actual = driver.findElement(By.cssSelector("h2")).getText();
        return actual;
    }
}
