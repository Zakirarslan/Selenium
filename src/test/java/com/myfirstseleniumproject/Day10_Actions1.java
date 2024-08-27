package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class Day10_Actions1 extends TestBase {

   // Given user is on the https://www.amazon.com/
   // When user click on "Account" link
   // Then verify the page title contains "Your account"
   // Then scroll to Amazon Music element at the bottom of the page
   // Click on it
   // Then verify Amazon Music page is displayed
   // Scroll the page up and down

    @Test

    public void actions1() throws IOException, InterruptedException {

        //Given user is on the https://www.amazon.com/
        //When user click on "Account" link
        //Then verify the page title contains "Your account"
        //Then scroll to Amazon Music element at the bottom of the page
        //Click on it
        //Then verify Amazon Music page is displayed
        //Scroll the page up and down



            //Given user is on the https://www.amazon.com/


            //1. create objects from actions class
            Actions actions = new Actions(driver);
            driver.get("https://www.amazon.com");
            Thread.sleep(1000);

            driver.navigate().refresh();


            //When user click on "Account" link

            WebElement accountListTab = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

            //2. use to moveToElement function to hover over to specfic element
            actions.moveToElement(accountListTab).perform();

            WebElement account = driver.findElement(By.linkText("Konto"));

            //    account.click(); this is same way as actioncs.click method.....
            actions.click(account).perform();

            //Then verify the page title contains "Your account"

            Assertions.assertTrue(driver.getTitle().contains("Mein Konto"));



            actions.sendKeys(Keys.ARROW_DOWN).perform();

            Thread.sleep(2000);

            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(1000);

            actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAUSE).sendKeys(Keys.PAGE_UP).perform();

            Thread.sleep(1000);

            actions.sendKeys(Keys.ARROW_UP).perform();
            Thread.sleep(1000);

            actions.sendKeys(Keys.ARROW_LEFT).perform();
            Thread.sleep(1000);

            actions.sendKeys(Keys.ARROW_RIGHT).perform();
            Thread.sleep(1000);



            //Then scroll to Amazon Music element at the bottom of the page
            WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));


            actions.moveToElement(amazonMusic).perform();
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(3000);



            //Click on it
            actions.click(amazonMusic).perform();

            //Then verify Amazon Music page is displayed
            Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
            Thread.sleep(5000);


            //Scroll the page up and down

    }
        @Test
        public void actionTestWithReasuble() throws InterruptedException {

                //Given user is on the https://www.amazon.com/
                driver.get("https://www.amazon.com/");

                //1. create objects from actions class
                Actions actions = new Actions(driver);

                //When user click on "Account" link

                WebElement accountListTab = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

                //2. use to moveToElement function to hover over to specfic element
                //     actions.moveToElement(accountListTab).perform();

                actionsHoverOnElement(accountListTab);

                WebElement account = driver.findElement(By.linkText("Account"));

                //    account.click(); this is same way as actioncs.click method.....

                //    actions.click(account).perform();

                actionsDoubleClick(account);

                //Then verify the page title contains "Your account"

                Assertions.assertTrue(driver.getTitle().contains("Your Account"));



                Thread.sleep(3000);

                //  actions.sendKeys(Keys.ARROW_DOWN).perform();

                actionsScrollDown();

                Thread.sleep(2000);

                //     actions.sendKeys(Keys.ARROW_DOWN).perform();

                actionsScrollDown();
                Thread.sleep(1000);

                actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAUSE).sendKeys(Keys.PAGE_UP).perform();

                Thread.sleep(1000);

                //   actions.sendKeys(Keys.ARROW_UP).perform();
                Thread.sleep(1000);

                actionsScrollUp();

                //    actions.sendKeys(Keys.ARROW_LEFT).perform();
                Thread.sleep(1000);

                actionsScrollLeft();

                //    actions.sendKeys(Keys.ARROW_RIGHT).perform();
                Thread.sleep(1000);

                actionsScrollRight();



                //Then scroll to Amazon Music element at the bottom of the page
                WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));


                //  actions.moveToElement(amazonMusic).perform();

                actionsHoverOnElement(amazonMusic);

                //     actions.sendKeys(Keys.ARROW_DOWN).perform();

                actionsScrollDown();
                Thread.sleep(3000);



                //Click on it
                //      actions.click(amazonMusic).perform();

                actionsDoubleClick(amazonMusic);

                //Then verify Amazon Music page is displayed
                Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
                Thread.sleep(5000);

        }

}
