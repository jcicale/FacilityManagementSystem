package com.tsolomonphillips.model.facility;

import com.tsolomonphillips.model.administrator.Administrator;
import com.tsolomonphillips.model.administrator.IAdministrator;
import com.tsolomonphillips.model.maintenance.IMaintenance;
import com.tsolomonphillips.model.maintenance.Maintenance;

import java.util.ArrayList;
import java.util.List;

public class Facility implements IFacility, IFacilityDetail {
    private List<IFacility> subFacilities;
    private List<ITenant> facilityTenants;
    private List<ITenant> allTenants;
    private IAdministrator administrator;
    private IMaintenance maintenance;

    private String name;
    private FacilityType type;
    private int baseCapacity;
    private double baseRate;

//    public Facility(String name, FacilityType type, int baseCapacity, double baseRate) {
//        this.name = name;
//        this.type = type;
//        this.baseCapacity = baseCapacity;
//        this.baseRate = baseRate;
//        this.administrator = new Administrator(this);
//        this.maintenance = new Maintenance(this);
//    }

    public Facility() {

    }

    @Override
    public IFacilityDetail getFacilityInformation() {
        return this;
    }

    @Override
    public void addFacility(IFacility facility) {
        subFacilities.add(facility);
    }

    @Override
    public void removeFacility(IFacility facility) throws IllegalStateException{
        try {
            if (facility.getFacilityTenants().size() == 0) {
                subFacilities.remove(facility);
            }
            else {
                throw new IllegalStateException();
            }
        }
        catch (IllegalStateException exception) {
            System.out.println(facility.getName() + " has tenants. The facility must be vacant before it can be removed.");
        }
    }

    @Override
    public void vacateFacility() {
        for (ITenant tenant : facilityTenants) {
            tenant.removeTenantFromFacility();
        }
        facilityTenants.clear();
        for (IFacility facility : subFacilities) {
            facility.vacateFacility();
        }
    }

    @Override
    public boolean addTenant(ITenant tenant) throws IllegalStateException {
        try {
            if (facilityTenants.size() < getFacilityInformation().getCapacity()) {
                facilityTenants.add(tenant);
                tenant.setTenantFacility(this);
                return true;
            }
            else {
                throw new IllegalStateException();
            }
        }
        catch (IllegalStateException exception) {
            System.out.println(name + "'s capacity is full, cannot add  tenant.");
            return false;
        }

    }

    @Override
    public void removeTenant(ITenant tenant) {
        facilityTenants.remove(tenant);
        tenant.removeTenantFromFacility();
    }

    @Override
    public List<ITenant> listActualUsage() {
        List<ITenant> allTenantList = allTenants;
        allTenantList.addAll(facilityTenants);
        for (IFacility facility : subFacilities) {
            allTenantList.addAll(facility.listActualUsage());
        }
        return  allTenantList;
    }

    //*********************************************
    //Getters and setters, used by Spring
    @Override
    public void setSubFacilities(List<IFacility> subFacilities) {
        this.subFacilities = subFacilities;
    }

    @Override
    public List<IFacility> getSubFacilities() {
        return subFacilities;
    }


    @Override
    public void setFacilityTenants(List<ITenant> facilityTenants) {
        this.facilityTenants = facilityTenants;
    }

    @Override
    public List<ITenant> getFacilityTenants() {
        return facilityTenants;
    }

    @Override
    public void setAllTenants(List<ITenant> allTenants) {
        this.allTenants = allTenants;
    }

    @Override
    public List<ITenant> getAllTenants() {
        return allTenants;
    }

    @Override
    public void setAdministrator(IAdministrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public IAdministrator getAdministrator() {
        return administrator;
    }


    @Override
    public void setMaintenance(IMaintenance maintenance) {
        this.maintenance = maintenance;
    }

    @Override
    public IMaintenance getMaintenance() {
        return maintenance;
    }




    /**
     * IFacilityDetail
     */
    @Override
    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    @Override
    public double getRate() {
        double totalRate = baseRate;
        for (IFacility facility : subFacilities) {
            totalRate += facility.getFacilityInformation().getRate();
        }
        return totalRate;
    }

    @Override
    public void setBaseCapacity(int baseCapacity) {
        this.baseCapacity = baseCapacity;
    }

    @Override
    public int getCapacity() {
        int totalCapacity = baseCapacity;
        for (IFacility facility : subFacilities) {
            totalCapacity += facility.getFacilityInformation().getCapacity();
        }
        return totalCapacity;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setFacilityType(FacilityType type) {
        this.type = type;
    }

    @Override
    public FacilityType getFacilityType() {
        return type;
    }



}

