package com.myfirstseleniumproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class day10_WriteExcel {

    //Create a new class: WriteExcel
    //Create a new method: writeExcel()

    @Test
    public void writeExcel() throws IOException {
        //Store the path of the file as string and open the file
        String path="resources/Capitals.xlsx";

        //Open the workbook
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook =WorkbookFactory.create(fileInputStream);

        //Open the first worksheet
        Sheet sheet1=workbook.getSheet("Sheet1");

        //Go to the first row
        //Write and save the workbook
        Row row1=sheet1.getRow(0);


        //Create a cell on the 3rd column (2nd index) on the first row
        Cell r1c3=row1.createCell(2);

        //Write "POPULATION" on that cell
        r1c3.setCellValue("POPULATION");

        //Create a cell on the 2nd row 3rd cell(index2), and write 150000

        Row row2=sheet1.getRow(1);
        Cell r2c3=row2.createCell(2);
        r2c3.setCellValue("150000");

        //Create a cell on the 3rd row 3rd cell(index2), and write 250000
        Row row3=sheet1.getRow(2);
        Cell r3c3=row3.createCell(2);
        r3c3.setCellValue("250000");

        //Create a cell on the 4th row 3rd cell(index2), and write 54000
        sheet1.getRow(3).createCell(2).setCellValue("54000");

        //Write data and save into the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //Close the file
        fileInputStream.close();
        //Close the workbook
        workbook.close();





    }






}
