package com.selenium.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
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
    public void clickTest(){
        webDriver.get("https://www.baidu.com");
        WebElement newsLink = webDriver.findElement(By.name("tj_trnews"));
        newsLink.click();
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"http://news.baidu.com/");
    }

    @Test
    public void sendKeysTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement search = webDriver.findElement(By.id("kw"));
        search.sendKeys("selenium");
        WebElement clickSearch = webDriver.findElement(By.id("su"));
        clickSearch.click();
        Thread.sleep(3000);
        /*String text = webDriver.findElement(
                By.xpath("/html/body/div[1]/div[5]/div[1]/div[3]/div[1]/div[1]/h3/a/font[2]")).getText();*/
        String title = webDriver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");

    }

    @Test
    public void emptyKeysTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement search = webDriver.findElement(By.id("kw"));
        search.sendKeys("selenium");

        /*WebElement clickSearch = webDriver.findElement(By.id("su"));
        clickSearch.click();*/
        Thread.sleep(3000);
        String text = search.getText();
        System.out.println("text = " + text);
        Thread.sleep(3000);
        Assert.assertEquals(text,"selenium");

    }

    @Test
    public void getTagnameAndVerify(){
        webDriver.get("https://www.baidu.com");
        WebElement search = webDriver.findElement(By.id("kw"));
        String tagName = search.getTagName();
        System.out.println("tagName = " + tagName);
        Assert.assertEquals(tagName,"input");
    }

    @Test
    public void getAttributeTest(){
        webDriver.get("https://www.baidu.com");
        String attribute = webDriver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attribute,"百度一下");
    }

    @Test
    public void searchButtonTest(){
        webDriver.get("https://www.baidu.com");
        boolean su = webDriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(su);
    }

    @Test
    public void radioButtonTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement element = webDriver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[4]/td[2]/div/input[1]"));
        element.click();
        Thread.sleep(3000);
        boolean selected = element.isSelected();
        System.out.println("selected = " + selected);
    }

    @Test
    public void enableTest() throws InterruptedException, IOException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement element = webDriver.findElement(By.name("buttonhtml"));
        boolean enabled = element.isEnabled();
        System.out.println("enabled = " + enabled);

    }

    @Test
    public void screenshotTest() throws IOException {
        webDriver.get("https://www.baidu.com");
        File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file, new File("G:/test1.jpg"));

    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
