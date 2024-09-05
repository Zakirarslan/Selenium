package com.myfirstseleniumproject.practices.practices04;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q07_DragAndDrop extends TestBase {
    @Test
    public void dragAndDrop(){

        //    Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement stockholm=driver.findElement(By.id("box2"));
        WebElement washington=driver.findElement(By.id("box3"));
        WebElement oslo=driver.findElement(By.id("box1"));
        WebElement copenhagen=driver.findElement(By.id("box4"));
        WebElement seoul=driver.findElement(By.id("box5"));
        WebElement rome=driver.findElement(By.id("box6"));
        WebElement madrid=driver.findElement(By.id("box7"));

        WebElement italy=driver.findElement(By.id("box106"));
        WebElement spain=driver.findElement(By.id("box107"));
        WebElement norway=driver.findElement(By.id("box101"));
        WebElement denmark=driver.findElement(By.id("box104"));
        WebElement southKorea=driver.findElement(By.id("box105"));
        WebElement sweden=driver.findElement(By.id("box102"));
        WebElement unitedStates=driver.findElement(By.id("box103"));

        //    Match capitals with countries

        actionsDragAndDrop(oslo,norway);
        ////div[@id='box101']//div[@style='visibility: visible; background-color: rgb(0, 255, 0);']
        actionsDragAndDrop(copenhagen,denmark);
        actionsDragAndDrop(washington,unitedStates);
        actionsDragAndDrop(seoul,southKorea);
        actionsDragAndDrop(rome,italy);
        actionsDragAndDrop(madrid,spain);
        actionsDragAndDrop(stockholm,sweden);





    }
}
