package com.tsolomonphillips.model.maintenance;

import com.tsolomonphillips.model.facility.IFacility;

import java.util.Date;

/**
 * Created by Tyree on 3/6/2017.
 */
public interface IMaintenanceRequest
{
    ProblemType getProblemType();
    Date getDateRequested();
    String getIdNumber();
    boolean getIsCompleted();
    IFacility getFacility();

    void setProblemType(ProblemType problemType);
    void setDateCreated(Date dateCreated);
    void setIdNumber(String idNumber);
    void setFacility(IFacility facility);
    void setIsCompleted(boolean completed);
}
