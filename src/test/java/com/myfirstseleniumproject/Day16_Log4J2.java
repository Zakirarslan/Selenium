package com.myfirstseleniumproject;

import com.myfirstseleniumproject.utilities.LoggerUtils;
import org.junit.jupiter.api.Test;

public class Day16_Log4J2 extends com.myfirstseleniumproject.utilities.LoggerUtils {
    @Test
    public void log4j2Test(){
        System.out.println(" this is how I print info in the console..." + "\n");

        LoggerUtils.info(" this is how a developer or SDET print info in the console and also in a file...");
    }



}
