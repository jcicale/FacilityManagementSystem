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

    public String getIdNumber() {
        return idNumber;
    }


    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


}
