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
    Detail getFacilityInformation(); //need to decide about a detail class - would make this return easier
    int requestAvailableCapacity();
    void vacateFacility();
    boolean isInUseDuringInterval();
    void assignFacilityToUse(Tenant tenant);
    List<Inspection> listInspections();
    double listActualUsage();
    double calcUsageRate();
    String listFacilityProblems();
    List<Log> logList();
    List<MaintenanceOrder> maintenanceOrders();
}
