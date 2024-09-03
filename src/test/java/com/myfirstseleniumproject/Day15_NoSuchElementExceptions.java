package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day15_NoSuchElementExceptions extends TestBase {
    @Test
    public void noSauchElementExceptionsTest01(){

        //1. Navigate to 'https://www.ebay.com/' url
        driver.get("https://www.ebay.com/");


        //2.
        WebElement search=driver.findElement(By.id("*gh-ac"));
        search.sendKeys("coffe machine"+ Keys.ENTER);

    }
    @Test
    public void noSauchElementExceptionsTest02(){

        // 1.Navigate to
        driver.get("https://jqueryui.com/droppable/");
        Actions action=new Actions(driver);
        switchIframeByIndex(0);
        WebElement a=driver.findElement(By.id("draggable"));
        WebElement b=driver.findElement(By.id("droppable"));

        actionsDragAndDrop(a,b);



    }
}
