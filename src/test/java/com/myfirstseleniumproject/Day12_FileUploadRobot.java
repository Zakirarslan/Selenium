package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Day12_FileUploadRobot extends TestBase {
    @Test
    public void fileUploadTest() throws InterruptedException, AWTException {
       //Create a class:FileUploadTest
       //Method name: fileUploadTest()
       //When user goes to
        //https://testpages.herokuapp.com/styled/file-upload-test.html
       //And click on the upload button
       //Then user selects an image from the desktop
       //Then verify the message 'You uploaded a file. This is the result.' is displayed

        //https://testpages.herokuapp.com/styled/file-upload-test.html
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");

        //And click on the upload button
        WebElement chooseFile = driver.findElement(By.id("fileinput"));
        //clickByJS(chooseFile);
        actionsDoubleClick(chooseFile);
        Thread.sleep(2000);

        //Then user selects an image from the desktop
        String pathOfImage=System.getProperty("user.home")+"\\Downloads\\virat.jpeg";



        //Create Robot object from robot class
        StringSelection ss=new StringSelection(pathOfImage);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        Robot robot=new Robot();

        //pressing control V
        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_ENTER);


        //robot.keyRelease(KeyEvent.VK_CONTROL);
        //robot.keyRelease(KeyEvent.VK_V);
        ////Click  image in the radiobutton
        //Thread.sleep(3000);
        //robot.keyPress(KeyEvent.VK_ENTER);
        //robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(By.id("itsanimage")).click();

        Thread.sleep(3000);



        //Click upload button

        WebElement uploadButton = driver.findElement(By.name("upload"));

        uploadButton.click();

        //Then verify the message 'You uploaded a file. This is the result.' is displayed


        Assertions.assertTrue(driver.findElement(By.id("uploadedfilename")).getText().contains("virat"));






    }
}













