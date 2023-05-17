package com.epam.training.student_Aleksei_Guskov.service;

import com.epam.training.student_Aleksei_Guskov.model.VariableNumberOfInstance;

public class VariantsChoice {
    public static final String NUMBER_OF_INSTANCE = "testdata.number.of.instance";
    public static final String OPERATING_SYSTEM = "testdata.web.element.operation.system";
    public static final String LOCAL_SSD_AMOUNT = "testdata.web.element.local.SSD.of.x375.GB.amount";
    public static final String COMMITTED_USAGE = "testdata.wev.element.years.of.committed.usage";
    public static final String GRADUATION_FOR_YEARS = "testdata.graduation.for.years.of.committed.usage";
    public static final String TOTAL_ESTIMATED = "testdata.total.estimated";
    public static VariableNumberOfInstance withCredentialsFromProperty() {
        return new VariableNumberOfInstance(TestDataReader.getTestData(NUMBER_OF_INSTANCE),
                TestDataReader.getTestData(OPERATING_SYSTEM),
                TestDataReader.getTestData(LOCAL_SSD_AMOUNT),
                TestDataReader.getTestData(COMMITTED_USAGE),
                TestDataReader.getTestData(GRADUATION_FOR_YEARS),
                TestDataReader.getTestData(TOTAL_ESTIMATED));
    }
}
