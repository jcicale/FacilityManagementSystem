package com.tsolomonphillips.model.maintenance;

import com.tsolomonphillips.model.facility.IFacility;

import java.util.Date;
import java.util.UUID;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class MaintenanceRequest implements IMaintenanceRequest
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

   public MaintenanceRequest()
   {

   }


    public boolean getIsCompleted()
    {
        return isCompleted;
    }

    public IFacility getFacility()
    {
        return facility;
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


    public void setCompleted(boolean completed)
    {
        isCompleted = completed;
    }

    public void setProblemType(ProblemType problemType)
    {
        this.problemType = problemType;
    }

    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public void setFacility(IFacility facility)
    {
        this.facility = facility;
    }
}
