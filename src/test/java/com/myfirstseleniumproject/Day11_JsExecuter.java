package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day11_JsExecuter extends TestBase {

    @Test
    public  void jsExecuterTest() throws InterruptedException {
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
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);

        driver.navigate().refresh();


        //When user click on "Account" link

        WebElement accountListTab = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

        //2. use to moveToElement function to hover over to specfic element
        actions.moveToElement(accountListTab).perform();

        WebElement account = driver.findElement(By.linkText("Konto"));


        // 1 create js referance
        JavascriptExecutor js=(JavascriptExecutor)driver;

        // 2 step use executeScript
        js.executeScript("arguments[0].click();",account);



        //    account.click(); this is same way as actioncs.click method.....
        // actions.click(account).perform();

        //Then verify the page title contains "Your account"

        Assertions.assertTrue(driver.getTitle().contains("Mein Konto"));



        //actions.sendKeys(Keys.ARROW_DOWN).perform();


        // actions.sendKeys(Keys.ARROW_DOWN).perform();

        //   js.executeScript("window.scrollBy(0,250)");

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //all down

        Thread.sleep(2000);

        //     actions.sendKeys(Keys.PAGE_UP).perform();

        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);"); //all up
        Thread.sleep(2000);






        //Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);",amazonMusic);
        Thread.sleep(2000);



        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);



        //Click on it
        actions.click(amazonMusic).perform();


        //Then verify Amazon Music page is displayed
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
        Thread.sleep(5000);




    }
}
