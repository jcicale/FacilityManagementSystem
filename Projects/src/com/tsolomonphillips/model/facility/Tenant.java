package com.tsolomonphillips.model.facility;

import com.tsolomonphillips.model.maintenance.IMaintenanceRequest;
import com.tsolomonphillips.model.maintenance.Maintenance;
import com.tsolomonphillips.model.maintenance.MaintenanceRequest;
import com.tsolomonphillips.model.maintenance.ProblemType;

import java.util.Date;

/**
 * Created by juliacicale1 on 2/17/17.
 */
public class Tenant implements ITenant {
    private String name;
    private IFacility facility;

//    public Tenant(String name) {
//        this.name = name;
//        facility = null;
//    }

    public Tenant() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setTenantFacility(IFacility facility) {
        this.facility = facility;
    }

    @Override
    public IFacility getTenantFacility() {
        return this.facility;
    }

    @Override
    public void removeTenantFromFacility() {
        this.facility = null;
    }

    @Override
    public void makeFacilityMaintenanceRequest(IMaintenanceRequest maintenanceRequest) {
        //when a tenant makes a maintenance request, it will be set for his/her facility, rather than doing this in client
        maintenanceRequest.setFacility(this.facility);
        facility.getMaintenance().getLog().addToPendingMaintenance(maintenanceRequest);
    }

}