package com.hm.actions;

import com.hm.utils.Browser;
import com.hm.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;


       driver = WebDriverFactory.getDriver(Browser.IE);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get("https://www.baidu.com");
   }

<<<<<<< .mine
   public void login(){

=======
    public static void main(String[] args) {
        new Login().login();
>>>>>>> .theirs

<<<<<<< .mine
       driver = WebDriverFactory.getDriver(Browser.FIREFOX);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get("https://www.baidu.com");
   }

    public static void main(String[] args) {
        new Login().login();
    }
=======

    }







>>>>>>> .theirs
}
