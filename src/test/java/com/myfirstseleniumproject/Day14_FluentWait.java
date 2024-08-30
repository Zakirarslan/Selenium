package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Day14_FluentWait extends TestBase {
    @Test
    public void fluentWaitTest(){
        //Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1 ");


        //When user clicks on the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();


        //1. CREATE FLUENT WAIT
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)) //this is round time, every each 3 seconds driver try to see the element.....
                .withMessage("Ignoring No Such Element Exceptions") //giving a message about which exception we ignore.....
                .ignoring(NoSuchElementException.class); //ignore this exception.....

        WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4"));

        //2. step to use wait object

        //   wait.until(ExpectedConditions.visibilityOf(helloWorld));


        WebElement  finishButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));

        //Then verify the 'Hello World!' Shows up on the screen


        //  Assertions.assertTrue(helloWorld.getText().contains("Hello"));


        Assertions.assertTrue(finishButton.getText().contains("Hello"));

    }
    @Test
    public void fluentWaitTestReusable(){
        //Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1 ");


        //When user clicks on the Start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //1. CREATE FLUENT WAIT

        WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        fluentWait("//div[@id='finish']//h4",30,3);

        //Then verify the 'Hello World!' Shows up on the screen
        Assertions.assertTrue(helloWorld.getText().contains("Hello"));




    }
}

