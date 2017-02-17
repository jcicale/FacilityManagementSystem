package com.tsolomonphillips;
import java.util.Vector;
/**
 * Created by juliacicale1 on 2/16/17.
 */
public class Administrator {
    private Vector<Inspection> inspectionList = new Vector<Inspection>();
    public Administrator() {
    }
    public double calculateUsage() {
        return 0;
    }
    public Vector<Inspection> listInspections() {
        return null;
    }
    public void addBuilding(String buildingName, double buildingRate) {
        Building buildingToAdd = new Building(buildingName, buildingRate);
        //add to list?
    }
    public void addRoom(String roomNumber, int roomCapacity, double monthlyPrice) {

    }

}
