package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day15_CaptureScreenshotsOfElements extends TestBase {
    @Test
    public void captureScreenshotsOfElements01(){

//When user goes to the application home page https://www.techproeducation.com/
        //Then verify the logo is displayed



//When user goes to the application home page https://www.techproeducation.com/
            driver.get("https://www.techproeducation.com/");
            waitFor(1);
            captureScreenshotEntirePage();
//Then verify the logo is displayed
            WebElement logo = driver.findElement(By.xpath("//img[@alt='TechPro Education'][1]"));
            waitFor(1);
            captureScreenshotOfElement(logo);




    }
}
