package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day12_FileDownload01 extends TestBase {

   // Create a class:FileDownloadTest downloadTest()
   // In the downloadTest() method, do the following test:
   // https://the-internet.herokuapp.com/download
   // Download .jpeg  file
   // Then verify if the file downloaded successfully

    @Test
    public void fileDownloadTest() throws InterruptedException {
        // Create a class:FileDownloadTest downloadTest()

        // In the downloadTest() method, do the following test:

        // https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");


        // Download .jpeg  file
        driver.findElement(By.linkText("virat.jpeg")).click();

        Thread.sleep(5000);
        // Then verify if the file downloaded successfully
        String path=System.getProperty("user.home")+"\\Downloads\\virat.jpeg";
        boolean isExists= Files.exists(Paths.get(path));
        Assertions.assertTrue(isExists);
    }

    @Test
    public void fileDownloadTest01() throws InterruptedException {
       // Create a class:FileDownloadTest downloadTest()
       // In the downloadTest() method, do the following test:
       // https://testcenter.techproeducation.com/index.php?page=file-download
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");


        driver.findElement(By.linkText("b10 all test cases, code.docx")).click();
        Thread.sleep(5000);

        String path01=System.getProperty("user.home")+"\\Downloads\\b10 all test cases, code.docx";

        boolean isExistsDoc=Files.exists(Paths.get(path01));
        Assertions.assertTrue(isExistsDoc,"not found");





    }

}
