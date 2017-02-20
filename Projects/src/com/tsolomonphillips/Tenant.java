package com.tsolomonphillips;

import java.util.Date;

/**
 * Created by juliacicale1 on 2/17/17.
 */
public class Tenant {
    private String name;
    private IFacility facility;

    public Tenant(String name) {
        this.name = name;
        facility = null;
    }

    public void setTenantFacility(IFacility facility) {
        this.facility = facility;
    }

    public IFacility getTenantFacility() {
        return this.facility;
    }

    public void removeTenantFromFacility() {
        this.facility = null;
    }

    public MaintenanceRequest makeFacilityMaintenanceRequest(ProblemType problemType, Date dateRequested) {
        MaintenanceRequest newRequest = new MaintenanceRequest(problemType, dateRequested, this.facility);
        facility.getMaintenance().getLog().addToPendingMaintenance(newRequest);
        return newRequest;
    }
}
