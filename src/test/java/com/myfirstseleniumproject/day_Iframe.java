package com.myfirstseleniumproject;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class day_Iframe extends TestBase {

    @Test
    public void iframe(){
        // Go to   https://testpages.herokuapp.com/styled/frames/frames-test.html
        // Then Assert that "Left List Item 29" is the last element in the "Left"
        // And Assert that "Middle List Item 39" is the last element in the "Middle"

        // Go to   https://testpages.herokuapp.com/styled/frames/frames-test.html
        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
        
        // we need to switch iframe first
       // driver.switchTo().frame(1);
       // driver.switchTo().frame("left");
        switchIframeByIdOrName("left");
        //    // Task 1
        // Then Assert that "Left List Item 29" is the last element in the "Left"
        List<WebElement> listOfElementsLeft=driver.findElements(By.xpath("//li"));
        String lastElement=listOfElementsLeft.get(listOfElementsLeft.size()-1).getText();

        Assertions.assertTrue(lastElement.equals("Left List Item 29"));

        // 2.way
        String lastElement1=driver.findElement(By.xpath("//li[last()]")).getText();
        Assertions.assertTrue(lastElement1.equals("Left List Item 29"));

      //  for (WebElement each: listOfElementsLeft ) {
      //      System.out.println(each.getText());        }


            // Task 2
        // And Assert that "Middle List Item 39" is the last element in the "Middle"
        // Driver is on the left iframe so we can o
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='middle']")));

        String lastElementForMiddle=driver.findElement(By.xpath("//li[last()]")).getText();
        System.out.println(lastElementForMiddle);
        Assertions.assertTrue(lastElementForMiddle.equals("Middle List Item 39"));
       // List<WebElement> listOfElementsMiddle=driver.

        
        

    }
}
