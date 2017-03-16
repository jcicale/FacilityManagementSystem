package com.tsolomonphillips;

import java.util.Date;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class MaintenanceOrder implements IMaintenanceOrder
{
    private Date dateSubmitted;
    private double maintenanceCost;
    private int downTime;
    private MaintenanceRequest maintenanceRequest;


   /* public MaintenanceOrder(MaintenanceRequest maintenanceRequest)
    {
        this.maintenanceRequest = maintenanceRequest;
        this.dateSubmitted = maintenanceRequest.getDateRequested();
        this.maintenanceCost = getMaintenanceCost();
    }*/

    public MaintenanceOrder()
    {

    }

    public Date getDateSubmitted()
    {
        return dateSubmitted;
    }

    public MaintenanceRequest getMaintenanceRequest()
    {
        return maintenanceRequest;
    }

    public void setDateSubmitted(Date dateSubmitted)
    {
        this.dateSubmitted = dateSubmitted;
    }

    public void setMaintenanceCost(double maintenanceCost)
    {
        this.maintenanceCost = maintenanceCost;
    }

    public void setDownTime(int downTime)
    {
        this.downTime = downTime;
    }

    public void setMaintenanceRequest(MaintenanceRequest maintenanceRequest)
    {
        this.maintenanceRequest = maintenanceRequest;
    }

    @Override
    public double getMaintenanceCost()
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
    public int getDowntime()
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
