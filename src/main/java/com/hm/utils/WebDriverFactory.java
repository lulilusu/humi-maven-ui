package com.hm.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Arrays;

public class WebDriverFactory {

    private static WebDriver driver = null;

    private WebDriverFactory() {
    }

    public static WebDriver getDriverInstance(Browser browser){
        if (driver == null){

        }
        return driver;
    }

    public static WebDriver getDriver(Browser browser){
        switch (browser.ordinal()){
            case 1:
                // firefox
                return null;
            case 2:
                // ie
                return null;
            case 3:
                // safari
                return null;
            case 4:
                // html
                return null;
        }
        // chrome
        return null;
    }

    // 获取firfox
    public static WebDriver getFireFoxWebDriver(){
        System.setProperty("webdriver.firefox.bin","C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        return new FirefoxDriver();
    }

    // 获取chrome
    public static WebDriver getChromeWebDriver(){
        if (!System.getProperties().contains("webdriver.chrome.driver")){
            System.setProperty("webdriver.chrome.driver","/src/test/resources/chromedrivrer.exe");
        }

        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        chromeCapabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        if (System.getProperties().containsKey("webdriver.chrome.profile")){
            options.addArguments(new String[]{
               "user-data-dri=" + System.getProperty("webdriver.chrome.profile")
            });
        }
        options.addArguments(new String[]{"start-maximized"});
        return new ChromeDriver(chromeCapabilities);
    }

    // 获取ie
    public static WebDriver getIEWebDriver(){
        if (!System.getProperties().contains("webdriver.ie.driver")){
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/src/test/resources/IEDriverServer.exe");
        }
        // 定义分布式ie浏览器
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        // 设置参数
        ieCapabilities.setCapability("ignoreProtectedModeSettings",true);
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        return new InternetExplorerDriver(ieCapabilities);
    }

    // 获取safari
    public static WebDriver getSafariWebDriver(){
        Platform current = Platform.getCurrent();
        if (Platform.MAC.is(current) || Platform.VISTA.is(current) || Platform.WIN8.is(current)){
            return new SafariDriver();
        }
        return null;
    }


    // 获取html
    public static WebDriver getHtmlWebDriver(){
        DesiredCapabilities htmlCapabilities = DesiredCapabilities.htmlUnit();
        htmlCapabilities.setCapability("ignoreProtectedModeSettings",true);
        return null;
    }



}
