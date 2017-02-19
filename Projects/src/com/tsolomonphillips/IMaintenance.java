package com.tsolomonphillips;

import java.util.List;

/**
 * Created by Tyree on 2/18/2017.
 */
public interface IMaintenance
{
    List<MaintenanceRequest> maintenanceRequests(IFacility facility);

    void makeFacilityMaintRequest(String problemType, String dateCreated, String idNumber);
    Schedule scheduleMaintenance(String dateScheduled);
    double calcMaintCostForFacility();
    double calcProblemRateForFacility();
    void listFacilityProblems();
    double calcDownTimeForFacility();

    MaintenanceLog getLog();
    Schedule getSchedule();
    MaintenanceRequest getMaintenanceRequest();
    MaintenanceOrder getMaintenaceOrder();
    Inspection getInspection();
}
