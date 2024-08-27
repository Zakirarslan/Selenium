package com.myfirstseleniumproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day11_FileExists {


    @Test
    public void fileExistsTest(){

        //Class: FileExistTest
        //Method: isExist
        //Pick a file on your desktop
        //And verify if that file exist on your computer or not
        String path=System.getProperty("user.home")+"\\Desktop\\Ann";
        Boolean isExist=Files.exists(Paths.get(path));
        Assertions.assertTrue(isExist , " , is not exists");




    }



}
