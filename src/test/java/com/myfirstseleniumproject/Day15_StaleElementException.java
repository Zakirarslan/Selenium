package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day15_StaleElementException extends TestBase {
    @Test
    public void staleElementException01(){

        driver.get("https://pages.ebay.com/");
        WebElement search=driver.findElement(By.id("gh-ac"));
        search.sendKeys("coffe machine"+ Keys.ENTER);

        driver.navigate().to("https://www.google.com/");
        driver.navigate().back();
        driver.get("https://pages.ebay.com/");
        search=driver.findElement(By.id("gh-ac"));
        search.sendKeys("tea pot"+ Keys.ENTER);




    }
}
