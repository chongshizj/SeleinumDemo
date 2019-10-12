package com.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest {
    WebDriver webDriver;
    /**
     * 点击baidu首页的新闻链接
     */
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void iframeTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        //webDriver.switchTo().frame("aa");
        WebElement ifame = webDriver.findElement(By.tagName("iframe"));
        webDriver.switchTo().frame(ifame);
        webDriver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        webDriver.switchTo().defaultContent();
        webDriver.findElement(By.linkText("登陆界面")).click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
