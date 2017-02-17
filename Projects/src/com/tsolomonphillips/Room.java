package com.tsolomonphillips;


import sun.rmi.runtime.Log;

import javax.xml.soap.Detail;
import java.util.List;

public class Room implements Facility
{
    private String roomNumber;
    private int capacity;
    private double monthlyPrice;


    @Override
    public Log listMaintenance()
    {
        return null;
    }

    @Override
    public List<MaintenanceRequest> listMaintRequests()
    {
        return null;
    }

    @Override
    public List<Facility> listFacilities()
    {
        return null;
    }

    @Override
    public Detail getFacilityInformation()
    {
        return null;
    }

    @Override
    public int requestAvailableCapacity()
    {
        return 0;
    }

    @Override
    public void vacateFacility()
    {

    }

    @Override
    public boolean isInUseDuringInternval()
    {
        return false;
    }

    @Override
    public void assignFacilityToUse()
    {

    }

    @Override
    public List<Inspection> listInspections()
    {
        return null;
    }

    @Override
    public double listActualUsage()
    {
        return 0;
    }

    @Override
    public double calcUsageRate()
    {
        return 0;
    }

    @Override
    public String listFacilityProblems()
    {
        return null;
    }

    @Override
    public List<Log> logList()
    {
        return null;
    }

    @Override
    public List<MaintenanceOrder> maintenanceOrders()
    {
        return null;
    }
}
