package com.hm.actions.web;

import com.hm.utils.Browser;
import com.hm.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {

    public WebDriver driver;

    public void video() {
        driver= WebDriverFactory.getDriver(Browser.CHROME);
        driver.manage().window().maximize();
        driver.get("https://www.360humi.com");
        WebElement element = driver.findElement(By.id("playMp4"));
        JavascriptExecutor je = (JavascriptExecutor)driver;
//        je.executeScript("return arguments[0].currentSrc",element);
//        je.executeScript("return arguments[0].play()",element);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        je.executeScript("arguments[0].pause()", element);
    }

}
