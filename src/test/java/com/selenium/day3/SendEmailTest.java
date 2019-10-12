package com.selenium.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendEmailTest {
    WebDriver webDriver;
    /**
     * 点击baidu首页的新闻链接
     */
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://email.163.com/");
    }

    @Test
    public void sendEmail() throws InterruptedException {
        Thread.sleep(3000);

        LoginTest.login(webDriver, "wzyjac", "xunzhaoai");

        Thread.sleep(3000);

        webDriver.findElement(By.xpath("/html/body/div[1]/nav/div[1]/ul/li[2]/span[2]")).click();

        webDriver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("wzyjac@163.com");

        webDriver.findElement(By.xpath(
                "//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("邮件主题");

        webDriver.findElement(By.xpath(
                "/html/body/div[2]/div[1]/div[2]/div[1]/section/header/div[3]/div[1]/div[2]/input")).
                sendKeys("F:\\软件开发\\Java\\06.乐优商城项目\\Code\\1.png");
        WebElement iframe = webDriver.findElement(By.className("APP-editor-iframe"));
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.xpath("/html/body")).sendKeys("这是一个内容");

        webDriver.switchTo().defaultContent();

        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/header/div/div[1]/div/span[2]")).click();

        Thread.sleep(3000);

        boolean displayed = webDriver.findElement(By.xpath("//*[text()=\"发送成功\"]")).isDisplayed();

        Assert.assertEquals(displayed, true);

        Thread.sleep(3000);

    }


    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
