package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class day04_checkbox extends TestBase {


    @Test
    public void checkbox() throws InterruptedException {

        //user goes to website
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");
        //check box1
        WebElement box1 = driver.findElement(By.id("box1"));

        if (!box1.isSelected()){
            box1.click();

        }

        //check box2
        WebElement box2 = driver.findElement(By.id("box2"));

        if (!box2.isSelected()){

            box2.click();
        }
        Thread.sleep(5000);
        //Assert that box1 and box2 selected...
        Assertions.assertTrue(box1.isSelected());
        Assertions.assertTrue(box2.isSelected());



    }




}