package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class day05_Alerts extends TestBase {
    //Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
    //Create a class: AlertTest
    //Create setUp method Create 3 test methods:
    //acceptAlert() => click on the first alert, verify the text "I am a JS Alert"
    //click OK
    //and Verify "You successfully clicked an alert"
    //
    //dismissAlert()=> click on the second alert, verify text "I am a JS Confirm"
    //click cancel
    //and Verify "You clicked: Cancel"
    //
    //sendKeysAlert()=> click on the third alert, verify text "I am a JS prompt",
    //type "Hello World", click OK
    //and Verify "You entered: Hello World"

    @Test
    public void acceptAlert() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. step locate the element to click button
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        //acceptAlert() => click on the first alert, verify the text "I am a JS Alert"
        Thread.sleep(3000);
       // String verifyAlert = driver.switchTo().alert().getText();
        String verifyAlert = alertGetText();

        assertTrue(verifyAlert.equals("I am a JS Alert"));
        Thread.sleep(3000);
        //3. step there is an alert so we need to handle this alert to execution....
       // driver.switchTo().alert().accept();
        alertAccept();
        Thread.sleep(3000);

        //and Verify "You successfully clicked an alert"

        String successfullyMessage = driver.findElement(By.id("result")).getText();

        assertTrue(successfullyMessage.equals("You successfully clicked an alert"));

    }

    @Test
    public void dismissAlert() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //click comfirm alert
        driver.findElement(By.xpath("(//button[@onclick='jsConfirm()'])[1]")).click();
        Thread.sleep(3000);
        //dismissAlert()=> click on the second alert, verify text "I am a JS Confirm"
       //String verifyAlert = driver.switchTo().alert().getText();
        String verifyAlert=alertGetText();
        assertTrue(verifyAlert.equals("I am a JS Confirm"));

        Thread.sleep(3000);
        //click cancel
       // driver.switchTo().alert().dismiss();
        alertDismiss();
        Thread.sleep(3000);
        //and Verify "You clicked: Cancel"
        String cancelMessage = driver.findElement(By.id("result")).getText();
        Thread.sleep(3000);
        assertTrue(cancelMessage.equals("You clicked: Cancel"));


    }

    @Test
    public void sendKeys() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //sendKeysAlert()=> click on the third alert,
        driver.findElement(By.xpath("(//button[@onclick='jsPrompt()'])[1]")).click();
        Thread.sleep(3000);
        // verify text "I am a JS prompt",
        //String verifyAlert = driver.switchTo().alert().getText();
        String verifyAlert=alertGetText();
        assertTrue(verifyAlert.equals("I am a JS prompt"));
        Thread.sleep(3000);


        //type "Hello World", click OK
       // driver.switchTo().alert().sendKeys("Hello World");
        alertTypeOnAlert("Hello World");
        Thread.sleep(5000);

        //driver.switchTo().alert().accept();
        alertAccept();
        Thread.sleep(3000);

        //and Verify "You entered: Hello World"
        String helloMessage =  driver.findElement(By.id("result")).getText();

        assertTrue(helloMessage.equals("You entered: Hello World"));

    }
}