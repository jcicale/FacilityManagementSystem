package com.tsolomonphillips.model.maintenance;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Tyree on 2/18/2017.
 */
public class MaintenanceLog implements IMaintenanceLog
{
    private List<IMaintenanceRequest> pendingMaintenance;
    private List<IMaintenanceRequest> completedMaintenance;

//    public MaintenanceLog()
//    {
//        pendingMaintenance = new ArrayList<>();
//        completedMaintenance = new ArrayList<>();
//    }


    public MaintenanceLog()
    {

    }

    public void setPendingMaintenance(List<IMaintenanceRequest> pendingMaintenance)
    {
        this.pendingMaintenance = pendingMaintenance;
    }

    public void setCompletedMaintenance(List<IMaintenanceRequest> completedMaintenance)
    {
        this.completedMaintenance = completedMaintenance;
    }

    @Override
    public List<IMaintenanceRequest> getPendingMaintenance()
    {
        return pendingMaintenance;
    }

   @Override
    public List<IMaintenanceRequest> getCompletedMaintenance()
    {
        return completedMaintenance;
    }

    @Override
    public void addToPendingMaintenance(IMaintenanceRequest request)
    {
        pendingMaintenance.add(request);
    }
}
