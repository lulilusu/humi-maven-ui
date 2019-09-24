package com.hm.actions.manage.orderCenter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class OrderLib {

    WebDriver driver = null;

//    public OrderLib(){
//
//    }

    public OrderLib(WebDriver driver) {
        this.driver = driver;
    }

    // 2.梳理需求
    public String combDemand(HashMap<String, String> params){
//        new Actions(driver).click(driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a/span[1]")));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(" //*[@id=\"side-menu\"]/li[9]/a/span[1] ")).click();
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a/span[1]")).click();
        driver.findElement(By.linkText("订单库")).click();
        // 切换到订单库得iframe
//        driver.switchTo().frame("iframe967959310721040386");
        driver.switchTo().frame(1);
        // 等待加载订单数据
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 点击第一条订单查看详情
        driver.findElement(By.xpath("//table[@id='orderListMain']/tbody/tr/td[11]/a")).click();
        // 点击梳理需求
        driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(11) > a")).click();
        {
            driver.findElement(By.id("slxqBtn")).click();
//            WebElement element = driver.findElement(By.id("slxqBtn"));
//            new Actions(driver).moveToElement(element).perform();
        }
        // 选择工期
        {
            if (params.containsKey("demandCycle")){
                driver.findElement(By.id("demandCycle_p")).clear();
                driver.findElement(By.id("demandCycle_p")).sendKeys("123");
            }
            // 选择工期单位
            new Select(driver.findElement(By.id("demandCycleUnit_p"))).selectByIndex(1);
        }

        // 赏金或预算
        if (params.containsKey("budget")){
            driver.findElement(By.id("budget_p")).clear();
            driver.findElement(By.id("budget_p")).sendKeys(params.get("budget"));
        }
        // 顾问资金
        if (params.containsKey("adviserBudget")){
            driver.findElement(By.id("adviserBudget_p")).clear();
            driver.findElement(By.id("adviserBudget_p")).sendKeys(params.get("adviserBudget"));
        }
        // 税金比
        if(params.containsKey("taxRate")){
            driver.findElement(By.id("taxRate_p")).clear();
            driver.findElement(By.id("taxRate_p")).sendKeys(params.get("taxRate"));
        }
        new Select(driver.findElement(By.id("intentionality_p"))).selectByIndex(1);
        new Select(driver.findElement(By.id("urgency_p"))).selectByIndex(1);
        // 保存
        driver.findElement(By.linkText("保存")).click();

        // 转入大厅
        if (params.containsKey("is_public")){
            driver.findElement(By.id("communionLimit_p")).clear();
            driver.findElement(By.id("communionLimit_p")).sendKeys(params.get("is_public"));
        }
        // 选择转入大厅
        driver.findElement(By.id("kspd")).click();
        driver.findElement(By.linkText("提交")).click();

        // 输入服务商名
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        driver.findElement(By.id("serverNo")).sendKeys("自动化测试店铺");
        driver.findElement(By.linkText("查询")).click();
        driver.findElement(By.linkText("派单")).click();
        String actual = driver.findElement(By.xpath("//*[@id=\"svList\"]/li/div/span[2]")).getText();
        return actual;

    }

    // 11.订单审核



    // 关闭订单
    public String closeDemand(){



        return null;
    }
    // 放弃需求
    public String waiveDemand(){

        return null;
    }
    // 添加跟踪记录
    public String addFollowUp(){


        return null;
    }

}
