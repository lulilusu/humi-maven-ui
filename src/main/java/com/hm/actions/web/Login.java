package com.hm.actions.web;

import com.hm.module.DriverBase;
import com.hm.utils.Browser;
import com.hm.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Login {

    public DriverBase driver;

    public Login (){
       driver =  new DriverBase();
       driver.windowMax();
       driver.timeOut(30);
       driver.get("https://www.baidu.com");

   }

   public void service(){

   }

   public void manage(){

   }
   public void employer(){

   }
}
