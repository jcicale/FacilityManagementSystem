package com.tsolomonphillips.model.maintenance;

import java.util.*;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class Schedule implements ISchedule
{
    private List<MaintenanceOrder> maintenanceOrders;
    private List<Date> scheduledDates;
    private Map<MaintenanceOrder, Date> map;

    public Schedule()
     {
        maintenanceOrders = new ArrayList<>();
        scheduledDates = new ArrayList<>();
        map = new HashMap<>();
    }

//    public Schedule()
//    {
//
//    }


    public List<MaintenanceOrder> getMaintenanceOrders()
    {
        return maintenanceOrders;
    }

    public List<Date> getScheduledDates()
    {
        return scheduledDates;
    }

    public Map<MaintenanceOrder, Date> getMap()
    {
        return map;
    }

    public void setMaintenanceOrders(List<MaintenanceOrder> maintenanceOrders)
    {
        this.maintenanceOrders = maintenanceOrders;
    }

    public void setScheduledDates(List<Date> scheduledDates)
    {
        this.scheduledDates = scheduledDates;
    }

    public void setMap(Map<MaintenanceOrder, Date> map)
    {
        this.map = map;
    }
}
