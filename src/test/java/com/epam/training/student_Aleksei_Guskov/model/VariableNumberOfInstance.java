package com.epam.training.student_Aleksei_Guskov.model;

import java.util.Objects;

public class VariableNumberOfInstance {
    private String numberOfInstance;
    private String operatingSystemXPath;
    private String totalEstimated;

    public VariableNumberOfInstance(String numberOfInstance,
                                    String operatingSystemXPath,
                                    String totalEstimated) {
        this.numberOfInstance = numberOfInstance;
        this.operatingSystemXPath = operatingSystemXPath;
        this.totalEstimated = totalEstimated;
    }
    public String getNumberOfInstance() {
        return numberOfInstance;
    }
    public void setNumberOfInstance(String numberOfInstance) {
        this.numberOfInstance = numberOfInstance;
    }

    public String getOperatingSystemXPath() {
        return operatingSystemXPath;
    }

    public void setOperatingSystemXPath(String operatingSystemXPath) {
        this.operatingSystemXPath = operatingSystemXPath;
    }

    public String getTotalEstimated() {
        return totalEstimated;
    }

    public void setTotalEstimated(String totalEstimated) {
        this.totalEstimated = totalEstimated;
    }

    @Override
    public String toString() {
        return "VariableNumberOfInstance{" +
                "numberOfInstance='" + numberOfInstance + '\'' +
                ", operatingSystemXPath='" + operatingSystemXPath + '\'' +
                ", totalEstimated='" + totalEstimated + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VariableNumberOfInstance)) return false;
        VariableNumberOfInstance that = (VariableNumberOfInstance) o;
        return Objects.equals(numberOfInstance, that.numberOfInstance) && Objects.equals(operatingSystemXPath, that.operatingSystemXPath) && Objects.equals(totalEstimated, that.totalEstimated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstance, operatingSystemXPath, totalEstimated);
    }
}
