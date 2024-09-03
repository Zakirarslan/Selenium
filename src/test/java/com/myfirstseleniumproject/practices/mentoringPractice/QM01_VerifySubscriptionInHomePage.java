package com.myfirstseleniumproject.practices.mentoringPractice;

import com.github.javafaker.Faker;
import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QM01_VerifySubscriptionInHomePage extends TestBase {
    @Test
    public void verifySubscriptionInHomePage(){
       // 1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        try {driver.findElement(By.xpath("//p[contains(text(),'Consent')]")).click();
        }catch(Exception e) {System.out.println("Consent pop-up not found or already handled");}

       // 3. Verify that home page is visible successfully
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/"));


       // 4. Scroll down to footer
        scrollAllDownJS();

       // 5. Verify text 'SUBSCRIPTION'
        assertTrue(driver.findElement(By.xpath("//h2[contains(text(), 'Subscription')]")).isDisplayed());
       // 6. Enter email address in input and click arrow button
        Faker fk=new Faker();

        driver.findElement(By.id("susbscribe_email")).sendKeys(fk.internet().emailAddress());
        driver.findElement(By.id("subscribe")).click();

       // 7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement subscribeSuccessfully=driver.findElement(By.xpath("//div[contains(text(), 'You have been successfully subscribed!')]"));
        assertTrue(subscribeSuccessfully.isDisplayed());
        captureScreenshotEntirePage();
        captureScreenshotOfElement(subscribeSuccessfully);


    }
}
