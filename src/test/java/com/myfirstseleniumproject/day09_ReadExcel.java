package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class day09_ReadExcel {
    //Create a new test method : readExcel()
    //Store the path of the file in a string Open the file
    //Open the workbook using fileinputstream
    //Open the first worksheet
    //Go to first row
    //Go to first cell on that first row and print
    //Go to second cell on that first row and print
    //Go to 2nd row first cell and assert if the data equal to USA
    //Go to 3rd row 2nd cell-chain the row and cell
    //Find the number of row
    //Find the number of used row
    @Test
    public void readExcel(){
        //Create a new test method : readExcel()
        //String path="C:\\Users\\zakir\\Downloads\\Capitals.xlsx";
        String path="resources/Capitals.xlsx";

        //Store the path of the file in a string Open the file
       try {
            FileInputStream fileInputStream=new FileInputStream(path);

            //Open the workbook using fileinputstream
           Workbook workbook= WorkbookFactory.create(fileInputStream);

           //Open the first worksheet
          Sheet sheet1= workbook.getSheet("Sheet1");

           //Go to first row
           Row row1=sheet1.getRow(0);

           //Go to first cell on that first row and print
           Cell cell1=row1.getCell(0);
           System.out.println("cell1 = " + cell1);

           //Go to second cell on that first row and print
            Cell r1c2=row1.getCell(1);
           System.out.println("r1c2 = " + r1c2);

           //Go to 2nd row first cell and assert if the data equal to USA
           Row row2=sheet1.getRow(1);
           Cell r2c1=row2.getCell(0);
           Assertions.assertTrue(r2c1.toString().equals("USA"));

           //Go to 3rd row 2nd cell-chain the row and cell

           Row row3=sheet1.getRow(2);
           String r3c2=row3.getCell(1).toString();
           Assertions.assertTrue(r3c2.contains("Paris"));

           //Find the number of row
           int totalNumberOfRow=sheet1.getLastRowNum()+1;
           System.out.println("totalNumberOfRow = " + totalNumberOfRow);

           int usedRow=sheet1.getPhysicalNumberOfRows();
           System.out.println("usedRow = " + usedRow);


       } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
           throw new RuntimeException(e);
       }














    }



}
