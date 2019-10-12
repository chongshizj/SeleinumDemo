package com.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowSelectTest {
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
    public void testWin() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        webDriver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        String currentWindowHandle = webDriver.getWindowHandle();
        Set<String> windowHandles = webDriver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(webDriver.getWindowHandle())){
                webDriver.switchTo().window(windowHandle);
            }
        }

        webDriver.findElement(By.linkText("baidu")).click();
    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
