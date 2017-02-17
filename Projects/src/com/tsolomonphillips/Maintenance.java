package com.tsolomonphillips;


import sun.rmi.runtime.Log;

public class Maintenance
{
    private String dateRequested;
    private String name; //not sure if we need a name here
    private Schedule schedule;
    private MaintenanceOrder maintenanceOrder;
    private MaintenanceRequest maintenanceRequest;
    private Inspection inspection;
    private Log log;

    public void scheduleMaintenance()
    {

    }

    public double calcMaintenanceCostForFacility()
    {
        return 0.0;
    }

    public double calcProblemRateForFacility()
    {
        return 0.0;
    }

    public Facility listFacilityProblemes() // not sure about this method
    {
        return null;
    }

    public double calcDownTimeForFacility()
    {
        return 0.0;
    }

    public Log getLog()
    {
        return null;
    }

    public Schedule getSchedule()
    {
        return null;
    }

    public MaintenanceRequest getMaintenanceRequest()
    {
        return null;
    }

    public MaintenanceOrder getMaintenanceOrder()
    {
        return null;
    }

    public Inspection getInspection()
    {
        return null;
    }

}
