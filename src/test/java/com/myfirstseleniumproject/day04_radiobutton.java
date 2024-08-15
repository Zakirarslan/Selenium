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

public class day04_radiobutton extends TestBase {


    @Test
    public void radiobutton() {

        //user goes to website
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
        WebElement yellow=driver.findElement(By.id("yellow"));
        WebElement football=driver.findElement(By.id("football"));
        if (!yellow.isSelected()){
            yellow.click();
        }
        if (!football.isSelected()){
            football.click();
        }


        //Assert that box1 and box2 selected...
        Assertions.assertTrue(yellow.isSelected());
        Assertions.assertTrue(football.isSelected());



    }




}

