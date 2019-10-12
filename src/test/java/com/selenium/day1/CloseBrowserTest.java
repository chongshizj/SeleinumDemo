package com.selenium.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseBrowserTest {

    @Test
    public void closeChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        Thread.sleep(5000);
        webDriver.close();

    }

    @Test
    public void quitChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "F:\\IdeaProjects\\Software Test\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        Thread.sleep(5000);
        webDriver.quit();

    }
}
