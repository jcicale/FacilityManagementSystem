package com.tsolomonphillips.model.facility;

import com.tsolomonphillips.model.maintenance.MaintenanceRequest;
import com.tsolomonphillips.model.maintenance.ProblemType;

import java.util.Date;

/**
 * Created by juliacicale1 on 2/17/17.
 */
public class Tenant implements ITenant
{
    private String name;
    private IFacility facility;

public Tenant(String name)
    {
        this.name = name;
        facility = null;
    }

    public Tenant ()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setTenantFacility(IFacility facility)
    {
        this.facility = facility;
    }

    public IFacility getTenantFacility()
    {
        return this.facility;
    }

    public void removeTenantFromFacility()
    {
        this.facility = null;
    }

    public MaintenanceRequest makeFacilityMaintenanceRequest(ProblemType problemType)
    {
        Date date = new Date();
        MaintenanceRequest newRequest = new MaintenanceRequest(problemType, date, this.facility);
        facility.getMaintenance().getLog().addToPendingMaintenance(newRequest);
        return newRequest;
    }

    /*
        The method below is just a test method and can be deleted at any time.
        I was testing out how we would get rid of the "new" declaration for a date object
        and a MaintenanceRequest object that the above code has in it. I have not finished,
        but feel free to tinker with this some more. I was trying to figure out a way to get
        this done without changing too much code in other places.
     */


//
//    public MaintenanceRequest makeFacilityMaintenceRequest(ProblemType problemType)
//    {
//        MaintenanceRequest maintenanceRequest;
//        maintenanceRequest.setProblemType(problemType);
//        Date date;
//
//        this.facility.getMaintenance().getLog().addToPendingMaintenance(maintenanceRequest);
//        return maintenanceRequest;
//    }
}
