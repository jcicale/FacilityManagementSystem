package com.tsolomonphillips;

import java.util.List;

/**
 * Created by juliacicale1 on 2/18/17.
 */
public interface IAdministrator {
    List<IInspection> listInspections();
    void performInspection();

    float getOccupiedPercentage(); //calcUsageRate method
    int getAvailableCapacity();
    int getNumberOfTenants(); //actualUsageRate method

}
