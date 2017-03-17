package com.tsolomonphillips.model.maintenance;

import com.tsolomonphillips.model.facility.IFacility;

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

    double calcMaintCostForFacility(MaintenanceOrder order);
    int calcProblemRateForFacility();
    List<ProblemType> listFacilityProblems();
    int calcDownTimeForFacility();

    MaintenanceLog getLog();
    Schedule getSchedule();

    //////////////
    IFacility getIFacility();

}
