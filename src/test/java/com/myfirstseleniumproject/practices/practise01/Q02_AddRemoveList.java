package com.myfirstseleniumproject.practices.practise01;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Q02_AddRemoveList extends TestBase {
    @Test
    public void test02() throws InterruptedException {
      //Given
      //    Go to http://the-internet.herokuapp.com/add_remove_elements/

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
      //When
      //    Click on the "Add Element" button 100 times
        WebElement addElemntButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i=1; i<=100; i++){
            Thread.sleep(20);
            addElemntButton.click();
        }
        WebElement parentElement=driver.findElement(By.xpath("//div[@id='elements']"));
        List<WebElement> childElements=parentElement.findElements(By.xpath("./button"));
      // int s=1;
      // for (WebElement each: childElements) {
      //     System.out.println(s+" - " + each.getText());
      //     s++;
      //   }
        System.out.println(childElements.size());
      //And
      //    Click on the "Delete" button 20 times
        WebElement deleteButton=driver.findElement(By.xpath("//*[@id='elements']/button[1]"));

        for (int i=1; i<=20;i++){
            driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();

        }
         // Then
         // Assert that 20 buttons were deleted.


        WebElement ParentafterDelete=driver.findElement(By.xpath("//div[@id='elements']"));
        List<WebElement> listAfterDelete=parentElement.findElements(By.xpath("./button"));
        System.out.println("listAfterDelete.size() = " + listAfterDelete.size());

        Assertions.assertEquals(listAfterDelete.size(),80);
    }

}
