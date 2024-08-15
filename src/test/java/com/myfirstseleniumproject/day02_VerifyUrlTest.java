package com.myfirstseleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class day02_VerifyUrlTest {
    public static void main(String[] args) {

        WebDriver driver=new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com/");
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.equals("https://www.techproeducation.com/")){
            System.out.println("Passed");

        }else {
            System.out.println("Failed");
        }
        driver.close();

    }
}
