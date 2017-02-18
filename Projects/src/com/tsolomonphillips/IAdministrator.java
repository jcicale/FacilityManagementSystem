package com.tsolomonphillips;

import java.util.List;

/**
 * Created by juliacicale1 on 2/18/17.
 */
public interface IAdministrator {
    List<Inspection> listInspections();
    String listFacilityProblems();
    float getOccupiedPercentage(); //calcUsageRate method
    int getAvailableCapacity();
    int getNumberOfTenants(); //actualUsageRate method
}
