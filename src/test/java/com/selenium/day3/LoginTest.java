package com.selenium.day3;

import com.po.page.LoginPage;
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

public class LoginTest {
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
    public void loginTest() throws InterruptedException {
        Thread.sleep(3000);

        LoginTest.login2(webDriver, "wzyjac", "xunzhaoai");

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 3);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.linkText("退出")));
        String logout = webDriver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");

        Thread.sleep(2000);

    }


    public static void login(WebDriver webDriver, String email, String password) throws InterruptedException {
        Thread.sleep(3000);
        /*WebElement iframe = webDriver.findElement(By.tagName("iframe"));
        String id = iframe.getAttribute("id");
        if(id != null) {
            webDriver.switchTo().frame(id);
        }*/
        WebElement element = webDriver.findElement(By.xpath("/html/body/section/div/div[1]/iframe"));
        webDriver.switchTo().frame(element);

        webDriver.findElement(By.name("email")).sendKeys(email);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.id("dologin")).click();
    }

    public static void login2(WebDriver webDriver, String email, String password) throws InterruptedException {
        Thread.sleep(3000);
        /*WebElement iframe = webDriver.findElement(By.tagName("iframe"));
        String id = iframe.getAttribute("id");
        if(id != null) {
            webDriver.switchTo().frame(id);
        }*/
        WebElement element = webDriver.findElement(By.xpath("/html/body/section/div/div[1]/iframe"));
        webDriver.switchTo().frame(element);

        webDriver.findElement(LoginPage.emailInput).sendKeys(email);
        webDriver.findElement(LoginPage.pwdInput).sendKeys(password);
        webDriver.findElement(LoginPage.loginButton).click();
    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
