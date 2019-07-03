package com.hm.actions;

import com.hm.utils.Browser;
import com.hm.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;



   public void login(){

       driver = WebDriverFactory.getDriver(Browser.FIREFOX);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get("https://www.baidu.com");
   }

    public static void main(String[] args) {
        new Login().login();
    }
}
