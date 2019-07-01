package com.hm.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    WebDriver driver = null;

    public Login(){
        System.setProperty("webdriver.chrome.bin", "C:/Users/DELL/AppData/Local/Google/Chrome/Application");
        System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
        driver = new ChromeDriver();

    }


}
