package com.myfirstseleniumproject.practices.practices04;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q01_Calculate extends TestBase {

    @Test
    public void additionTest() {

        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculator under Micro Apps
        WebElement calculateButton=driver.findElement(By.id("calculatetest"));
        clickWithTimeOut(calculateButton,2);

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("5");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("3");

        // Click on Calculate
        //WebElement calculateButton=
        driver.findElement(By.id("calculate")).click();

        // Get the result
        String result=driver.findElement(By.id("answer")).getText();

        // Verify the result
        Assertions.assertEquals(result,"8");

        // Print the result
        System.out.println("result = " + result);

    }

    @Test
    public void multyplyTest() {

        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculator under Micro Apps
        WebElement calculateButton=driver.findElement(By.id("calculatetest"));
        clickWithTimeOut(calculateButton,2);

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("8");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("2");

        //Select multiply
        WebElement operation=driver.findElement(By.id("function"));
        dropdownSelectByVisibleText(operation,"times");

        // Click on Calculate
        //WebElement calculateButton=
        driver.findElement(By.id("calculate")).click();

        // Get the result
        String result=driver.findElement(By.id("answer")).getText();

        // Verify the result
        Assertions.assertEquals(result,"16");

        // Print the result
        System.out.println("result = " + result);

    }
    @Test
    public void substractTest(){


    }
    @Test
    public void divisionTest(){


    }

}
