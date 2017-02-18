package com.tsolomonphillips;
import java.util.List;
/**
 * Created by juliacicale1 on 2/16/17.
 */
public interface Administrator {
    List<Inspection> listInspections();
    String listFacilityProblems();
    float getOccupiedPercentage(); //calcUsageRate method
    int getAvailableCapacity();

}