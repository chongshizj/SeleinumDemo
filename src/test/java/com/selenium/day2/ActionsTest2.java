package com.selenium.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionsTest2 {
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
    public void rightClickTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement su = webDriver.findElement(By.id("su"));
        Actions actions = new Actions(webDriver);
        Thread.sleep(3000);
        actions.contextClick(su).perform();
        Thread.sleep(3000);

    }

    @Test
    public void doubleClickTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebElement su = webDriver.findElement(By.id("su"));
        Actions actions = new Actions(webDriver);
        Thread.sleep(3000);
        actions.doubleClick().perform();
        Thread.sleep(3000);
    }

    @Test
    public void hoverTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement element = webDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[13]/td[2]/div[1]/input"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element);
        Thread.sleep(3000);
    }

    @Test
    public void dragTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        WebElement drag = webDriver.findElement(By.id("drag"));
        Actions actions = new Actions(webDriver);
        actions.dragAndDropBy(drag,500,500).perform();
        Thread.sleep(3000);
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        WebElement ele1 = webDriver.findElement(By.id("drag"));
        WebElement ele2 = webDriver.findElement(By.xpath("/html/body/h1"));
        Actions actions = new Actions(webDriver);
        actions.clickAndHold(ele1).moveToElement(ele2).release().perform();
        Thread.sleep(3000);
    }

    @Test
    public void multipleSelectTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement selectWithMultipleEqualsMultiple = webDriver.findElement(
                By.id("selectWithMultipleEqualsMultiple"));

        List<WebElement> elements = webDriver.findElements(
                By.xpath("/html/body/div[1]/table/tbody/tr[14]/td[2]/select/option"));
        Thread.sleep(3000);
        Actions actions = new Actions(webDriver);
        actions.keyDown(Keys.CONTROL).click(elements.get(2)).keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);
    }

    @Test
    public void saveHtmlTest() throws AWTException, InterruptedException {
        webDriver.get("https://www.baidu.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    @Test
    public void uploadTest() throws InterruptedException {
        webDriver.get("G:\\软件测试\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        webDriver.findElement(By.id("load")).sendKeys("G:\\test1.jpg");

        Thread.sleep(8000);

    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
