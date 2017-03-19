package com.tsolomonphillips.model.maintenance;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Tyree on 3/6/2017.
 */
public interface ISchedule
{
    List<IMaintenanceOrder> getMaintenanceOrders();
    List<Date> getScheduledDates();
    Map<IMaintenanceOrder, Date> getMap();
    void setMaintenanceOrders(List<IMaintenanceOrder> maintenanceOrders);
    void setScheduledDates(List<Date> scheduledDates);
    void setMap(Map<IMaintenanceOrder, Date> map);
}
