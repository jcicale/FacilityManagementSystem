package com.tsolomonphillips;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class MaintenanceRequest
{
    private String problemType;
    private String dateCreated;
    private boolean isCompleted;
    private String idNumber;

    public MaintenanceRequest(String problemType, String dateCreated, String idNumber)
    {
        this.problemType = problemType;
        this.dateCreated = dateCreated;
        this.isCompleted = false;
        this.idNumber = idNumber;
    }

    public String getProblemType() {
        return problemType;
    }

    public String getDateRequested() {
        return dateCreated;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public void setDateRequested(String dateRequested) {
        this.dateCreated = dateRequested;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

}
