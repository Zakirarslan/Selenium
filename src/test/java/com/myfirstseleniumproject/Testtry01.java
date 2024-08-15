package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Testtry01 extends TestBase {

    @Test
    public void test01(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement dr1=driver.findElement(By.id("dropdown"));
        dr1.click();

        Select slc1=new Select(dr1);
        slc1.selectByVisibleText("Option 1");




    }
}
