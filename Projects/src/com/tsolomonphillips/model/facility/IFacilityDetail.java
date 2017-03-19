package com.tsolomonphillips.model.facility;

/**
 * Created by juliacicale1 on 2/17/17.
 */
public interface IFacilityDetail {
    void setBaseRate(double baseRate);
    double getRate();

    void setBaseCapacity(int baseCapacity);
    int getCapacity();


    void setName(String name);
    String getName();

    void setFacilityType(FacilityType type);
    FacilityType getFacilityType();
}

