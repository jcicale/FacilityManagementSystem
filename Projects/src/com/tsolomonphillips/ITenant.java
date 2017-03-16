package com.tsolomonphillips;

/**
 * Created by Tyree on 3/6/2017.
 */
public interface ITenant
{
    public String getName();
    IFacility getTenantFacility();
    void setName(String name);
    void setTenantFacility(IFacility facility);
    void removeTenantFromFacility();
    MaintenanceRequest makeFacilityMaintenanceRequest(ProblemType problemType);

}
