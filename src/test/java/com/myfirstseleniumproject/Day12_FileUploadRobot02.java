package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Day12_FileUploadRobot02 extends TestBase {
    //Create a class:FileUploadTest
    //Method name: fileUploadTest()
    //Given user goes to https://www.grammarly.com/plagiarism-checker
    //Then click upload file
    //Then selects a document
    //And upload that file

    @Test
    public void FileUploadTest() throws AWTException, InterruptedException {
//Create a class:FileUploadTest
        //Method name: fileUploadTest()
        // Given user goes to https://www.grammarly.com/plagiarism-checker

        driver.get("https://www.grammarly.com/plagiarism-checker");

        Thread.sleep(2000);

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        Thread.sleep(2000);
        //Then click upload file


        driver.findElement(By.xpath("//span[text()='Upload a file']")).click();

        //Then selects a document
//
//    String path = System.getProperty("user.home")+ "/Downloads/zakir.txt";
//
//    StringSelection ss = new StringSelection(path);
//
//    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
//
//    Robot robot = new Robot();
//
//
//        robot.delay(300);
//
//        //pressing control V
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        Thread.sleep(2000);
//
//
//        //Release control V part
//
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_V);
//       Thread.sleep(2000);
//
//       robot.keyPress(KeyEvent.VK_ENTER);
//       robot.keyRelease(KeyEvent.VK_ENTER);

        //And upload that file

        uploadFile(System.getProperty("user.home")+ "/Downloads/zakir.txt");


    }

}