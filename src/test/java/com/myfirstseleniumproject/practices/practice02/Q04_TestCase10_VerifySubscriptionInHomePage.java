package com.myfirstseleniumproject.practices.practice02;

import com.github.javafaker.Faker;
import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q04_TestCase10_VerifySubscriptionInHomePage extends TestBase {
    @Test
    public void TC10(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        try {driver.findElement(By.xpath("//p[contains(text(), 'Consent')]")).click();

        }catch (Exception e){
            System.out.println("Consent pop-up not found or already handled.");
        }
        String url=driver.getCurrentUrl();
        System.out.println("url = " + url);
        Assertions.assertTrue(url.equals("https://automationexercise.com/"));
        //4. Scroll down to footer

        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        actionsScrollDown();
        //5. Verify text 'SUBSCRIPTION'
        WebElement subscription=driver.findElement(By.xpath("//div//h2[contains(text(),\"Subscription\")]"));
        assertTrue(subscription.isDisplayed());
        //6. Enter email address in input and click arrow button
        Faker fk=new Faker();
        String fakeEmail=fk.internet().emailAddress();
        WebElement subscriptionEmail=driver.findElement(By.id("susbscribe_email"));
        subscriptionEmail.sendKeys(fakeEmail);
        driver.findElement(By.id("subscribe")).click();

        //7. Verify success message 'You have been successfully subscribed!' is visible

        WebElement subscribeSuccess=driver.findElement(By.xpath("//div[contains(text(), 'You have been successfully subscribed!')]"));
        assertTrue(subscribeSuccess.isDisplayed());

    }







}
