package com.myfirstseleniumproject.practices.mentoringPractice;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QM02_AddProductsinCart extends TestBase {
    @Test
    public void addProductsinCart(){

      //1. Launch browser
      //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        try {driver.findElement(By.xpath("//p[contains(text(),'Consent')]")).click();
        }catch(Exception e) {System.out.println("Consent pop-up not found or already handled");}

        // 3. Verify that home page is visible successfully


        assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/"));

      //4. Click 'Products' button
       // WebElement products=driver.findElement(By.xpath("//a[@href='/products']"));
        WebElement products=driver.findElement(By.partialLinkText(" Products"));
        clickByJS(products);


      //5. Hover over first product and click 'Add to cart'
        WebElement product1AddCart=driver.findElement(By.xpath("//div[@class='overlay-content']//a[@data-product-id='1' and @class='btn btn-default add-to-cart']"));
        clickByJS(product1AddCart);
        Actions action=new Actions(driver);
     waitFor(2);
      //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[contains(text(), 'Continue Shopping')]")).click();


      //7. Hover over second product and click 'Add to cart'
        WebElement product2AddCart=driver.findElement(By.xpath("//div[@class='overlay-content']//a[@data-product-id='2' and @class='btn btn-default add-to-cart']"));
        clickByJS(product2AddCart);
        waitFor(2);

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[contains(text(), 'View Cart')]")).click();

      //9. Verify both products are added to Cart
        WebElement cartTable=driver.findElement(By.id("cart_info_table"));
        List<WebElement> rows=cartTable.findElements(By.tagName("tr"));
        assertTrue(rows.size()==3);


      //10. Verify their prices, quantity and total price
        WebElement row1=rows.get(1);
        WebElement row2=rows.get(2);
       // WebElement price=row1.findElement(By.xpath("//tr[1]//td[3]//p"));

      List<WebElement> product1Details=row1.findElements(By.tagName("td"));

        // Product1 price is not empty
        int price=Integer.valueOf(product1Details.get(2).getText().replaceAll("Rs.","").trim());
        System.out.println("price = " + price);
        assertTrue(!product1Details.get(2).getText().isEmpty());

        //Product1 quantity equals 1
         System.out.println("Quantity = "+Integer.parseInt(product1Details.get(3).getText()));
         int quantity=Integer.valueOf(product1Details.get(3).getText());
         assertTrue(quantity==1);

       //Product1 TotalPrice
        int totalPrice=Integer.valueOf(product1Details.get(4).getText().replaceAll("Rs.","").trim());
        assertTrue(totalPrice==quantity*price);
        System.out.println("TotalPrice = "+Integer.valueOf(product1Details.get(4).getText().replaceAll("Rs.","").trim()));


        List<WebElement> product2Details=row2.findElements(By.tagName("td"));

        // Product2 price is not empty
        int price2=Integer.valueOf(product2Details.get(2).getText().replaceAll("Rs.","").trim());
        System.out.println("price2 = " + price2);
        assertTrue(!product1Details.get(2).getText().isEmpty());

        //Product1 quantity equals 1
        System.out.println("Quantity2 = "+Integer.parseInt(product1Details.get(3).getText()));
        int quantity2=Integer.valueOf(product2Details.get(3).getText());
        assertTrue(quantity2==1);

        //Product1 TotalPrice
        int totalPrice2=Integer.valueOf(product2Details.get(4).getText().replaceAll("Rs.","").trim());
        assertTrue(totalPrice2==quantity2*price2);
        System.out.println("TotalPrice2 = "+Integer.valueOf(product2Details.get(4).getText().replaceAll("Rs.","").trim()));






    }
}
