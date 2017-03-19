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
    List<ITenant> listActualUsage(); //listActualUsage method, used to be called getTenants

    void setFacilityTenants(List<ITenant> facilityTenants);
    List<ITenant> getFacilityTenants();

    void setAllTenants(List<ITenant> allTenants);
    List<ITenant> getAllTenants();

    void setAdministrator(IAdministrator administrator);
    IAdministrator getAdministrator();

    void setMaintenance(IMaintenance maintenance);
    IMaintenance getMaintenance();


    ///double check this stuff later

    void setBaseRate(double baseRate);
    double getRate();

    void setBaseCapacity(int baseCapacity);
    int getCapacity();


    void setName(String name);
    String getName();

    void setFacilityType(FacilityType type);
    FacilityType getFacilityType();

}
