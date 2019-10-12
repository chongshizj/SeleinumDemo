package com.selenium.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.3:6666/wd/hub"), dc);

        driver.get("http://www.baidu.com");

        Thread.sleep(10000);

        driver.quit();
    }

    @DataProvider(name = "data4")
    public Object[][] test1(){
        return new Object[][]{
                {"ie", "http://192.168.1.3:5555"},
                {"chrome", "http://192.168.1.3:6666"}
        };
    }

    @Test(dataProvider="data4")
    public void testGrid2(String browser, String url) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;

        if(browser.equals("ie")){
            dc = DesiredCapabilities.internetExplorer();
        }else if(browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }

        WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"), dc);

        driver.get("http://www.baidu.com");

        Thread.sleep(10000);

        driver.quit();

    }
}
