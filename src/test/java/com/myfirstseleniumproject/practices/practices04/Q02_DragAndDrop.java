package com.myfirstseleniumproject.practices.practices04;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q02_DragAndDrop extends TestBase {
    @Test
    public void dragAndDrop() throws IOException {
        extentTest.pass("Navigating to the application home page")
                .assignAuthor("Isa","Anisa","Zakir")
                .assignCategory("Smoke","Regration","Integration")
                .assignDevice("Mac","Windows")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());
        //Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        // Drag orange elements on proper boxes below
        WebElement bank=driver.findElement(By.partialLinkText("BANK"));
        WebElement sales=driver.findElement(By.partialLinkText("SALES"));
        WebElement firstAmount=driver.findElement(By.xpath("//li[@id='fourth'][1]"));
        WebElement secondAmount=driver.findElement(By.xpath("//li[@id='fourth'][2]"));

        WebElement debitAccount=driver.findElement(By.id("bank"));
        WebElement debitAmount=driver.findElement(By.id("amt7"));
        WebElement creditAccount=driver.findElement(By.id("loan"));
        WebElement creditAmount=driver.findElement(By.id("amt8"));

        actionsDragAndDrop(bank,debitAccount);
        waitFor(1);
        actionsDragAndDrop(firstAmount,debitAmount);
        waitFor(1);
        actionsDragAndDrop(sales,creditAccount);
        waitFor(1);
        actionsDragAndDrop(secondAmount,creditAmount);
        waitFor(1);


        //  Verify they are dropped.
        String successMessage=driver.findElement(By.id("equal")).getText();
        System.out.println("successMessage = " + successMessage);
        assertTrue(successMessage.contains("Perfect"));
        extentTest.pass("Resault contains United Kingdom")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString(),"Ater Submit button click");



    }
}
