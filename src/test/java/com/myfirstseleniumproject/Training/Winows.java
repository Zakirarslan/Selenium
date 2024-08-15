package com.myfirstseleniumproject.Training;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class Winows extends TestBase {

    @Test
    public void WindowHandling(){
        //When Navigate to https://testpages.herokuapp.com/styled/windows-test.html
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

        //When Click on "Alerts In A New Window From JavaScript"
        driver.findElement(By.partialLinkText("Alerts In A New Window")).click();

        //And Switch to new window
        //String firstWindow= driver.getWindowHandle();
        Set<String> HandlWindow=driver.getWindowHandles();
        String firstWindow= driver.getWindowHandle();
        String secondWindow=null;

        for (String each:HandlWindow) {
           if (each!=firstWindow){
               secondWindow=driver.switchTo().window(each).getWindowHandle();
           }

        }
        System.out.println(firstWindow);
        System.out.println(secondWindow);
        driver.switchTo().window(secondWindow);

        //And Click on "Show alert box" button
        driver.findElement(By.id("alertexamples")).click();

        //And Accept alert
        driver.switchTo().alert().accept();

        //And Click on "Show confirm box" button
        driver.findElement(By.id("confirmexample")).click();

        //And Cancel alert
        driver.switchTo().alert().dismiss();
        driver.switchTo().window(secondWindow);

        //Then Assert that alert is cancelled

        //driver.findElement(By.linkText("You clicked OK, confirm returned "));
        List<WebElement> cancel= driver.findElements(By.xpath("//*[@id='confirmexplanation']"));
        Assertions.assertTrue(cancel.size()>0);
        //String cacelStr=cancel.getText();
        //  System.out.println(cacelStr);

      //  Assertions.assertTrue(cancel!=null);

        //When Click on "Show prompt box" button
        //And Send "Hello World!" to the alert
        //Then Assert that "Hello World!" is sent





    }



}
