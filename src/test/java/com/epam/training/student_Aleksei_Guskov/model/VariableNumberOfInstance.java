package com.epam.training.student_Aleksei_Guskov.model;

import java.util.Objects;

public class VariableNumberOfInstance {
    private String numberOfInstance;

    public VariableNumberOfInstance(String numberOfInstance) {
        this.numberOfInstance = numberOfInstance;
    }
    public String getNumberOfInstance() {
        return numberOfInstance;
    }
    public void setNumberOfInstance(String numberOfInstance) {
        this.numberOfInstance = numberOfInstance;
    }
    @Override
    public String toString() {
        return "VariableNumberOfInstance{" +
                "numberOfInstance='" + numberOfInstance + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VariableNumberOfInstance)) return false;
        VariableNumberOfInstance that = (VariableNumberOfInstance) o;
        return Objects.equals(numberOfInstance, that.numberOfInstance);
    }
    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstance);
    }
}
