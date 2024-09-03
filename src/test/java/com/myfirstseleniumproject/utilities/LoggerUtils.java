package com.myfirstseleniumproject.utilities;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerUtils {

    //This reusable class is used for logging information in the test classes
    private static String LoggerUtils;
    private static Logger logger= LogManager.getLogManager().getLogger(LoggerUtils);

    public static void info(String message){
        logger.info(message);
    }

    public static void inwarnfo(String message){
        logger.warning(message);
    }





}
