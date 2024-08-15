package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class day06_Alert_Window_HW extends TestBase {
    @Test
    public void alertWindowHW() throws InterruptedException {
        //When Navigate to https://testpages.herokuapp.com/styled/windows-test.html

        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        //When Click on "Alerts In A New Window From JavaScript"
        driver.findElement(By.partialLinkText("Alerts In A New Window")).click();
        Thread.sleep(3000);
        //And Switch to new window
        String firstWindow = driver.getWindowHandle();
        System.out.println("firstWindow = " + firstWindow);

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("allWindowHandles = " + allWindowHandles);

        String secondWindow = "";

        for (String each : allWindowHandles){

            if (each != firstWindow){

                secondWindow = each;

            }

        }

        System.out.println("secondWindow = " + secondWindow);
        driver.switchTo().window(secondWindow);


        //And Click on "Show alert box" button
        driver.findElement(By.id("alertexamples")).click();
        Thread.sleep(3000);
        //And Accept alert
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        //And Click on "Show confirm box" buttond
        driver.findElement(By.id("confirmexample")).click();
        Thread.sleep(3000);

        //And Cancel alert
        alertDismiss();
        //Then Assert that alert is cancelled
        WebElement textForCancel = driver.findElement(By.xpath("//p[text()='You clicked Cancel, confirm returned ']"));


        Assertions.assertTrue(textForCancel.getText().contains("You clicked Cancel"));
        Thread.sleep(3000);

        //When Click on "Show prompt box" button
        driver.findElement(By.id("promptexample")).click();
        Thread.sleep(3000);

        //And Send "Hello World!" to the alert
        alertTypeOnAlert("Hello World!");
        Thread.sleep(3000);

        alertAccept();

        //Then Assert that "Hello World!" is sent
        WebElement assertForHello = driver.findElement(By.xpath("//p[text()='Hello World!']"));
        Thread.sleep(3000);
        Assertions.assertTrue(assertForHello.getText().contains("Hello World!"));
        Thread.sleep(3000);
    }
}