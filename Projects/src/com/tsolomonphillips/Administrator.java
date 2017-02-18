package com.tsolomonphillips;
import java.util.List;
/**
 * Created by juliacicale1 on 2/16/17.
 */
public class Administrator implements IAdministrator {
    private IFacility facility;

    public Administrator(IFacility facility) {
        this.facility = facility;
    }

    @Override
    public List<Inspection> listInspections() {
        return null;
    }

    @Override
    public String listFacilityProblems() {
        return null;
    }

    @Override
    public float getOccupiedPercentage() {
        if (facility.getFacilityInformation().getCapacity() == 0) return 1;
        return (float)facility.getTenants().size()/(float)facility.getFacilityInformation().getCapacity();
    }

    @Override
    public int getAvailableCapacity() {
        return facility.getFacilityInformation().getCapacity() - facility.getTenants().size();
    }

    @Override
    public int getNumberOfTenants() {
        return facility.getTenants().size();
    }
}