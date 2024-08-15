package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class day06_Windows extends TestBase {
    @Test
    public void windowsTest() throws InterruptedException {


        //Go to https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        //Assert if the window 1 title equals "The Internet"
        Assertions.assertEquals(driver.getTitle(),"The Internet");
        //Click on the link
        //   driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //   driver.findElement(By.xpath("//a[.='Click Here']")).click();
        driver.findElement(By.linkText("Click Here")).click();

        Thread.sleep(5000);

        //Assert if the window 2 title equals "New Window"

        //1.step,we need to get current window handle
        String firstWindow =  driver.getWindowHandle();
        System.out.println(firstWindow);

        //2. step we need to get all Handles into our pocket....

        Set<String> allWindows = driver.getWindowHandles();
        System.out.println(allWindows);
        String secondWindow = "";
        for (String each : allWindows){

            if (each!= firstWindow){

                secondWindow = each;
            }
        }
        System.out.println("newWindow = " + secondWindow);


        //3. step, it is time to switch to new opened page with driver.....

        driver.switchTo().window(secondWindow);

        Assertions.assertTrue(driver.getTitle().contains("New Window"));


        //Switch back to window 1 title and assert if URL contains "windows"
        driver.switchTo().window(firstWindow);

        Assertions.assertTrue(driver.getCurrentUrl().contains("windows"));


        //And assert if the URL doesn't contains 'new'

        Assertions.assertFalse(driver.getCurrentUrl().contains("new"));

    }
}