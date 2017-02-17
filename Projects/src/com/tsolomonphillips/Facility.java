package com.tsolomonphillips;


import sun.rmi.runtime.Log;

import javax.xml.soap.Detail;
import java.util.List;

public interface Facility
{
    Administrator administrator = new Administrator();
    Maintenance maintenance = new Maintenance();
    Log listMaintenance();
    List<MaintenanceRequest> listMaintRequests();
    List<Facility> listFacilities();
    Detail getFacilityInformation();
    int requestAvailableCapacity();
    void vacateFacility();
    boolean isInUseDuringInternval();
    void assignFacilityToUse();
    List<Inspection> listInspections();
    double listActualUsage();
    double calcUsageRate();
    String listFacilityProblems();
    List<Log> logList();
    List<MaintenanceOrder> maintenanceOrders();
}
