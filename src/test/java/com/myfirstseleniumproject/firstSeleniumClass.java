package com.myfirstseleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class firstSeleniumClass {
    public static void main(String[] args) {


    System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver=new EdgeDriver();
        driver.get("https://www.google.com");
       //driver.get("https://www.amazon.com");
      // driver.get("https://www.amazon.com");


    }
}
