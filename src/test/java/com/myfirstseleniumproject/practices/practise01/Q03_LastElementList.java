package com.myfirstseleniumproject.practices.practise01;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Q03_LastElementList extends TestBase {
    @Test
    public void Test03(){

      //Given
      //  Go to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

      //When
      //  Enter the username  as "standard_user"
        String username="standard_user";
        WebElement userName=driver.findElement(By.id("user-name"));
        userName.sendKeys(username);

      //And
      //  Enter the password as "secret_sauce"
        String password="secret_sauce";
        WebElement passwordE=driver.findElement(By.id("password"));
        passwordE.sendKeys(password);

      //And
      //  Click on login button
        WebElement loginButton=driver.findElement(By.id("login-button"));
        loginButton.click();

      //And
      //  Order products by "Price (low to high)"
        WebElement drp=driver.findElement(By.tagName("select"));
        Select selectPrice=new Select(drp);
        dropdownSelectByVisibleText(drp,"Price (low to high)");



      //Then
      //  Assert that last product costs $49.99, first product costs $7.99
        WebElement products=driver.findElement(By.xpath("//div[@class='inventory_list']"));
        List<WebElement> productList=products.findElements(By.xpath("//div[@class='inventory_item']"));
      //  for (WebElement each: productList ) {
      //      System.out.println(each.getText());

      //  }
        String prc=productList.get(productList.size()-1).getText();
        Assertions.assertTrue(prc.contains("$49.99"));


    }
}
