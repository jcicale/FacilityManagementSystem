package com.tsolomonphillips;

import java.util.List;

/**
 * Created by Tyree on 2/18/2017.
 */
public interface IMaintenance
{
    List<MaintenanceRequest> listMaintRequests();
    List<MaintenanceRequest> listMaintenance();

    MaintenanceOrder createMaintenanceOrder(MaintenanceRequest request);
    void scheduleMaintenance(MaintenanceOrder order);
    void doMaintenance(MaintenanceRequest request);

    double calcMaintCostForFacility();
    double calcProblemRateForFacility();
    void listFacilityProblems();
    double calcDownTimeForFacility();

    MaintenanceLog getLog();
    Schedule getSchedule();

}
