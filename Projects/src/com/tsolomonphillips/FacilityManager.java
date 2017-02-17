package com.tsolomonphillips;

import java.util.Vector;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class FacilityManager {
    private Vector<Facility> facilityList = new Vector<>();

    public void addFacility(String buildingName, double buildingRate) {
        Facility facilityToAdd = new Building(buildingName, buildingRate);
        facilityList.add(facilityToAdd);
        }

    public void addFacility(String roomNumber, int capacity, double monthlyPrice) {
        Facility facilityToAdd = new Room(roomNumber, capacity, monthlyPrice);
        facilityList.add(facilityToAdd);
        }

    public void removeFacility(Facility facilityToRemove) {
        facilityList.remove(facilityToRemove);
    }

    public void addFacilityDetail(Building buildingToChange, String newBuildingName, double newBuildingPrice) {
        buildingToChange.setBuildingName(newBuildingName);
        buildingToChange.setBuildingRate(newBuildingPrice);
    }

    public void addFacilityDetail(Room roomToChange, String newRoomNumber, int newCapacity, double newMonthlyPrice) {
        roomToChange.setRoomNumber(newRoomNumber);
        roomToChange.setCapacity(newCapacity);
        roomToChange.setMonthlyPrice(newMonthlyPrice);
    }

}
