package com.myfirstseleniumproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class day02_FirefoxTest {
    public static void main(String[] args) throws InterruptedException {WebDriverManager.chromedriver().setup();

        ChromeOptions options =new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");

        WebDriver driver = new ChromeDriver(options);


//Create a new class under : FirefoxTest
//Create main method
//Create firefox driver
//Open home page https://www.amazon.com/
//Maximize the window
//Close/Quit the browser



        //Create firefox driver
      //  WebDriverManager.firefoxdriver().setup();

       // WebDriver driver = new ChromeDriver();

        //Open home page https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //    Thread.sleep(3000);

        driver.navigate().refresh();

        //Maximize the window

        driver.manage().window().maximize();

        //Close the window
       // driver.close();

    }
}

