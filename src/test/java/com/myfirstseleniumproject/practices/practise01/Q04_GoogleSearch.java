package com.myfirstseleniumproject.practices.practise01;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q04_GoogleSearch extends TestBase {
    @Test
    public void test04(){

    //Create driver and go to http://www.google.com in the BeforeEach method
        driver.get("http://www.google.com");
        driver.findElement(By.id("L2AGLb")).click();
    //With 3 different test methods:
        WebElement searchBox=driver.findElement(By.id("APjFqb"));
        WebElement googleSearch=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[4]/div[6]/center/input[1]"));

    // -Type "Desktop" in the search box and search it
        String desktop="Desktop";
        serachmethod(desktop);

        searchBox.sendKeys(desktop);
        googleSearch.click();


    // -Type "Smartphone" in the search box and search it
        String smatphone="Smartphone";

    // -Type "Laptop" in the search box and search it
        String laptop="Laptop";

    //NOTE: Print the result numbers in AfterEach method
    //Close driver with AfterEach method





    }

    private void serachmethod(String product) {

    }

}
