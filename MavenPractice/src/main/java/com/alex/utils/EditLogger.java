package com.alex.utils;

import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.LogManager;

@Log
public class EditLogger {
    private static final LogManager logManager = LogManager.getLogManager();

    static {
        try {
            logManager.readConfiguration(Resources.getResourceAsStream("loggerconfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertLogPrint(String... insertStudent) {
        log.info("Add a new student: " + Arrays.toString(insertStudent));
    }
}
