package com.tsolomonphillips.model.maintenance;

import java.util.Date;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class MaintenanceOrder implements IMaintenanceOrder
{
    private Date dateSubmitted;
    private double maintenanceCost;
    private int downTime;
    private IMaintenanceRequest maintenanceRequest;


//    public MaintenanceOrder(MaintenanceRequest maintenanceRequest)
//    {
//        this.maintenanceRequest = maintenanceRequest;
//        this.dateSubmitted = maintenanceRequest.getDateRequested();
//        this.maintenanceCost = calculateMaintenanceCost();
//    }

    public MaintenanceOrder() {

    }

    @Override
    public Date getDateSubmitted()
    {
        return dateSubmitted;
    }

    @Override
    public void setDateSubmitted(Date dateSubmitted)
    {
        this.dateSubmitted = dateSubmitted;
    }

    @Override
    public IMaintenanceRequest getMaintenanceRequest()
    {
        return maintenanceRequest;
    }

    @Override
    public void setMaintenanceRequest(IMaintenanceRequest maintenanceRequest) {
        this.maintenanceRequest = maintenanceRequest;
    }

    @Override
    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    @Override
    public void setMaintenanceCost(double maintenanceCost)
    {
        this.maintenanceCost = maintenanceCost;
    }

    @Override
    public int getDowntime() {
        return downTime;
    }

    @Override
    public void setDownTime(int downTime)
    {
        this.downTime = downTime;
    }


    @Override
    public double calculateMaintenanceCost()
    {
        ProblemType type = this.maintenanceRequest.getProblemType();
        if (type == ProblemType.ELECTRICAL)
        {
            return 300;
        }
        else if (type == ProblemType.PLUMBING)
        {
            return 200;
        }
        else if (type == ProblemType.COOLING)
        {
            return 150;
        }
        else if (type == ProblemType.HEATING)
        {
            return 200;
        }
        else return 250;
    }

    @Override
    public int calculateDowntime()
    {
        ProblemType type = this.maintenanceRequest.getProblemType();
        if (type == ProblemType.ELECTRICAL)
        {
            return 2;
        }
        else if (type == ProblemType.PLUMBING)
        {
            return 1;
        }
        else if (type == ProblemType.COOLING)
        {
            return 3;
        }
        else if (type == ProblemType.HEATING)
        {
            return 2;
        }
        else return 2;
    }


}
