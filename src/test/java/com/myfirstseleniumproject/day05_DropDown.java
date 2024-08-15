package com.myfirstseleniumproject;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class day05_DropDown extends TestBase {



        //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
//
//Create method selectByIndexTest and Select Option 1 using index
//Create method selectByValueTest Select Option 2 by value
//Create method selectByVisibleTextTest Select Option 1 value by visible text
//Create method printAllTest Print all dropdown value
//Verify the dropdown has Option 2 text
//Create method printFirstSelectedOptionTest Print first selected option
//Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.



        @Test @Disabled
        public void dropdown() throws InterruptedException {

            //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
            driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

            //Create method selectByIndexTest and Select Option 1 using index

            //1.step identify the locator
            WebElement simple = driver.findElement(By.id("dropdown"));

            //2.step create an object from select class and add object from webelement into select constructor...

            Select options = new Select(simple);


            //3. step we have an object so we can interact with dropdown element.....
            Thread.sleep(3000);
            options.selectByIndex(1);
            Thread.sleep(3000);


            //Create method selectByValueTest Select Option 2 by value
            options.selectByValue("2");
            Thread.sleep(3000);


            //Create method selectByVisibleTextTest Select Option 1 value by visible text
            options.selectByVisibleText("Option 1");
            Thread.sleep(3000);

            //Create method printAllTest Print all dropdown value
            List<WebElement> allItem = options.getOptions();

            for (WebElement each:allItem){

                System.out.println(each.getText());
            }

            //Verify the dropdown has Option 2 text
            WebElement firstSelected =  options.getFirstSelectedOption();

            Assertions.assertTrue(firstSelected.getText().contains("Option 1"));

        }


        @Test
        public void dob () throws InterruptedException {
            //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
            driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

            //1.step locate the dropdown element for year
            WebElement year = driver.findElement(By.id("year"));

            //2.step create an object from select class

            Select selectYear = new Select(year);

            Thread.sleep(3000);
            //3. step we can choose one of the item (2012)
            selectYear.selectByVisibleText("2012");
            Thread.sleep(3000);


            //1. step locate the dropdown element for month
            WebElement mont = driver.findElement(By.xpath("//select[@id='month']"));

            //2.step create an object from select class

            Select selectMont = new Select(mont);

            //3. step we can choose one of the item (August)
            Thread.sleep(3000);
            selectMont.selectByVisibleText("August");
            Thread.sleep(3000);

            //1. step locate the dropdown element for day
            WebElement day = driver.findElement(By.cssSelector("select[id='day']"));

            //2.step create an object from select class

            Select selectDay = new Select(day);

            //3. step we can choose one of the item (15)
            Thread.sleep(3000);
            selectDay.selectByValue("15");
            Thread.sleep(3000);


        }




    }