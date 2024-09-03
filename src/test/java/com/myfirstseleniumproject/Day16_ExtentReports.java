package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day16_ExtentReports extends TestBase {
    @Test
    public void extentsReportsTest01(){

        extentTest.pass("Login is successful");     // pass is used to mark as passed
        extentTest.fail("Login is failed");         // fail is used to mark as failed
        extentTest.skip("Login is skipped");
        extentTest.warning("Pay attention to login");
        extentTest.info("Login is successfulInfo");

        //Assertions.assertTrue("Amazon title".contains("Amazon"),"Amazon title test failed");

        if ("Amazon title".contains("Amazon")){
            extentTest.pass("Amazon title test PASSED");
           }else{ extentTest.fail("Amazon title test failed");
          }
    }

    @Test
    public void extentsReportsTest02() throws InterruptedException, IOException {

        extentTest.pass("Navigating to the application home page")
                .assignAuthor("Isa","Anisa","Zakir")
                .assignCategory("Smoke","Regration","Integration")
                .assignDevice("Mac","Windows")
                        .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());





        //Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        extentTest.pass("User is on the home page")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString(),"Home Page");

       //When user type "uni" in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        extentTest.pass("Typed uni in the search box")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString(),"Uni");



        //And select the 'United Kingdom' from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[2]")).click();
        extentTest.pass("Selected United Kingdom option")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString(),"United Kingdom");

        //And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();

        //Then verify the result contains 'United Kingdom'
        assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));
        extentTest.pass("Resault contains United Kingdom")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString(),"Ater Submit button click");






    }

}
