package com.epam.training.student_Aleksei_Guskov.service;

import java.util.ResourceBundle;

public class ReaderOFNumbers {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
