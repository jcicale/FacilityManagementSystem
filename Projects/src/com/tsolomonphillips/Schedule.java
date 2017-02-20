package com.tsolomonphillips;

import java.util.*;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class Schedule
{
    private List<MaintenanceOrder> maintenanceOrders;
    private List<Date> scheduledDates;
    private Map<MaintenanceOrder, Date> map;

    public Schedule() {
        maintenanceOrders = new ArrayList<>();
        scheduledDates = new ArrayList<>();
        map = new HashMap<>();
    }

    public List<MaintenanceOrder> getMaintenanceOrders() {
        return maintenanceOrders;
    }

    public List<Date> getScheduledDates() {
        return scheduledDates;
    }

    public Map<MaintenanceOrder, Date> getMap() {
        return map;
    }

}
