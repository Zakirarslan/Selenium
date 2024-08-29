package com.myfirstseleniumproject.practices.practise01;

import com.myfirstseleniumproject.utilities.TestBase;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q06_LoginUser extends TestBase {
     /*
    1. Navigate to url 'http://automationexercise.com'
    2. Click on the Signup/Login button
    3. Enter correct email and password
    4. Click 'login' button
    5. Verify that 'Logged in' is visible
     */

    @Test
    public void testLoginUserPozitif() {


//1. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        try {
            driver.findElement(By.xpath("//p[contains(text(), 'Consent')]")).click();
        } catch (Exception e) {
            System.out.println("Consent pop-up not found or already handled.");
        }
//2. Click on the Signup/Login button
        driver.findElement(By.xpath("//a[contains(text(), ' Signup / Login')]")).click();
//3. Enter correct email and password
        driver.findElement(By.name("email")).sendKeys("techpro@ed.com");
        driver.findElement(By.name("password")).sendKeys("techpro321.");
//4. Click 'login' button
        driver.findElement(By.xpath("//button[@type='submit'][1][1]")).click();
//5. Verify that 'Logged in' is visible
        assertTrue(driver.findElement(By.xpath(" //a[contains(text(), 'Logged in')]")).getText().contains("Logged in"));
    }
}