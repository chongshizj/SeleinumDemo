package com.selenium.day1;

import org.testng.annotations.*;

public class TestNGDemo01 {

    @BeforeTest
    public void beforeTest(){
        System.out.println("测试前");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是BeforeTest注解");
    }


    @Test
    public void testCase2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("注解2");
    }

    @Test
    public void testCase1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("注解1");
    }

    @Test
    public void testCasea() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("注解a");
    }

    @Test
    public void testCaseb() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("注解b");
    }


    @AfterMethod
    public void afterMethod(){
        System.out.println("这是一个AfterMethod注解");
    }

    @AfterTest
    public void afterTest1(){
        System.out.println("这是一个AfterTest注解");
    }
}
