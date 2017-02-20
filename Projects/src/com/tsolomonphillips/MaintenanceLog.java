package com.tsolomonphillips;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tyree on 2/18/2017.
 */
public class MaintenanceLog {
    private List<MaintenanceRequest> pendingMaintenance;
    private List<MaintenanceRequest> completedMaintenance;

    public MaintenanceLog() {
        pendingMaintenance = new ArrayList<>();
        completedMaintenance = new ArrayList<>();
    }

    public List<MaintenanceRequest> getPendingMaintenance() {
        return pendingMaintenance;
    }

    public List<MaintenanceRequest> getCompletedMaintenance() {
        return completedMaintenance;
    }

    public void addToPendingMaintenance(MaintenanceRequest request) {
        pendingMaintenance.add(request);
    }
}
