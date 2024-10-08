package com.myfirstseleniumproject.practices.practice02;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Q03_TestCase09_SearchProduckt extends TestBase {
    @Test
    public void testCase09(){

      //1. Launch browser
      //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

      //3. Verify that home page is visible successfully
        try {driver.findElement(By.xpath("//p[contains(text(),'Consent')]")).click();
        }catch(Exception e) {
            System.out.println("Consent pop-up not found or already handled");}

      WebElement home=driver.findElement(By.partialLinkText("Home"));
        Assertions.assertTrue(home.getText().contains("Home"));

        //4. Click on 'Products' button
        //driver.findElement(By.partialLinkText("Products")).click();
        WebElement products=driver.findElement(By.xpath("//a[@href='/products']"));
        clickByJS(products);

      //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assertions.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed());

      //6. Enter product name in search input and click search button
        WebElement search=driver.findElement(By.id("search_product"));
        search.sendKeys("dress");

      //7. Verify 'SEARCHED PRODUCTS' is visible

       WebElement searchButton=driver.findElement(By.xpath("//button[@id='submit_search']"));
       clickByJS(searchButton);
       Assertions.assertTrue(driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed());

      //8. Verify all the products related to search are visible

       List<WebElement> productList=driver.findElements(By.xpath("//div[@class='features_items']/div[@class='col-sm-4']"));

        //div[@class='productinfo text-center']//p
        for (WebElement each:productList){
            Assertions.assertTrue(each.isDisplayed());


        }
        Assertions.assertTrue(productList.size()>0,"No products ");


    }
}
