package com.tsolomonphillips.model.maintenance;

import java.util.List;

/**
 * Created by Tyree on 3/6/2017.
 */
public interface IMaintenanceLog
{
    List<IMaintenanceRequest> getPendingMaintenance();
    List<IMaintenanceRequest> getCompletedMaintenance();
    void addToPendingMaintenance(IMaintenanceRequest request);
    void setPendingMaintenance(List<IMaintenanceRequest> pendingMaintenance);
    void setCompletedMaintenance(List<IMaintenanceRequest> completedMaintenance);

}
