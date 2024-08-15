package com.myfirstseleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_VerifyGetPageSource {
    public static void main(String[] args) {
        //Create driver object from WebDriver
        WebDriver driver = new ChromeDriver();

        //Make maximize window

        driver.manage().window().maximize();

        //Test if amazon contains "Registry" on the homepage
        //Create a new class : GetPageSource

        driver.get("https://www.amazon.com/");

        String pageSource = driver.getPageSource();
        //    System.out.println("pageSource = " + pageSource);

        if(pageSource.contains("Registry")){

            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        //Close the window
        driver.quit();


    }
}
