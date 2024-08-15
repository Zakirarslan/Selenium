package com.myfirstseleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class day01_BasicNavigations {
    public static void main(String[] args){
        /*
        When user goes to walmart
        Then goes to amazon
        Navigate back to Walmart
        Navigate forward to amazon
        Refresh the page
        Close/Quit the browser*/

    System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.walmart.com/");
        driver.navigate().to("https://www.amazon.com.tr/");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.close();



    }
}
