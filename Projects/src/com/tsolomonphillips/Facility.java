package com.tsolomonphillips;


import sun.rmi.runtime.Log;

import javax.xml.soap.Detail;
import java.util.ArrayList;
import java.util.List;

//public interface Facility
//{
//    Administrator administrator = new Administrator();
//    Maintenance maintenance = new Maintenance();
//    Log listMaintenance();
//    List<MaintenanceRequest> listMaintRequests();
//    boolean isInUseDuringInterval();
//    List<Log> logList();
//    List<MaintenanceOrder> maintenanceOrders();
//}

public class Facility implements IFacility, IFacilityDetail {
    private List<IFacility> subFacilities = new ArrayList<>();
    private List<Tenant> facilityTenants = new ArrayList<>();
    private String name;
    private FacilityType type;
    private int baseCapacity;
    private double baseRate;

    public Facility(String name, FacilityType type, int baseCapacity, double baseRate) {
        this.name = name;
        this.type = type;
        this.baseCapacity = baseCapacity;
        this.baseRate = baseRate;
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
    public void removeFacility(IFacility facility) {
        subFacilities.remove(facility);
    }

    @Override
    public List<IFacility> getFacilityList() {
        return subFacilities;
    }

    @Override
    public void vacateFacility() {
        for (IFacility facility : subFacilities) {
            facility.vacateFacility();
        }
    }

    @Override
    public boolean addTenant(Tenant tenant) {
        if (facilityTenants.size() < getFacilityInformation().getCapacity()) {
            facilityTenants.add(tenant);
            return true;
        }
        return false;
    }

    @Override
    public void removeTenant(Tenant tenant) {
        facilityTenants.remove(tenant);
    }

    @Override
    public List<Tenant> getTenants() {
        List<Tenant> allTenants = new ArrayList<>();
        allTenants.addAll(facilityTenants);
        for (IFacility facility : subFacilities) {
            allTenants.addAll(facility.getTenants());
        }
        return  allTenants;
    }

    /**
     * IFacilityDetail
     */
    @Override
    public double getRate() {
        double totalRate = baseRate;
        for (IFacility facility : subFacilities) {
            totalRate += facility.getFacilityInformation().getRate();
        }
        return totalRate;
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
    public String getName() {
        return name;
    }

    @Override
    public FacilityType getFacilityType() {
        return type;
    }
}