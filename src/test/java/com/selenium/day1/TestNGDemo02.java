package com.selenium.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo02 {

    @Test
    public void assertEqualTest() throws InterruptedException {
        Thread.sleep(10000);
        String a = "abcd";
        String b = "efgh";

        //Assert.assertEquals(a, b, "a不等于b");
        Assert.assertEquals(a, b);
    }

    @Test
    public void assertNoEquals() throws InterruptedException {
        Thread.sleep(10000);
        int a = 1;
        int b = 2;

        Assert.assertNotEquals(a, b);
    }

}
