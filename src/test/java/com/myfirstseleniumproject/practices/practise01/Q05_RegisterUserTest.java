package com.myfirstseleniumproject.practices.practise01;

import com.github.javafaker.Faker;
import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Q05_RegisterUserTest extends TestBase {
    /*
    Test Case 1: Register User
1. Launch browser - we extend the TestBase class to launch the browser by @BeforeEach annotation
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Click 'Delete Account' button
17. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
*/

     @Test
     public void testRegister(){
    //Test Case 1: Register User
    //1. Launch browser
    //2. Navigate to url 'http://www.automationexercise.com'
        driver.get("http://www.automationexercise.com");
   // WebElement consent=driver.findElement(By.xpath("//p[contains(text(), 'Consent')])"));

      try {driver.findElement(By.xpath("//p[contains(text(),'Einwilligen')]")).click();
            }catch(Exception e) {
        System.out.println("Consent pop-up not found or already handled");}
    //3. Verify that home page is visible successfully
        Assertions.assertTrue(driver.getTitle().contains("Automation Exercise"));

    //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

    //5. Verify 'New User Signup!' is visible
        Assertions.assertTrue(driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed());

         //6. Enter name and email address
         Faker faker = new Faker();
         String fakeName = faker.name().firstName();
         String fakeMail =  faker.internet().emailAddress();
         driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(fakeName);
         driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(fakeMail);
//7. Click 'Signup' button
         driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
         Assertions.assertTrue(driver.findElement(By.xpath("//b[contains(text(), 'Enter Account Information')]")).isDisplayed());
//9. Fill details: Title, Name, Email, Password, Date of birth
         //title
         if (new Random() .nextBoolean()){
             driver.findElement(By.id("id_gender1")).click();
         }else {
             driver.findElement(By.id("id_gender2")).click();
         }
         //password
         driver.findElement(By.id("password")).sendKeys(faker.internet().password(8,16));
         //date of birth
         int day = faker.number().numberBetween(1,31);
         int month = faker.number().numberBetween(1,12);
         int year = faker.number().numberBetween(1950,2021);
         new Select(driver.findElement(By.name("days"))).selectByValue(String.valueOf(day));
         new Select(driver.findElement(By.name("months"))).selectByValue(String.valueOf(month));
         new Select(driver.findElement(By.name("years"))).selectByValue(String.valueOf(year));
        // 10. Select checkbox 'Sign up for our newsletter!'
        // 11. Select checkbox 'Receive special offers from our partners!'
         driver.findElement(By.id("newsletter")).click();
         driver.findElement(By.id("optin")).click();
        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
          driver.findElement(By.id("first_name")).sendKeys(faker.name().firstName());
          driver.findElement(By.name("last_name")).sendKeys(faker.name().lastName());
          driver.findElement(By.id("company")).sendKeys(faker.company().name());
          driver.findElement(By.id("address1")).sendKeys(faker.address().secondaryAddress());
          new Select(driver.findElement(By.id("country"))).selectByVisibleText("United States");
          driver.findElement(By.id("state")).sendKeys(faker.address().state());
          driver.findElement(By.id("city")).sendKeys(faker.address().city());
          driver.findElement(By.id("zipcode")).sendKeys(faker.address().zipCode());
          driver.findElement(By.id("mobile_number")).sendKeys(faker.phoneNumber().cellPhone());

          WebElement newAccount=driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));
          clickByJS(newAccount);
        //((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(true);",
        //        driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")));

        // 13. Click 'Create Account button'
        // 14. Verify that 'ACCOUNT CREATED!' is visible
         Assertions.assertTrue(driver.findElement(By.xpath("//b[contains(text(), 'Account Created!')]")).isDisplayed());

        // 15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        // 16. Click 'Delete Account' button
         driver.findElement(By.xpath("//*[contains(text(),' Delete Account')]")).click();


        // 17. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
         Assertions.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]")).isDisplayed());



        }


}
