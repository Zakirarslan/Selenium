package com.myfirstseleniumproject.practices.practise01;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q08_ContactUsForm extends TestBase {
    /*  1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Click on 'Contact Us' button
      4. Enter name, email, subject and message
      5. Upload file
      6. Click 'Submit' button
      7. Click OK button
      8. Verify success message 'Success! Your details have been submitted successfully.' is visible
      9. Click 'Home' button and verify that landed to home page successfully*/
    @Test
    public void contactUsFormTest() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://www.automationexercise.com");
        // WebElement consent=driver.findElement(By.xpath("//p[contains(text(), 'Consent')])"));

        try {driver.findElement(By.xpath("//p[contains(text(),'Consent')]")).click();
        }catch(Exception e) {System.out.println("Consent pop-up not found or already handled");}

        //3. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[contains(text(),'Contact us')]")).click();

        //4. Enter name, email, subject and message
        driver.findElement(By.name("name")).sendKeys("John Doe");
        driver.findElement(By.name("email")).sendKeys("johnDoe@example");
        driver.findElement(By.name("subject")).sendKeys("Testing contact us form");
        driver.findElement(By.name("message")).sendKeys("This is a test message");

        //5. Upload file
        WebElement fileInput=driver.findElement(By.xpath("//input[@name='upload_file']"));
       // driver.findElement(By.name("upload_file"));
        String path="C:\\Users\\zakir\\Downloads\\zakir.png";
        fileInput.sendKeys(path);
        Thread.sleep(5000);


        //6. Click 'Submit' button
        driver.findElement(By.xpath("//input[@type='submit']")).click();


        //7. Click OK button
        alertAccept();


        //8. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]")).isDisplayed());


        //9. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[contains(text(),' Home')]")).click();

        String current="https://www.automationexercise.com/";

        Assertions.assertEquals(current,driver.getCurrentUrl());




    }
}
