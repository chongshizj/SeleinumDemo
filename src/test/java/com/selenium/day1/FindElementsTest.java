package com.selenium.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    WebDriver webDriver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void testById(){
        webDriver.get("https://www.baidu.com");
        WebElement kw = webDriver.findElement(By.id("kw"));
        System.out.println("kw = " + kw);
    }

    @Test
    public void testByName(){
        webDriver.get("https://www.baidu.com");
        WebElement wd = webDriver.findElement(By.name("wd"));
        System.out.println("wd = " + wd);
    }

    @Test
    public void testByClass(){
        webDriver.get("https://www.baidu.com");
        WebElement className = webDriver.findElement(By.className("quickdelete-wrap"));
        System.out.println("className = " + className);
    }

    @Test
    public void testByLink(){
        webDriver.get("https://www.baidu.com");
        WebElement linkText = webDriver.findElement(By.linkText("新闻"));
        System.out.println("linkText = " + linkText);
    }

    @Test
    public void testByPartialLinkTest(){
        webDriver.get("https://www.baidu.com");
        WebElement partialLinkText = webDriver.findElement(By.partialLinkText("新"));
        System.out.println("partialLinkText = " + partialLinkText);

    }

    @Test
    public void testByTagNamekTest(){
        webDriver.get("https://www.baidu.com");
        List<WebElement> input = webDriver.findElements(By.tagName("input"));
        System.out.println("inputSize = " + input.size());

    }

    @Test
    public void testByXPATH(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"su\"]"));
        System.out.println("element = " + element);
    }

    @Test
    public void testCSS(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.cssSelector("#lg > map:nth-child(3) > area:nth-child(1)"));
        System.out.println("element = " + element);

    }

    @Test
    public void testByXPATHList(){
        webDriver.get("https://www.baidu.com");
        List<WebElement> elements = webDriver.findElements(By.xpath("/html/body/div[1]/div[1]/div/div[3]/a"));
        String text = elements.get(1).getText();
        System.out.println("text = " + text);
    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
