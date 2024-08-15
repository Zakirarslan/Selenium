package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class day07_DropDownForReusableMethods extends TestBase {
    @Test
    @Disabled
    public void dropdown() throws InterruptedException {

        //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        //Create method selectByIndexTest and Select Option 1 using index

        //1.step identify the locator
        WebElement simple = driver.findElement(By.id("dropdown"));
        Thread.sleep(2000);
        dropdownSelectByVisibleText(simple,"Option 1");


    }
    @Test
    public void dob () throws InterruptedException {
        //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        //1.step locate the dropdown element for year
        WebElement year = driver.findElement(By.id("year"));
        WebElement mont = driver.findElement(By.xpath("//select[@id='month']"));
        WebElement day = driver.findElement(By.cssSelector("select[id='day']"));
        Thread.sleep(1000);
        dropdownSelectByValue(year,"2006");
        Thread.sleep(1000);
        dropdownSelectByIndex(By.id("month"),6);




    }




}
