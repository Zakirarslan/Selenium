package com.myfirstseleniumproject.practices.practice02;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day14_Synchronization3 extends TestBase {
    @Test
    public void synchronization1(){

        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Click on remove button
        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();

        WebElement goneMessage =driver.findElement(By.id("message"));
        waitForVisibility(goneMessage,15);

        //And verify the message is equal to "It's gone!"

        //   Assertions.assertTrue(goneMessage.getText().contains("gone"));

        Assertions.assertEquals("It's gone!",goneMessage.getText());


        //Then click on Add button

        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));

        addButton.click();

        WebElement addMessage =driver.findElement(By.id("message"));

        waitForVisibility(By.id("message"),20);


        //And verify the message is equal to "It's back!"

        Assertions.assertTrue(addMessage.getText().contains("back"));





    }
}
