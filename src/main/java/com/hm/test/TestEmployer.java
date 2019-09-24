package com.hm.test;

import com.hm.actions.web.Employer;
import com.hm.actions.web.Login;
import com.hm.utils.MyAssert;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TestEmployer {

    WebDriver driver = null;
    Employer e = null;

    public TestEmployer(){
        this.driver = new Login().employer();
        this.e = new Employer(this.driver);
    }

    public WebDriver testPostDemand(HashMap<String,String> param, String expected){
        String actual = e.postDemand(param);
        if (actual.contains(expected)){
            MyAssert.succ();
        }else {
            MyAssert.fail();
        }
        return this.driver;
    }
}
