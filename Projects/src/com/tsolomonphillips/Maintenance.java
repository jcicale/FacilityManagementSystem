package com.tsolomonphillips;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Maintenance implements IMaintenance
{
    private Schedule schedule;
    private MaintenanceLog log;

    private IFacility facility;

    private List<MaintenanceRequest> maintenanceRequestList;
    private List<MaintenanceOrder> maintenanceOrderList;

    public Maintenance(IFacility facility)
    {
        this.facility = facility;
        this.log = new MaintenanceLog();
        this.schedule = new Schedule();
        this. maintenanceRequestList = new ArrayList<>();
        this.maintenanceOrderList = new ArrayList<>();
    }


    @Override
    public List<MaintenanceRequest> listMaintRequests() {
        return this.log.getPendingMaintenance();
    }

    @Override
    public List<MaintenanceRequest> listMaintenance() {
        return this.log.getCompletedMaintenance();
    }

    @Override
    public MaintenanceOrder createMaintenanceOrder(MaintenanceRequest request) {
        return new MaintenanceOrder(request);
    }

    @Override
    public void scheduleMaintenance(MaintenanceOrder order) {

    }

    @Override
    public void doMaintenance(MaintenanceRequest request) {

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
        return this.log;
    }

    @Override
    public Schedule getSchedule()
    {
        return this.schedule;
    }


}
