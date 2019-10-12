package com.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    WebDriver webDriver;
    /**
     * 点击baidu首页的新闻链接
     */
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @Test
    public void waitTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        webDriver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[13]/td[2]/div[1]/input")).click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div[1]/table/tbody/tr[13]/td[2]/div[1]/input1")));
        String text = webDriver.findElement(
                By.xpath("/html/body/div[1]/table/tbody/tr[13]/td[2]/div[2]/div")).getText();
        Thread.sleep(8000);
        Assert.assertEquals(text,"wait for display");
    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
