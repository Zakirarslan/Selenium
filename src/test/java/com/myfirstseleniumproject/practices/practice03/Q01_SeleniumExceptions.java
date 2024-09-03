package com.myfirstseleniumproject.practices.practice03;

import com.myfirstseleniumproject.utilities.TestBase;
import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Q01_SeleniumExceptions extends TestBase {

    @Test
    public void NoSuchSessionExpection(){
        driver.get("https://pages.ebay.com/");
        driver.close();
        driver.findElement(By.id("gh-ac"));
    }
    @Test
    public void NullPointerExpection(){
        driver.get("https://pages.ebay.com/");

        driver.findElement(By.id("gh-ac"));
    }

}
