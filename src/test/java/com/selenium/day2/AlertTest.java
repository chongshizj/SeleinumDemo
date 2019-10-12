package com.selenium.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
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
    public void alertTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        webDriver.findElement(By.className("alert")).click();
        Alert alert = webDriver.switchTo().alert();
        String text = alert.getText();
        Thread.sleep(3000);
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }

    @Test
    public void confirmTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        webDriver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert alert = webDriver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }

    @Test
    public void promptTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        webDriver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("Prompt");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
