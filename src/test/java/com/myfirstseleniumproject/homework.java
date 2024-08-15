package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class homework extends TestBase {

    @Test
    public void dropdownSize(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement webState=driver.findElement(By.id("state"));

        Select slcState=new Select(webState);
        List<WebElement> allStates = slcState.getOptions();
        System.out.println("allStates.size() = " + allStates.size());


    }

}
