package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

public class day07_NweWindows extends TestBase {
    @Test
    public void newWindowTest() throws InterruptedException {
        // Open the pages in 2 new windows and verify their  TITLES -> LinkedIn , Ebay


        driver.get("https://www.linkedin.com/");

        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"));

        String LinkedIn = driver.getWindowHandle();

        System.out.println("LinkedIn = " + LinkedIn);

        //I need to go to Ebay website with new window

        driver.switchTo().newWindow(WindowType.WINDOW); //create a new window for driver.....

        Thread.sleep(3000);


        driver.get("https://www.ebay.com/");

        Assertions.assertTrue(driver.getTitle().contains("Electronics"));

        String eBay = driver.getWindowHandle();
        System.out.println("eBay = " + eBay);

        Thread.sleep(3000);

        //We will go to linkedin window

        driver.switchTo().window(LinkedIn);
        Thread.sleep(3000);

        //Then we will come back to again ebay window
        driver.switchTo().window(eBay);
        Assertions.assertTrue(driver.getCurrentUrl().contains("ebay"));



    }
    @Test
    public  void  newTest() throws InterruptedException {
        // Open 2 new tabs and verify their TITLES       -> LinkedIn , Ebay
        driver.get("https://www.linkedin.com/");

        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"));

        String LinkedIn = driver.getWindowHandle();

        System.out.println(LinkedIn);

        driver.switchTo().newWindow(WindowType.TAB);

        Thread.sleep(3000);


        driver.get("https://www.ebay.com/");

        Assertions.assertTrue(driver.getTitle().contains("Electronics"));

        String eBay = driver.getWindowHandle();
        System.out.println("eBay = " + eBay);

        Thread.sleep(3000);

        driver.switchTo().window(LinkedIn);
        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"));





    }
}