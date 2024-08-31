package com.myfirstseleniumproject.practices.practise01;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q09_Products extends TestBase {

     /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Click on 'View Product' of first product
5. User is landed to product detail page
6. Verify that detail is visible: product name, category, price, availability, condition, brand
     */

    @Test
    public void launchTest(){

        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

          try {driver.findElement(By.xpath("//*[contains(text(), 'Einwilligen')]")).click();

         }catch (Exception e) {
              System.out.println("Consent pop-up not found or already handled.");
          }

        //Click on 'Products' button
        WebElement productsButton=driver.findElement(By.xpath("//a[@href='/products']"));
        productsButton.click();

        //Click on 'View Product' of first product
        int c=1;
        WebElement viewProduct1=driver.findElement(By.xpath("//a[@href='/product_details/"+c+"']"));
        clickByJS(viewProduct1);

        //User is landed to product detail page

        WebElement productDetails=driver.findElement(By.xpath("//div[@class='product-information']"));
        assertTrue(productDetails.isDisplayed());

        //Verify that detail is visible: product name, category, price, availability, condition, brand

        //nameTest
        WebElement productName=driver.findElement(By.xpath("//div[@class='product-information']//h2"));
        assertTrue(productName.getText().length()>0);

        //categoryTest
        WebElement productCategory=driver.findElement(By.xpath("//div[@class='product-information']//p[contains(text(), 'Category')]"));

        assertTrue(productCategory.getText().length()>0);

        //priceTest
        WebElement productPrice=driver.findElement(By.xpath("//div[@class='product-information']//span//span"));
        assertTrue(productPrice.getText().length()>0);

        //availability Test
        WebElement productAvailability=driver.findElement(By.xpath("//p[b[text()='Availability:']]"));
        String textAfterAvailability=productAvailability.getText().replace("Availability:","").trim();
        assertTrue(textAfterAvailability.length()>0);

        //conditionTest
        WebElement productCondition=driver.findElement(By.xpath("//p[b[text()='Condition:']]"));
        String textAfterCondition=productCondition.getText().replace("Condition:","").trim();
        assertTrue(textAfterCondition.length()>0);

        WebElement productBrand=driver.findElement(By.xpath("//p[b[text()='Brand:']]"));
        String textAfterBrand=productBrand.getText().replace("Brand:","").trim();

        assertTrue(textAfterBrand.length()>0);











    }
}
