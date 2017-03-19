package com.tsolomonphillips.model.administrator;

import com.tsolomonphillips.model.facility.IFacility;

import java.util.Date;

/**
 * Created by juliacicale1 on 2/18/17.
 */
public interface IInspection {
    String getID();
    Date getDate();
    IFacility getFacility();

    void setID(String idNumber);
    void setDate(Date date);
    void setFacility(IFacility facility);
}
