package com.myfirstseleniumproject.practices.practice02;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class der extends TestBase {
    @Test
    public void testCase09() {


        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully

        try {driver.findElement(By.xpath("//p[contains(text(),'Einwilligen')]")).click();
        }catch(Exception e) {
            System.out.println("Consent pop-up not found or already handled");}

        WebElement homeSign = driver.findElement(By.partialLinkText("Home"));
        Assertions.assertTrue(homeSign.getText().contains("Home"));


        //4. Click on 'Products' button

        WebElement productButton = driver.findElement(By.xpath("//a[@href='/products']"));
        clickByJS(productButton);


        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assertions.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed());
        //6. Enter product name in search input and click search button
        //7. Verify 'SEARCHED PRODUCTS' is visible
        //8. Verify all the products related to search are visible
    }
}
