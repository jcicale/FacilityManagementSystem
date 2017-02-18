package com.tsolomonphillips;

import java.util.Date;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class Inspection implements IInspection {
    private String idNumber;
    private Date date;
    private IFacility facility;

    public Inspection(String idNumber, Date date, IFacility facility) {
        this.idNumber = idNumber;
        this.date = date;
        this. facility = facility;
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

}
