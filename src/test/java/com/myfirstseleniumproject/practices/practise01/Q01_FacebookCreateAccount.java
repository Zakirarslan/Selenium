package com.myfirstseleniumproject.practices.practise01;

import com.github.javafaker.Faker;
import com.myfirstseleniumproject.utilities.TestBase;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class Q01_FacebookCreateAccount extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //    Navigate to Go to https://www.facebook.com/

        driver.get("https://www.facebook.com");
       driver.findElement(By.xpath("//*[@id='facebook']/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]/div[1]/div/div[1]/div/span/span")).click();
        Thread.sleep(1000);

       //    click on 'Create new account'
        System.out.println("======Step 2=============");
        driver.findElement(By.xpath("//form/div/a[@role='button']")).click();
        Thread.sleep(1000);

        //    Enter first name
        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker=new Faker();
        firstName.sendKeys(faker.name().firstName());

        //    Enter last name
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        //    Enter mobile number or email
        WebElement email=driver.findElement(By.xpath("//input[@name='reg_email__']"));
        String fakeEmail=faker.internet().emailAddress();
        email.sendKeys(fakeEmail);
        WebElement emailConfirm=driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        emailConfirm.sendKeys(fakeEmail);


        //         Enter new password Jan 10 2000
        WebElement pswrd=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        pswrd.sendKeys(faker.internet().password(7,15));

        //        Enter birthday Jan 10 2000 dropdown
        WebElement day=driver.findElement(By.xpath("//select[@id='day']"));
        dropdownSelectByVisibleText(day,"10");

        //        Enter Month Jan 10 2000 dropdown
        WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
        dropdownSelectByValue(month,"1");

        //        Enter Year Jan 10 2000 dropdown
        WebElement year=driver.findElement(By.id("year"));
        dropdownSelectByValue(year,"2000");

        //        Enter gender

        WebElement genderM=driver.findElement(By.xpath("//input[@value='2']"));
        genderM.click();

        //        Click Sign Up
        WebElement registerButton=day.findElement(By.xpath("//button[text()='Registrieren'][1]"));
        registerButton.click();








    }
 }
