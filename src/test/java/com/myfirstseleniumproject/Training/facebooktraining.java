package com.myfirstseleniumproject.Training;

import com.github.javafaker.Faker;
import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class facebooktraining extends TestBase {
    @Test
    public void facetest(){

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft'])[6]")).click();
        WebElement newAccount=driver.findElement(By.cssSelector("[id*='u_0_0']"));
        newAccount.click();

        WebElement nameBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        Faker fake=new Faker();

        setValueByJS(nameBox,fake.name().firstName());

        WebElement surnameBox=driver.findElement(By.xpath("//input[@name='lastname']"));
        setValueByJS(surnameBox,fake.name().lastName());






    }
}
