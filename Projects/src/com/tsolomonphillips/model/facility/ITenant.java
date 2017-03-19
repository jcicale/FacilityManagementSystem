package com.tsolomonphillips.model.facility;

import com.tsolomonphillips.model.maintenance.IMaintenanceRequest;
import com.tsolomonphillips.model.maintenance.MaintenanceRequest;
import com.tsolomonphillips.model.maintenance.ProblemType;

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
    void makeFacilityMaintenanceRequest(IMaintenanceRequest maintenanceRequest);

}
