package com.epam.training.student_Aleksei_Guskov.service;

import com.epam.training.student_Aleksei_Guskov.model.VariableNumberOfInstance;

public class NumberOfInstanceChoice {
    public static final String NUMBER_OF_INSTANCE = "testdata.number.of.instance";
    public static VariableNumberOfInstance withCredentialsFromProperty() {
        return new VariableNumberOfInstance(ReaderOFNumbers.getTestData(NUMBER_OF_INSTANCE));
    }
}
