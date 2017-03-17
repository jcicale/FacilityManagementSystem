package com.tsolomonphillips.model.facility;

/**
 * Created by juliacicale1 on 2/17/17.
 */
public interface IFacilityDetail {
    double getRate();
    int getCapacity();
    String getName();
    FacilityType getFacilityType();
    void setName(String name);
}

