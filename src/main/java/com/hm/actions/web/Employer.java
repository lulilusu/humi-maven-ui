package com.hm.actions.web;

import com.hm.module.SwitchWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class Employer {

    WebDriver driver = null;

    public Employer() {
    }

    public Employer(WebDriver driver) {
        this.driver = driver;
    }

    // 1.发布需求
    public String postDemand(HashMap<String, String> params) {

        driver.findElement(By.xpath(" //*[@id='humi-home-page']/div[2]/a[1]/span ")).click();
//        SwitchWindow.changeWindowIndex(driver,2);
        SwitchWindow.changeWindowUrl(driver, "sendneeds");
        if (params.containsKey("content")) {
            driver.findElement(By.xpath("//textarea")).clear();
            driver.findElement(By.xpath("//textarea")).sendKeys(params.get("content"));
        }

        driver.findElement(By.xpath("//div[5]")).click();

        {
//            driver.findElement(By.xpath("//div[2]/input")).sendKeys("111");
//            driver.findElement(By.xpath("//div[3]/input")).sendKeys("1");
            driver.findElement(By.cssSelector("body > div:nth-child(18) > div > div.ant-modal-wrap > div > div.ant-modal-content > div.ant-modal-footer > button")).click();
        }
        String actual = driver.findElement(By.cssSelector("div.ant-col-12.t-right")).getText();
        return actual;
    }

    // 4.资金托管

    // 5.选标

    // 6.发起协议

    // 9.确认验收

    // 10.暂不开票
}
