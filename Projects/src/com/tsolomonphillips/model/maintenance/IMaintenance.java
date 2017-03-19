package com.tsolomonphillips.model.maintenance;

import com.tsolomonphillips.model.facility.IFacility;

import java.util.Date;
import java.util.List;

/**
 * Created by Tyree on 2/18/2017.
 */
public interface IMaintenance
{
    List<IMaintenanceRequest> listMaintRequests();
    List<IMaintenanceRequest> listMaintenance();

//    MaintenanceOrder createMaintenanceOrder(MaintenanceRequest request);
    void scheduleMaintenance(IMaintenanceOrder order, Date date);
    void doMaintenance(IMaintenanceRequest request);

    double calcMaintCostForFacility(MaintenanceOrder order);
    int calcProblemRateForFacility();
    List<ProblemType> listFacilityProblems();
    int calcDownTimeForFacility();

    MaintenanceLog getLog();
    Schedule getSchedule();
    List<ProblemType> getFacilityProblems();
    void setLog(MaintenanceLog log);
    void setSchedule(Schedule schedule);
    void setFacilityProblems(List<ProblemType> facilityProblems);

    //////////////
    IFacility getIFacility();

}
