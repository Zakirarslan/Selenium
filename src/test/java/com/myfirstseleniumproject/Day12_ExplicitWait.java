package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day12_ExplicitWait extends TestBase {
    @Test
    public void explicitWaitTest() throws InterruptedException {
       //Create a class:ExplicitWait
       //Create a method: explicitWait
       //Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
       //When user clicks on the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();        //clickByJS(startButton);
        //startButton.click();

        WebElement helloText=driver.findElement(By.xpath("//div[@id='finish']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(helloText));



       //Then verify the 'Hello World!' Shows up on the screen

        Assertions.assertTrue(helloText.isDisplayed());

    }
    @Test
    public void explicitWaitTestReusable() throws InterruptedException {
        //Create a class:ExplicitWait
        //Create a method: explicitWait
        //Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //When user clicks on the Start button

        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));
        waitForClickablility(startButton, 10);
        startButton.click();

        WebElement helloText = driver.findElement(By.xpath("//div[@id='finish']"));
        waitForVisibility(helloText, 10);
        //Then verify the 'Hello World!' Shows up on the screen

        Assertions.assertTrue(helloText.isDisplayed());
    }
}
