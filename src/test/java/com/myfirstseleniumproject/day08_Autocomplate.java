package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class day08_Autocomplate extends TestBase {

    @Test
    public void autoCompleteTest() throws InterruptedException {


        //Given user is on https://testcenter.techproeducation.com/index.php?%20page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?%20page=autocomplete");

        //When user type "uni" in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        Thread.sleep(3000);
        //And select the 'United Kingdom' from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[text()='ted Kingdom']")).click();
        Thread.sleep(3000);



        //And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();

        //Then verify the result contains 'United Kingdom'

        Thread.sleep(3000);
        WebElement result = driver.findElement(By.id("result"));

        Assertions.assertTrue(result.getText().contains("United Kingdom"));
    }
}
