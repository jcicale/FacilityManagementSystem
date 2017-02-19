package com.tsolomonphillips;


import java.util.ArrayList;
import java.util.List;

public class Maintenance implements IMaintenance
{
    private String dateRequested;
    private Schedule schedule;
    private MaintenanceOrder maintenanceOrder;
    private MaintenanceRequest maintenanceRequest;
    private Inspection inspection;
    private MaintenanceLog log;

    private IFacility facility;
    private List<MaintenanceRequest> maintenanceRequestList = new ArrayList<>();

    public Maintenance(IFacility facility)
    {
        this.facility = facility;
    }


    @Override
    public void makeFacilityMaintRequest(String problemType, String dateCreated, String idNumber)
    {
        MaintenanceRequest maintenanceRequest = new MaintenanceRequest(problemType, dateCreated, idNumber);
        maintenanceRequestList.add(maintenanceRequest);
    }

    @Override
    public List<MaintenanceRequest> maintenanceRequests(IFacility facility)
    {
        if(maintenanceRequest.isCompleted() == false)
        {
            return maintenanceRequestList;
        }

        return null;
    }

    @Override
    public Schedule scheduleMaintenance(String dateScheduled)
    {

        return new Schedule(dateScheduled);
    }

    @Override
    public double calcMaintCostForFacility()
    {
        return 0;
    }

    @Override
    public double calcProblemRateForFacility()
    {
        return 0;
    }

    @Override
    public void listFacilityProblems()
    {

    }

    @Override
    public double calcDownTimeForFacility()
    {
        return 0;
    }

    @Override
    public MaintenanceLog getLog()
    {
        return null;
    }

    @Override
    public Schedule getSchedule()
    {
        return null;
    }

    @Override
    public MaintenanceRequest getMaintenanceRequest()
    {
        return null;
    }

    @Override
    public MaintenanceOrder getMaintenaceOrder()
    {
        return null;
    }

    @Override
    public Inspection getInspection()
    {
        return null;
    }
}
