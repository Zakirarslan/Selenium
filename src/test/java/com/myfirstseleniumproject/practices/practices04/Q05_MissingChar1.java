package com.myfirstseleniumproject.practices.practices04;

import com.github.javafaker.Faker;
import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Q05_MissingChar1 extends TestBase {

//    The paper on which your password is written has gotten wet, and the last character of your password cannot be read.
//    Write a code that randomly generates a solution for this issue.
//    App: https://testcenter.techproeducation.com/index.php?page=form-authentication

    @Test
    public void missingCharTest(){

        //Navigate to https://testcenter.techproeducation.com/index.php?page=form-authentication
        driver.get("https://testcenter.techproeducation.com/index.php?page=form-authentication");

        int counter = 0;
        while (true){ //we create an infinite while loop here and use if statement inside when we find the correct combination for password
            counter++; //we increase the counter tofind out how many attempts driver had to make before it gets the successMessage


            //Enter Username
            driver.findElement(By.cssSelector("input[name='username']")).sendKeys("techproed");
            //Enter Password
            String password = "SuperSecretPasswor" + Faker.instance().lorem().characters(1);
            System.out.println("password = " + password);
            driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
            //Click on Submit
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            //Verify that login is successful
            try {
                String successMessage = driver.findElement(By.xpath("//div[@role='alert']")).getText();
                System.out.println("successMessage = " + successMessage);

                boolean isSuccess = successMessage.contains("You logged into a secure area!");

                if (isSuccess) {
                    System.out.println("counter = " + counter);
                    break; // This will break the loop if we log in successfully
                }
            }catch (Exception e){
            }
        }
    }
}


