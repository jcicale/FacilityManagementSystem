package com.tsolomonphillips;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Maintenance implements IMaintenance
{
    private Schedule schedule;
    private MaintenanceLog log;

    private IFacility facility;

  /*  public Maintenance(IFacility facility)
    {
        this.facility = facility;
        this.log = new MaintenanceLog();
        this.schedule = new Schedule();
    }*/

    public Maintenance()
    {

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
    public MaintenanceOrder createMaintenanceOrder(MaintenanceRequest request)
    {
        return new MaintenanceOrder(request);
    }

    @Override
    public void scheduleMaintenance(MaintenanceOrder order) {
        schedule.getMaintenanceOrders().add(order);
        Date scheduledDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(scheduledDate);
        calendar.add(Calendar.DATE, 2);
        scheduledDate = calendar.getTime();
        schedule.getScheduledDates().add(scheduledDate);
        schedule.getMap().put(order, scheduledDate);
    }

    @Override
    public void doMaintenance(MaintenanceRequest request) {
        request.setCompleted(true);
        for (MaintenanceRequest maintenanceRequest : log.getPendingMaintenance()) {
            if (maintenanceRequest.getIdNumber().equalsIgnoreCase(request.getIdNumber())) {
                log.getPendingMaintenance().remove(maintenanceRequest);
                break;
            }
        }
        log.getCompletedMaintenance().add(request);
    }

    @Override
    public double calcMaintCostForFacility(MaintenanceOrder order) {
        return order.getMaintenanceCost();
    }

    @Override
    public int calcProblemRateForFacility() {
        return log.getCompletedMaintenance().size();
    }

    @Override
    public List<ProblemType> listFacilityProblems() {
        List<ProblemType> problemList = new ArrayList<>();
        for (MaintenanceRequest request : log.getCompletedMaintenance()) {
            problemList.add(request.getProblemType());
        }
        for (MaintenanceRequest request : log.getPendingMaintenance()) {
            problemList.add(request.getProblemType());
        }
        return problemList;
    }

    @Override
    public int calcDownTimeForFacility()
    {
        int downtime = 0;
        for (MaintenanceOrder order : schedule.getMaintenanceOrders()) {
            downtime += order.getDowntime();
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


}
