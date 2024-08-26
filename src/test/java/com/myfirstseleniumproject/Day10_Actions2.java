package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day10_Actions2 extends TestBase {

    @Test
    public void dragAndDrop(){
        //Create a class: Action2
        Actions action=new Actions(driver);

        //Create a method dragAndDropTest()

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");


        //And user moves the target element(Drag me to my target) in to
        switchIframeByIndex(0);
        WebElement dragBox=driver.findElement(By.id("draggable"));
        WebElement dropBox=driver.findElement(By.id("droppable"));
        action.dragAndDrop(dragBox,dropBox).perform();
        //destination(Drop here)

    }
}
