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
        return Faciliy;
    }

    public double calcDownTimeForFacility()
    {
        return 0.0;
    }

    public Log getLog()
    {
        return Log;
    }

    public Schedule getSchedule()
    {
        return Schedule;
    }

    public MaintenanceRequest getMaintenanceRequest()
    {
        return MaintenanceRequest;
    }

    public MaintenanceOrder getMaintenanceOrder()
    {
        return MaintenanceOrder;
    }

    public Inspection getInspection()
    {
        return Inspection;
    }

}
