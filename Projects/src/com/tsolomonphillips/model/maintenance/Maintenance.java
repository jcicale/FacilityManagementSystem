package com.tsolomonphillips.model.maintenance;

import com.tsolomonphillips.model.facility.IFacility;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Maintenance implements IMaintenance
{
    private Schedule schedule;
    private MaintenanceLog log;

    private IFacility facility;

    private List<ProblemType> facilityProblems;

//    public Maintenance(IFacility facility)
//    {
//        this.facility = facility;
//        this.log = new MaintenanceLog();
//        this.schedule = new Schedule();
//    }

    public Maintenance() {

    }

    @Override
    public List<IMaintenanceRequest> listMaintRequests()
    {
        return this.log.getPendingMaintenance();
    }

    @Override
    public List<IMaintenanceRequest> listMaintenance()
    {
        return this.log.getCompletedMaintenance();
    }

    //don't think we'll need this anymore
//    @Override
//    public MaintenanceOrder createMaintenanceOrder(MaintenanceRequest request)
//    {
//        return new MaintenanceOrder(request);
//    }

    @Override
    public void scheduleMaintenance(IMaintenanceOrder order, Date date) {
        schedule.getMaintenanceOrders().add(order);
        Date scheduledDate = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(scheduledDate);
        calendar.add(Calendar.DATE, 2);
        scheduledDate = calendar.getTime();
        schedule.getScheduledDates().add(scheduledDate);
        schedule.getMap().put(order, scheduledDate);
    }

    @Override
    public void doMaintenance(IMaintenanceRequest request) {
        request.setIsCompleted(true);
        for (IMaintenanceRequest maintenanceRequest : log.getPendingMaintenance()) {
            if (maintenanceRequest.getIdNumber().equalsIgnoreCase(request.getIdNumber())) {
                log.getPendingMaintenance().remove(maintenanceRequest);
                break;
            }
        }
        log.getCompletedMaintenance().add(request);
    }

    @Override
    public double calcMaintCostForFacility(MaintenanceOrder order) {
        return order.calculateMaintenanceCost();
    }

    @Override
    public int calcProblemRateForFacility() {
        return log.getCompletedMaintenance().size();
    }

    @Override
    public List<ProblemType> listFacilityProblems() {
        List<ProblemType> problemList = facilityProblems;
        for (IMaintenanceRequest request : log.getCompletedMaintenance())
        {
            problemList.add(request.getProblemType());
        }
        for (IMaintenanceRequest request : log.getPendingMaintenance())
        {
            problemList.add(request.getProblemType());
        }
        return problemList;
    }

    @Override
    public int calcDownTimeForFacility()
    {
        int downtime = 0;
        for (IMaintenanceOrder order : schedule.getMaintenanceOrders())
        {
            downtime += order.calculateDowntime();
        }
        return downtime;
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

    @Override
    public void setLog(MaintenanceLog log) {
        this.log = log;
    }

    @Override
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public List<ProblemType> getFacilityProblems() {
        return facilityProblems;
    }

    @Override
    public void setFacilityProblems(List<ProblemType> facilityProblems) {
        this.facilityProblems = facilityProblems;
    }

    @Override
    public IFacility getFacility() {
        return facility;
    }

    @Override
    public void setFacility(IFacility facility) {
        this.facility = facility;
    }
}
