package com.hm.actions.web;

import com.hm.module.DriverBase;
import com.hm.module.SwitchWindow;
import com.hm.utils.Browser;
import com.hm.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Login {

    public WebDriver driver;

    public Login (){
//       driver.windowMax();
//       driver.timeOut(30);
       System.setProperty("webdriver.chrome.bin", "C:/Users/DELL/AppData/Local/Google/Chrome/Application");
       System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

   }

   public WebDriver service(){
      driver.get("https://test2.360humi.com");
      driver.findElement(By.linkText("登录")).click();
      SwitchWindow.changeWindowTwo(driver);
      driver.findElement(By.xpath("//input[@type='text']")).sendKeys("13888888888");
      driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
      driver.findElement(By.xpath("//button")).click();
      try {
         Thread.sleep(100);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      return driver;
   }

   public WebDriver manage(){
      driver.get("http://worktest2.360humi.com");
      driver.findElement(By.id("username")).sendKeys("wengzhengbiao");
      driver.findElement(By.id("password")).sendKeys("123456");
      driver.findElement(By.id("loginBtn")).click();
      try {
         Thread.sleep(100);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      return driver;
   }
   public WebDriver employer(){
      driver.get("https://test2.360humi.com");
      driver.findElement(By.linkText("登录")).click();
      SwitchWindow.changeWindowTwo(driver);
      driver.findElement(By.xpath("//input[@type='text']")).sendKeys("13666666666");
      driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Hm123456");
      driver.findElement(By.xpath("//button")).click();
      try {
         Thread.sleep(100);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      return driver;
   }
}
