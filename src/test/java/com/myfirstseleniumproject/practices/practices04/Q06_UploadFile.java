package com.myfirstseleniumproject.practices.practices04;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q06_UploadFile extends TestBase {
    @Test
    public void uploadFileText(){

        // Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
        // Click "Choose File" button
        // Type "My File" into "Notes about the file" input
        // Select the file to upload
        // Click on "Press" button
        // Assert that "Your notes on the file were" equals "My File"
        // Assert that file Content contains "Hello, I am uploaded file"

        // Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);
        String path = userHome + "/Desktop/Q06.txt"; //"C:\Users\paulr\Desktop\Q06.txt"

// Click "Choose File" button
        driver.findElement(By.name("upfile")).sendKeys(path);

// Type "My File" into "Notes about the file" input
        driver.findElement(By.name("note")).sendKeys("My File");

// Click on "Press" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

// Assert that "Your notes on the file were" equals "My File"
        String note = driver.findElement(By.xpath("//blockquote")).getText();
        System.out.println("note = " + note);
        Assertions.assertTrue(note.contains("My File"));

        // Assert that file Content contains "Hello, I am uploaded file"
        String content=driver.findElement(By.xpath("//pre")).getText();
        assertTrue(content.contains("Hello, I am uploaded file"));

    }
}