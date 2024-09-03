package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day15_TimeOutException extends TestBase {

    @Test
    public void timeOutException01() throws InterruptedException {

        //1. Navigate to 'https://www.ebay.com/' url
        driver.get("https://pages.ebay.com/");
        Thread.sleep(10);


        //2.
       // WebElement search=driver.findElement(By.id("*gh-ac"));
     //   search.sendKeys("coffe machine"+ Keys.ENTER);
        waitForVisibility(By.id("gh-ac"),10);
        waitFor(10);




    }



}
