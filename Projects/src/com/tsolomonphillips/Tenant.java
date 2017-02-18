package com.tsolomonphillips;

/**
 * Created by juliacicale1 on 2/17/17.
 */
public class Tenant {
    private String name;

    public Tenant(String name) {
        this.name = name;
    }

    public MaintenanceRequest makeMaintenanceRequest(String problemType, String dateRequested, boolean isCompleted, String idNumber) {
        MaintenanceRequest newRequest = new MaintenanceRequest(problemType, dateRequested, isCompleted, idNumber);
        return newRequest;
    }
}
