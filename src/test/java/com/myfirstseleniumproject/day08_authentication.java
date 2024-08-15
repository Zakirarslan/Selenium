package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class day08_authentication extends TestBase {
    @Test
    public void authentication() throws InterruptedException {

       // Auth are used for security reason
       // One way to auth is to use below syntax: https://username:password@URL
       // username : admin
       // password : admin
       // url	: the-internet.herokuapp.com/basic_auth
       // URL FOR AUTH:
       // https://admin:admin@the-internet.herokuapp.com/basic_auth
       // driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); This will auth the page

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(1000);
        WebElement autorized=driver.findElement(By.tagName("p"));

        System.out.println("autorized.getText() = " + autorized.getText());
        Assertions.assertTrue(autorized.getText().contains("Congratulations"));



    }
}
