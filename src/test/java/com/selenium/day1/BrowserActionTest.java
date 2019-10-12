package com.selenium.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionTest {
    WebDriver webDriver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void openChromeWithBaiduAndThenClose() throws InterruptedException {

        webDriver.get("https://www.baidu.com");

        Thread.sleep(5000);
        webDriver.quit();
    }

    @Test
    public void backTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com");

        Thread.sleep(3000);
        webDriver.navigate().back();
        Thread.sleep(3000);
        webDriver.quit();
    }

    @Test
    public void forwardTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com");

        Thread.sleep(3000);
        webDriver.navigate().back();
        Thread.sleep(3000);
        webDriver.navigate().forward();
        Thread.sleep(3000);
        webDriver.quit();
    }

    @Test
    public void refreshTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com.hk");

        Thread.sleep(3000);
        webDriver.navigate().refresh();
        Thread.sleep(3000);
        webDriver.navigate().refresh();
        Thread.sleep(3000);
        webDriver.quit();
    }

    @Test
    public void maximizeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        Dimension dimension = new Dimension(300, 300);
        webDriver.manage().window().setSize(dimension);
        webDriver.get("https://www.google.com.hk");
        Thread.sleep(3000);
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
        webDriver.quit();
    }

    @Test
    public void getURLTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");

        webDriver.get("https://www.google.com.hk");
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        Assert.assertEquals(currentUrl, "https://www.google.com.hk/");
        Thread.sleep(3000);

    }

    @AfterMethod
    public void driverQuit(){
        webDriver.quit();
    }
}
