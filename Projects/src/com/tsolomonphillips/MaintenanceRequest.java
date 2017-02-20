package com.tsolomonphillips;

import java.util.Date;
import java.util.UUID;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class MaintenanceRequest
{
    private ProblemType problemType;
    private Date dateCreated;
    private boolean isCompleted;
    private String idNumber;
    private IFacility facility;

    public MaintenanceRequest(ProblemType problemType, Date dateCreated, IFacility facility)
    {
        this.problemType = problemType;
        this.dateCreated = dateCreated;
        this.isCompleted = false;
        this.idNumber = UUID.randomUUID().toString();
        this.facility = facility;
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public Date getDateRequested() {
        return dateCreated;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setProblemType(ProblemType problemType) {
        this.problemType = problemType;
    }


    public void setDateRequested(Date dateRequested) {
        this.dateCreated = dateRequested;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

}
