package com.tsolomonphillips;

import java.util.List;

/**
 * Created by juliacicale1 on 2/18/17.
 */
public interface IFacility {
    IFacilityDetail getFacilityInformation();

    void addFacility(IFacility facility);
    void removeFacility(IFacility facility);
    List<IFacility> getFacilityList();

    void vacateFacility();
    boolean addTenant(Tenant tenant);
    void removeTenant(Tenant tenant);
    List<Tenant> getTenants(); //listActualUsage method
}
