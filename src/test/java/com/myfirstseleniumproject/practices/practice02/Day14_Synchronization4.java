package com.myfirstseleniumproject.practices.practice02;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day14_Synchronization4 extends TestBase {
    @Test
    public void isEnabled(){

        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls ");

        //Click enable Button
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();


        waitForVisibility(driver.findElement(By.id("message")),10);
        WebElement enableMessage = driver.findElement(By.id("message"));



        //   fluentWait("//p[@id='message']",30,3);

        //And verify the message is equal to "It's enabled!"
        Assertions.assertTrue(enableMessage.getText().contains("enabled"));

        //And verify the textbox is enabled (I can type in the box)

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertTrue(textBox.isEnabled());



        //And click on Disable button
        WebElement disableButton = driver.findElement(By.xpath("//button[.='Disable']"));
        disableButton.click();


        //And verify the message is equal to "It's disabled!"
        waitForVisibility(driver.findElement(By.id("message")),15);

        Assertions.assertTrue(driver.findElement(By.id("message")).getText().contains("disabled"));

        //And verify the textbox is disabled (I cannot type in the box)

        Assertions.assertFalse(textBox.isEnabled());

        //NOTE: .isEnabled(); is used to check if an element is enabled or not
    }
}
