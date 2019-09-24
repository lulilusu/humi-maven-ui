package com.hm.test;

import com.hm.actions.web.Login;
import com.hm.actions.web.MyPay;
import com.hm.utils.MyAssert;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TestMyPay {

    WebDriver driver = null;
    MyPay mp = null;

    public TestMyPay(){
        this.driver = new Login().employer();
        this.mp = new MyPay(this.driver);
    }

    public WebDriver testWithdraw(HashMap<String,String> param, String expected){
        String actual = mp.withdraw(param);
        if (actual.contains(expected)){
            MyAssert.succ();
        }else {
            MyAssert.fail();
        }
        return  this.driver;
    }
}
