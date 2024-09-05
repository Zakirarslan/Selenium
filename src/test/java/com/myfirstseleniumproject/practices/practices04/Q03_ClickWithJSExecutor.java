package com.myfirstseleniumproject.practices.practices04;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q03_ClickWithJSExecutor extends TestBase {
    @Test
    public void clickWithJSExecutor(){

        //    Go to https://testcenter.techproeducation.com/
        driver.get("https://testcenter.techproeducation.com/");

        //    Click on 'Back to top' at the bottom - use JSExecuter
        WebElement backToTop=driver.findElement(By.partialLinkText("Back to top"));

       // try {
       //     backToTop.click();
       // }catch (Exception e){
       //     System.out.println(e.getMessage());
       // }
           clickByJS(backToTop);











    }
}
