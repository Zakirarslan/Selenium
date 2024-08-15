package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import java.util.Set;


import java.util.Set;

public class day09_Cookies extends TestBase {
    @Test
    public void cookiesTest() throws InterruptedException {



        //Go to amazon  and automate the tasks:
        driver.get("https://www.trendyol.com/");


        //Find the total number of cookies
        Set<Cookie> cookieList = driver.manage().getCookies();
        System.out.println("Total Number Of Cookies = " + cookieList.size());

        //Print all the cookies
        for (Cookie eachCookie : cookieList){

            System.out.println("Each cookie = " + eachCookie);
            System.out.println();
            System.out.println("Each Value = " + eachCookie.getValue());
            System.out.println();
            System.out.println("Domain = "+eachCookie.getDomain());
            System.out.println("getName = " + eachCookie.getName());
        }
        //Get the cookies by their name
        System.out.println();
        System.out.println("Get cookies by their name");
        System.out.println("Get cookies by their name = " + driver.manage().getCookieNamed("FirstSession"));
        //Add new cookie
        System.out.println();
        System.out.println("ADD NEW COOKIE");
        Cookie addNewCookie = new Cookie("login_name" , "loginCookies");

        driver.manage().addCookie(addNewCookie);

        for (Cookie eachCookie :  driver.manage().getCookies()){

            System.out.println("Each cookie = " + eachCookie);
            System.out.println();
            System.out.println("Each Value = " + eachCookie.getValue());
            System.out.println();
            System.out.println("Domain = "+eachCookie.getDomain());
            System.out.println("getName = " + eachCookie.getName());
        }
        //Delete all cookies
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);

        Set<Cookie> emptyList = driver.manage().getCookies();
        Assertions.assertTrue(emptyList.isEmpty());

    }
}