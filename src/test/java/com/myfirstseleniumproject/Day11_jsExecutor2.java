package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day11_jsExecutor2 extends TestBase {
    @Test
    public void jsExecutorTestWithReasuble() throws InterruptedException {


        //Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //1. create objects from actions class
        Actions actions = new Actions(driver);

        //When user click on "Account" link

        WebElement accountListTab = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

        //2. use to moveToElement function to hover over to specfic element
        actions.moveToElement(accountListTab).perform();

        WebElement account = driver.findElement(By.linkText("Account"));

        //1 create js reference
        //      JavascriptExecutor js = (JavascriptExecutor)driver;


        //2 step use executeScript js code
        //  js.executeScript("arguments[0].click()", account);

        clickWithTimeOut(account,5);





        //    account.click(); this is same way as actioncs.click method.....
        //actions.click(account).perform();

        //Then verify the page title contains "Your account"

        Assertions.assertTrue(driver.getTitle().contains("Your Account"));



        // actions.sendKeys(Keys.ARROW_DOWN).perform();

        //   js.executeScript("window.scrollBy(0,250)");

        //     js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //all down

        scrollAllDownJS();



        //     actions.sendKeys(Keys.PAGE_UP).perform();

        //   js.executeScript("window.scrollTo(0, -document.body.scrollHeight);"); //all up

        scrollAllUpJS();


        //Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));



        //       actions.moveToElement(amazonMusic).perform();

        //     js.executeScript("arguments[0].scrollIntoView(true);", amazonMusic);

        scrollIntoViewJS(amazonMusic);




        //Click on it
        //   actions.click(amazonMusic).perform();
        //       js.executeScript("arguments[0].click()", amazonMusic);

        clickWithTimeoutByJS(amazonMusic);


        //Then verify Amazon Music page is displayed
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
        Thread.sleep(5000);


    }

}
