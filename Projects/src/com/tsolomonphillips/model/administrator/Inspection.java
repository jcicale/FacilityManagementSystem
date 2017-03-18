package com.tsolomonphillips.model.administrator;

import com.tsolomonphillips.model.facility.IFacility;

import java.util.Date;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class Inspection implements IInspection {
    private String idNumber;
    private Date date;
    private IFacility facility;

    public Inspection(String idNumber, Date date, IFacility facility)
    {
        this.idNumber = idNumber;
        this.date = date;
        this. facility = facility;
    }

    public Inspection() {

    }

    @Override
    public String getID() {
        return idNumber;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public IFacility getFacility() {
        return facility;
    }

    @Override
    public void setID(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public void setFacility(IFacility facility) {
        this.facility = facility;
    }
}
