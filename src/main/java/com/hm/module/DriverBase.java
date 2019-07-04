package com.hm.module;

import com.hm.utils.Browser;
import com.hm.utils.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverBase {

    public WebDriver driver;

    /**
     *  初始化driver浏览器
     */
    public DriverBase(WebDriver driver){
        this.driver = WebDriverFactory.getDriver(Browser.CHROME);
    }

    /**
     * 获取driver
     * @return driver
     */
    public WebDriver getDriver(){
        return driver;
    }

    /**
     * 关闭浏览器
     * 关闭当前driver控制窗口
     */
    public void stopDriver(){
        System.out.println("关闭浏览器");
        driver.close();
    }

    /**
     * 关闭所有窗口
     */
    public void quitDriver(){
        driver.quit();
    }

    /**
     *  封装click方法
     * @param element 元素
     */
    public void click(WebElement element){
        if (element != null){
            element.click();
        }else {
            System.out.println("元素未找到");
        }
    }

    /**
     * 返回
     */
    public void back(){
        driver.navigate().back();
    }

    /**
     *  刷新
     */
    public void refresh(){
        driver.navigate().refresh();
    }

    /**
     *  线程休眠
     * @param num 毫秒
     */
    public void sleep(int num){
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  切换alert
     */
    public void switchAlert(){
        driver.switchTo().alert();
    }

    /**
     * 静态框切换
     */
    public void switchToMode(){
        driver.switchTo().activeElement();
    }


    /**
     *  定位元素
     * @param by
     * @return
     */
    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    /**
     *  截图
     */
    public void takeScreenShot(){
//        String path = this.getClass().getSimpleName() + "_" + dataStr + ".png";
        String dataStr = getDateFormat();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile,new File("G:/" + dataStr + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  获取时间
     * @return
     */
    public String getDateFormat(){
        SimpleDateFormat sf = new SimpleDateFormat("yyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        String dataStr = sf.format(cal.getTime());
        return dataStr;
    }

    /**
     * 窗口最大化
     */
    public void windowMax(){
        driver.manage().window().maximize();
    }

    /**
     *  get封装
     * @param url
     */
    public void get(String url){
        driver.get(url);
    }

}
