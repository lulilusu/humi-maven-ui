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

    // 多个case共用一个driver
    public static WebDriver getDriverInstance(Browser browser){
        if (driver == null){
            driver = getDriver(browser);
        }
        return driver;
    }

    // 一个case都用重新new一个driver
    public static WebDriver getDriver(Browser browser){
        switch (browser.ordinal()){
            case 1:
                // firefox
                return getFireFoxWebDriver();
            case 2:
                // ie
                return getIEWebDriver();
            case 3:
                // safari
                return getSafariWebDriver();
//            case 4:
//                // html
//                return null;
        }
        // chrome
        return getChromeWebDriver();
    }

    // 获取firfox
    public static WebDriver getFireFoxWebDriver(){
        if (!System.getProperties().containsKey("webdriver.firefox.marionette")){
//            System.setProperty("webdriver.firefox.marionette","C:/Program Files/Mozilla Firefox/firefox.exe");
            System.setProperty("webdriver.gecko.dirver","src/test/resources/geckodriver.exe");
        }
        return new FirefoxDriver();
    }

    // 获取chrome
    public static WebDriver getChromeWebDriver(){
        if (!System.getProperties().containsKey("webdriver.chrome.driver")){
            System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
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
        return new ChromeDriver();
    }

    // 获取ie
    public static WebDriver getIEWebDriver(){
        if (!System.getProperties().containsKey("webdriver.ie.driver")){
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


//    // 获取html
//    public static WebDriver getHtmlWebDriver(){
//        DesiredCapabilities htmlCapabilities = DesiredCapabilities.htmlUnit();
//        htmlCapabilities.setCapability("ignoreProtectedModeSettings",true);
//        return null;
//    }


}
