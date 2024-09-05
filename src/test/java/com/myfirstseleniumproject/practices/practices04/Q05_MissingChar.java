package com.myfirstseleniumproject.practices.practices04;

import com.github.javafaker.Faker;
import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Q05_MissingChar extends TestBase {
    @Test
    public void missingChar(){

        //    The paper on which your password is written has gotten wet, and the last character of your password cannot be read.


       //    Write a code that randomly generates a solution for this issue.


       //    App: https://testcenter.techproeducation.com/index.php?page=form-authentication





        int counter=0;
        while(true){
            counter++;
            driver.get("https://testcenter.techproeducation.com/index.php?page=form-authentication");

            WebElement userNameBox=driver.findElement(By.id("exampleInputEmail1"));
            WebElement passwordBox=driver.findElement(By.id("exampleInputPassword1"));
            WebElement submitButton=driver.findElement(By.xpath("//button[@type='submit']"));

            userNameBox.sendKeys("techproed ");
            String pass="SuperSecretPasswor"+Faker.instance().lorem().characters(1);
            System.out.println("pass = " + pass);
            passwordBox.sendKeys(pass);
            submitButton.click();
            try {
                String success=driver.findElement(By.xpath("//div[@role='alert']")).getText();
                System.out.println("success = " + success);
                boolean isSuccess=success.contains("You logged into a secure area!");
                if (isSuccess){
                    System.out.println("counter = " + counter);
                    break;
                }

            }catch(Exception e){

            }


        }













    }
}
