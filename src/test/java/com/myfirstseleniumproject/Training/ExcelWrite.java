package com.myfirstseleniumproject.Training;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    @Test
    public void excellWrite() throws IOException {
        String excel = "resources/Capitals.xlsx";
        FileInputStream fileInput = new FileInputStream(excel);
        Workbook workbook= WorkbookFactory.create(fileInput);
        Sheet sheet4=workbook.getSheet("Sheet4");

        Row row1=sheet4.createRow(0);
        Row row2=sheet4.createRow(1);
        Row row3=sheet4.createRow(2);
        Row row4=sheet4.createRow(3);
        Row row5=sheet4.createRow(4);


        Cell r1c1=row1.createCell(0);
        r1c1.setCellValue("Zakir");

        sheet4.getRow(1).createCell(0).setCellValue("Nargiza");

        sheet4.getRow(2).createCell(0).setCellValue("Meryem");
        sheet4.getRow(3).createCell(0).setCellValue("Elif");
        sheet4.getRow(4).createCell(0).setCellValue("Emine");

        sheet4.getRow(0).createCell(1).setCellValue("Arslanov");
        sheet4.getRow(1).createCell(1).setCellValue("Arslanova");
        sheet4.getRow(2).createCell(1).setCellValue("Arslanova");
        sheet4.getRow(3).createCell(1).setCellValue("Arslanova");
        sheet4.getRow(4).createCell(1).setCellValue("Arslanova");



       for (int i=0; i<5;i++){
           System.out.println(sheet4.getRow(i).getCell(0).toString()+" "
                   +sheet4.getRow(i).getCell(1));
       }

       FileOutputStream outputStream=new FileOutputStream(excel);
       fileInput.close();
       workbook.close();





    }

}
