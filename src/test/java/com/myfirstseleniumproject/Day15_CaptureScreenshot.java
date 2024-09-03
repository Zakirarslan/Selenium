package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day15_CaptureScreenshot extends TestBase {

    @Test
    public void captureScreenshot() throws InterruptedException {

//Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        waitFor(1);
        captureScreenshotEntirePage();
//When user type "uni" in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
//And select the 'United Kingdom' from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[2]")).click();
        waitFor(1);
        captureScreenshotEntirePage();
//And click on submit button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='button']")).click();
//Then verify the result contains 'United Kingdom'
        assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));
        waitFor(1);
        captureScreenshotEntirePage();




    }
}
