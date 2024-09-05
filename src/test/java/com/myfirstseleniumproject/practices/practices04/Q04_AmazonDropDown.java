package com.myfirstseleniumproject.practices.practices04;

import com.myfirstseleniumproject.utilities.TestBase;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Q04_AmazonDropDown extends TestBase {

    @Test
    public void amazonDropDown() throws InterruptedException {

       // /Go to https://amazon.com
        driver.get("https://amazon.com.tr");

        //Print all the options in the 'Departments' dropdown on the left side of the search box
        WebElement dropdown=driver.findElement(By.id("searchDropdownBox"));
        List<WebElement> amazonDropdownOptions=driver.findElements(By.id("searchDropdownBox"));

        for (WebElement each:amazonDropdownOptions
             ) {
            System.out.println("each.getText() = " + each.getText());

        }
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchButton=driver.findElement(By.id("twotabsearchtextbox"));


       // Search for each first five options and print titles
        for (int i = 1; i < 6; i++) {
            String option = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions().get(i).getText();
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(option, Keys.ENTER);
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }



    }
}
