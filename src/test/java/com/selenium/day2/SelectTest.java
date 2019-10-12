package com.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
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
    public void selectTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement moreSelect = webDriver.findElement(By.id("moreSelect"));

        Select select = new Select(moreSelect);

        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByValue("huawei");
        Thread.sleep(3000);
        select.selectByVisibleText("iphone");
        Thread.sleep(3000);

    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
