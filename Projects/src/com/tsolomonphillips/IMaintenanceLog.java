package com.tsolomonphillips;

import java.util.List;

/**
 * Created by Tyree on 3/6/2017.
 */
public interface IMaintenanceLog
{
    List<MaintenanceRequest> getPendingMaintenance();
    List<MaintenanceRequest> getCompletedMaintenance();
    void addToPendingMaintenance(MaintenanceRequest request);
    void setPendingMaintenance(List<MaintenanceRequest> pendingMaintenance);
    void setCompletedMaintenance(List<MaintenanceRequest> completedMaintenance);

}
