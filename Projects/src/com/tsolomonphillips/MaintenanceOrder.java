package com.tsolomonphillips;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class MaintenanceOrder {
    private String dateSubmitted;
    private String dateScheduled;

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public String getDateScheduled() {
        return dateScheduled;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public void setDateScheduled(String dateScheduled) {
        this.dateScheduled = dateScheduled;
    }
}
