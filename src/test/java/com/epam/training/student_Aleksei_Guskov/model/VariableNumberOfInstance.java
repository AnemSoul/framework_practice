package com.epam.training.student_Aleksei_Guskov.model;

import java.util.Objects;

public class VariableNumberOfInstance {
    private String numberOfInstance;
    private String operatingSystemXPath;
    private String localSSDAmount;
    private String committedUsage;
    private String graduationForYears;
    private String totalEstimated;

    public VariableNumberOfInstance(String numberOfInstance,
                                    String operatingSystemXPath,
                                    String localSSDAmount,
                                    String committedUsage,
                                    String graduationForYears,
                                    String totalEstimated) {
        this.numberOfInstance = numberOfInstance;
        this.operatingSystemXPath = operatingSystemXPath;
        this.localSSDAmount = localSSDAmount;
        this.committedUsage = committedUsage;
        this.graduationForYears = graduationForYears;
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

    public String getCommittedUsage() {
        return committedUsage;
    }

    public String getLocalSSDAmount() {
        return localSSDAmount;
    }

    public void setLocalSSDAmount(String localSSDAmount) {
        this.localSSDAmount = localSSDAmount;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    public String getGraduationForYears() {
        return graduationForYears;
    }

    public void setGraduationForYears(String graduationForYears) {
        this.graduationForYears = graduationForYears;
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
                ", localSSDAmount='" + localSSDAmount + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                ", graduationForYears='" + graduationForYears + '\'' +
                ", totalEstimated='" + totalEstimated + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VariableNumberOfInstance)) return false;
        VariableNumberOfInstance that = (VariableNumberOfInstance) o;
        return Objects.equals(numberOfInstance, that.numberOfInstance) && Objects.equals(operatingSystemXPath, that.operatingSystemXPath) && Objects.equals(localSSDAmount, that.localSSDAmount) && Objects.equals(committedUsage, that.committedUsage) && Objects.equals(graduationForYears, that.graduationForYears) && Objects.equals(totalEstimated, that.totalEstimated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstance, operatingSystemXPath, localSSDAmount, committedUsage, graduationForYears, totalEstimated);
    }
}
