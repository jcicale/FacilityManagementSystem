package com.tsolomonphillips;


import sun.rmi.runtime.Log;

import javax.xml.soap.Detail;
import java.util.List;
import java.util.Vector;

public class Room implements Facility
{
    private String roomNumber;
    private int capacity;
    private double monthlyPrice;
    private List<Tenant> currentTenants;

    public Room(String roomNumber, int capacity, double monthlyPrice) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.monthlyPrice = monthlyPrice;
        this.currentTenants = new Vector<>(capacity);
        System.out.println("A new room has been constructed with a room number of " + roomNumber + ", a capacity of " + capacity + ", and a monthly price of " + monthlyPrice + ".");
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public void setCurrentTenant(Tenant tenant) {
        if (currentTenants.size() < capacity) {
            this.currentTenants.add(tenant);
        }
        else System.out.println("This room is full. One or more tenants must be removed before another can be added.");
    }

    public void assignFacilityToUse(Tenant tenant) {
        this.currentTenants.add(tenant);
        System.out.println("A new tenant has been added to Room " + roomNumber);
    }

    @Override
    public Log listMaintenance()
    {
        return null;
    }

    @Override
    public List<MaintenanceRequest> listMaintRequests()
    {
        return null;
    }

    @Override
    public List<Facility> listFacilities()
    {
        return null;
    }

    @Override
    public void getFacilityInformation()
    {
        System.out.println("Facility detail: ");
        System.out.println("This facility is a room. The number is " + this.roomNumber);
        System.out.println("This facility's capacity is " + this.capacity);
        System.out.println("The monthly price for this facility is " + this.monthlyPrice);
        System.out.println("There are currently " + this.currentTenants.size() + " using this room.");

    }

    @Override
    public int requestAvailableCapacity()
    {
        return 0;
    }

    @Override
    public void vacateFacility() {
        for (int i = 0; i < currentTenants.size(); i++) {
            currentTenants.remove(i);
        }
        System.out.println("All tenants have been removed from Room " + roomNumber);
    }

    @Override
    public boolean isInUseDuringInterval()
    {
        return false;
    }


    @Override
    public List<Inspection> listInspections()
    {
        return null;
    }

    @Override
    public double listActualUsage()
    {
        return 0;
    }

    @Override
    public double calcUsageRate()
    {
        return 0;
    }

    @Override
    public String listFacilityProblems()
    {
        return null;
    }

    @Override
    public List<Log> logList()
    {
        return null;
    }

    @Override
    public List<MaintenanceOrder> maintenanceOrders()
    {
        return null;
    }
}
