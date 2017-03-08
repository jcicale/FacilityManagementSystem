package com.tsolomonphillips;

import java.util.Date;

/**
 * Created by Tyree on 3/6/2017.
 */
public interface IMaintenanceOrder
{
    double getMaintenanceCost();
    int getDowntime();
    Date getDateSubmitted();
    MaintenanceRequest getMaintenanceRequest();
    void setDateSubmitted(Date dateSubmitted);
    void setMaintenanceCost(double maintenanceCost);
    void setDownTime(int downTime);
    void setMaintenanceRequest(MaintenanceRequest maintenanceRequest);


}
