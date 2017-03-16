package com.tsolomonphillips;

import java.util.List;

/**
 * Created by Tyree on 2/18/2017.
 */
public class MaintenanceLog implements IMaintenanceLog
{
    private List<MaintenanceRequest> pendingMaintenance;
    private List<MaintenanceRequest> completedMaintenance;

  /*  public MaintenanceLog()
    {
        pendingMaintenance = new ArrayList<>();
        completedMaintenance = new ArrayList<>();
    }*/


    public MaintenanceLog()
    {

    }

    public void setPendingMaintenance(List<MaintenanceRequest> pendingMaintenance)
    {
        this.pendingMaintenance = pendingMaintenance;
    }

    public void setCompletedMaintenance(List<MaintenanceRequest> completedMaintenance)
    {
        this.completedMaintenance = completedMaintenance;
    }

    @Override
    public List<MaintenanceRequest> getPendingMaintenance()
    {
        return pendingMaintenance;
    }

   @Override
    public List<MaintenanceRequest> getCompletedMaintenance()
    {
        return completedMaintenance;
    }

    @Override
    public void addToPendingMaintenance(MaintenanceRequest request)
    {
        pendingMaintenance.add(request);
    }
}
