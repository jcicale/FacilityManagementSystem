package com.tsolomonphillips.model.facility;

import com.tsolomonphillips.model.administrator.Administrator;
import com.tsolomonphillips.model.administrator.IAdministrator;
import com.tsolomonphillips.model.maintenance.IMaintenance;

import java.util.List;

/**
 * Created by juliacicale1 on 2/18/17.
 */
public interface IFacility {
    IFacilityDetail getFacilityInformation();

    void addFacility(IFacility facility);
    void removeFacility(IFacility facility);

    void setSubFacilities(List<IFacility> subFacilities);
    List<IFacility> getSubFacilities();

    void vacateFacility();
    boolean addTenant(ITenant tenant);
    void removeTenant(ITenant tenant);
    List<ITenant> getTenants(); //listActualUsage method

    void setFacilityTenants(List<ITenant> facilityTenants);
    List<ITenant> getFacilityTenants();

    void setAdministrator(IAdministrator administrator);
    IAdministrator getAdministrator();

    void setMaintenance(IMaintenance maintenance);
    IMaintenance getMaintenance();

}
