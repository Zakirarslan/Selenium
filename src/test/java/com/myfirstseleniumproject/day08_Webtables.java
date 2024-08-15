package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class day08_Webtables extends TestBase {

        //https://the-internet.herokuapp.com/tables
        //Task 1 : Print the entire table and Assert if the last element in the table 1 is "edit delete"
        //Task 2 : Print All Rows
        //Task 3 : Print Last row data only
        //Task 4 : Print column 5 data in the table body
        //Task 5 :  Print the information of columns 1 and 2 in 3 rows
        //Task 6 : Write a method that accepts 2 parameters
        //Parameter 1 = row number
        //Parameter 2 = column number
        //printData(2,3);	=> prints data in 2nd row 3rd column


    @Test
    public void webTablesTest() throws InterruptedException {

        //https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Print the entire table and Assert if the last element in the table 1 is "edit delete"
        System.out.println("======TASK 1=====================");
        WebElement entireTable = driver.findElement(By.id("table1")); //this will return one single element and return the entire table.....
        System.out.println(entireTable.getText());

        //Assert if the last element in the table 1 is "edit delete"
        //way 1
        WebElement lastElement = driver.findElement(By.xpath("//table[@id='table1']//tr[4]//td[6]"));
        Thread.sleep(3000);
        System.out.println("Last element way 1: "+lastElement.getText());
        Assertions.assertTrue(lastElement.getText().contains("edit delete"));

        //way 2
        List<WebElement> allData  =  driver.findElements(By.xpath("//table[@id='table1']//td"));
        System.out.println(allData.get(allData.size() - 1).getText());
        String lastElementWay2 = allData.get(allData.size()-1).getText();
        Assertions.assertEquals("edit delete",lastElementWay2);

        //Task 2 : Print All Rows
        System.out.println("==================TASK 2=========");
        List<WebElement> allRows  =  driver.findElements(By.xpath("//table[@id='table1']//tr"));

        int rowNum = 1;
        for (WebElement eachRow : allRows){

            System.out.println("Row Number " + rowNum +" = " + eachRow.getText());
            rowNum++;
        }

        //Task 3 : Print Last row data only
        System.out.println("=============TASK 3=====================");
        System.out.println("Last Row in the table = "  +   allRows.get(allRows.size() - 1).getText());

        Assertions.assertTrue(allRows.get(allRows.size() - 1).getText().contains("Conway"));

        //Task 4 : Print column 5 data in the table body
        System.out.println();
        System.out.println("====================TASK 5======================");

        List<WebElement> col5 = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));

        for (WebElement eachData : col5){

            System.out.println("Row Number " + rowNum + " column 5 " + eachData.getText());
        }

        //Task 6 :  Print the information of columns 1 and 2 in 3 rows
        System.out.println("========TASK 6==============");

       // List<WebElement> Webelemnts1=new ArrayList<>();

        int row=1;
        do {
            int column=1;
            do {

                WebElement specificData = driver.findElement(By.xpath("//table[@id='table1']//tr["+row+"]//td["+column+"]"));
               System.out.println("Row Number  " + row +" "+ "column number  = " + column +" "+ specificData.getText());
                column++;
            }while (column<3);


            row++;
        }while (row<4);

        //Task 6 : Write a method that accepts 2 parameters
        //Parameter 1 = row number
        //Parameter 2 = column number
        //printData(2,3);   => prints data in 2nd row 3rd column

        System.out.println("========TASK 7==============");
        printData(2,3);


    }

    public void printData(int a,int b) {

                WebElement specificData1 = driver.findElement(By.xpath("//table[@id='table1']//tr["+a+"]//td["+b+"]"));
                System.out.println("Row Number  " + a +" "+ "column number  = " + b +" "+ specificData1.getText());
    }
}












