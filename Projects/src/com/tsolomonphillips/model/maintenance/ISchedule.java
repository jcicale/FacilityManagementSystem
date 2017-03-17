package com.tsolomonphillips.model.maintenance;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Tyree on 3/6/2017.
 */
public interface ISchedule
{
    List<MaintenanceOrder> getMaintenanceOrders();
    List<Date> getScheduledDates();
    Map<MaintenanceOrder, Date> getMap();
    void setMaintenanceOrders(List<MaintenanceOrder> maintenanceOrders);
    void setScheduledDates(List<Date> scheduledDates);
    void setMap(Map<MaintenanceOrder, Date> map);
}
