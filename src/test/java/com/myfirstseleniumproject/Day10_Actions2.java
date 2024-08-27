package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day10_Actions2 extends TestBase {

    @Test
    public void dragAndDrop() throws InterruptedException {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        Actions actions = new Actions(driver);

        //    driver.switchTo().frame(0);
        switchIframeByIndex(0);
        Thread.sleep(3000);

        WebElement dragBox = driver.findElement(By.id("draggable"));
        WebElement dropBox = driver.findElement(By.id("droppable"));


        actions.dragAndDrop(dragBox,dropBox).perform();
        Thread.sleep(3000);


    }

    @Test
    public void dragAndDropTest01() throws InterruptedException {


        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        Actions actions = new Actions(driver);

        //    driver.switchTo().frame(0);
        //  switchIframeByIndex(0);

        switchIframeByWebElement(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        Thread.sleep(3000);

        WebElement dragBox = driver.findElement(By.id("draggable"));
        WebElement dropBox = driver.findElement(By.id("droppable"));


        //   actions.dragAndDrop(dragBox,dropBox).perform();

        //   actions.clickAndHold(dragBox).moveToElement(dropBox).release().build().perform();
        Thread.sleep(3000);

        actions.dragAndDropBy(dragBox,165,150).perform();





    }

}
