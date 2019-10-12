package com.selenium.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverTest {

    @DataProvider(name = "loginUser")
    public Object[][] data1(){
        return new Object[][]{
                {"user1", "password1"},
                {"user2", "password2"}
        };
    }

    @Test(dataProvider = "loginUser")
    public void loginTest(String username, String password){
        System.out.println(username + " " + password);
    }
}
