package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day12_FileUpload extends TestBase {
   //Create a class:FileUploadTest
   //Method name: fileUploadTest()
   //When user goes to
   //https://testpages.herokuapp.com/styled/file-upload-test.html
   //And click on the upload button
   //Then user selects an image from the desktop
   //Then verify the message 'You uploaded a file. This is the result.' is displayed
    @Test
    public void fileUploadTest() throws InterruptedException {
        //When user goes to
        // https://testpages.herokuapp.com/styled/file-upload-test.html
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");

        //And click on the upload button
        WebElement chooseFile = driver.findElement(By.id("fileinput"));
        actionsDoubleClick(chooseFile);

        Thread.sleep(3000);

      // clickByJS(chooseFile);
        //Then user selects an image from the desktop
        String pathOfImage=System.getProperty("user.home")+"\\Downloads\\virat.jpeg";
        chooseFile.sendKeys(pathOfImage);

        Thread.sleep(3000);


        //Click  image in the radiobutton

        driver.findElement(By.id("itsanimage")).click();


        //Click upload button

        WebElement uploadButton = driver.findElement(By.name("upload"));

        uploadButton.click();

        //Then verify the message 'You uploaded a file. This is the result.' is displayed


        Assertions.assertTrue(driver.findElement(By.id("uploadedfilename")).getText().contains("virat"));



    }

}
