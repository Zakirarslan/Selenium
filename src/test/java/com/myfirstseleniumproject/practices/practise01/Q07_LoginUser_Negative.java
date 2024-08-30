package com.myfirstseleniumproject.practices.practise01;

import com.myfirstseleniumproject.utilities.TestBase;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q07_LoginUser_Negative extends TestBase {

/*
1. Navigate to url 'http://automationexercise.com'

2. Click on the Signup/Login button

3. Enter incorrect email and password

4. Click 'login' button

5. Verify error "Your email or password is incorrect!" is visible

 */
    @Test
    public void loginNegative(){

       // 1. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        try {driver.findElement(By.xpath("//p[contains(text(), 'Consent')]")).click();

        }catch (Exception e){
            System.out.println("Consent pop-up not found or already handled.");

        }

        //2. Click on the Signup/Login button
        driver.findElement(By.xpath("//a[contains(text(),' Signup / Login')]")).click();

        //3. Enter incorrect email and password
        WebElement emailBox=driver.findElement(By.name("email"));
        WebElement passwordBox=driver.findElement(By.name("password"));

        passwordBox.sendKeys("techpro321.");





    }
}
