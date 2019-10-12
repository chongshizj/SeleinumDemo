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

import java.util.Set;

public class RegisterTest {
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
    public void testRegister() throws InterruptedException {
        Thread.sleep(4000);
        /*WebElement iframe = webDriver.findElement(By.tagName("iframe"));
        String id = iframe.getAttribute("id");
        if(id != null) {
            webDriver.switchTo().frame(id);
        }*/
        WebElement element = webDriver.findElement(By.xpath("/html/body/section/div/div[1]/iframe"));
        webDriver.switchTo().frame(element);
        webDriver.findElement(By.id("changepage")).click();
        //webDriver.findElement(By.xpath("//*[@id=\"changepage\"]")).click();
        String windowHandle = webDriver.getWindowHandle();
        Set<String> windowHandles = webDriver.getWindowHandles();
        for (String handle : windowHandles) {
            if(!handle.equals(windowHandle)){
                webDriver.switchTo().window(handle);
            }
        }

        String timeStamp = String.valueOf(System.currentTimeMillis());

        Thread.sleep(3000);
        webDriver.findElement(By.id("nameIpt")).sendKeys("a"+timeStamp);
        Thread.sleep(2000);
        webDriver.findElement(By.id("mainPwdIpt")).sendKeys("123123hh");
        webDriver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123123hh");
        webDriver.findElement(By.id("vcodeIpt")).sendKeys("dfds");
        webDriver.findElement(By.id("mainMobileIpt")).sendKeys("13501739362");
        webDriver.findElement(By.id("mainAcceptIpt")).click();
        webDriver.findElement(By.id("mainRegA")).click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 3);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("m_vcode")));
        String m_vcode = webDriver.findElement(By.id("m_vcode")).getText();
        System.out.println("m_vcode = " + m_vcode);
        Assert.assertEquals(m_vcode,"  验证码不正确，请重新填写");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
