package com.epam.training.student_Aleksei_Guskov.service;

import com.epam.training.student_Aleksei_Guskov.model.VariableNumberOfInstance;

public class VariantsChoice {
    public static final String NUMBER_OF_INSTANCE = "testdata.number.of.instance";
    public static final String OPERATING_SYSTEM = "testdata.web.element.operation.system";
    public static final String TOTAL_ESTIMATED = "testdata.total.estimated";
    public static VariableNumberOfInstance withCredentialsFromProperty() {
        return new VariableNumberOfInstance(TestDataReader.getTestData(NUMBER_OF_INSTANCE),
                TestDataReader.getTestData(OPERATING_SYSTEM),
                TestDataReader.getTestData(TOTAL_ESTIMATED));
    }
}
