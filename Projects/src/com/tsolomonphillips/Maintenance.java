package com.tsolomonphillips;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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
        schedule.getMaintenanceOrders().add(order);
        Date todayDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todayDate);
        calendar.add(Calendar.DATE, 2);
        todayDate = calendar.getTime();
        System.out.println(todayDate);
        System.out.println("Hi");
        schedule.getScheduledDates().add(todayDate);
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
//        int downtime = 0;
//        for (MaintenanceRequest request : schedule.) {
//            request.get
//        }
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
