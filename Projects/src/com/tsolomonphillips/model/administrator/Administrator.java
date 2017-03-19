package com.tsolomonphillips.model.administrator;
import com.tsolomonphillips.model.facility.IFacility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by juliacicale1 on 2/16/17.
 */
public class Administrator implements IAdministrator {
    private IFacility facility;
    private List<IInspection> inspectionList;

    public Administrator(IFacility facility) {
        this.facility = facility;
    }

    public Administrator() {

    }

    @Override
    public void setFacility(IFacility facility) {
        this.facility = facility;
    }

    @Override
    public IFacility getFacility() {
        return facility;
    }

    @Override
    public void setInspectionList(List<IInspection> inspectionList) {
        this.inspectionList = inspectionList;
    }

    @Override
    public List<IInspection> getInspectionList() {
        return inspectionList;
    }

    //gotta figure this one out too
    @Override
    public List<IInspection> listInspections() {
        List<IInspection> allInspections = new ArrayList<>();
        allInspections.addAll(inspectionList);
        for (IFacility facility : facility.getSubFacilities()) {
            allInspections.addAll(facility.getAdministrator().listInspections());
        }
        return allInspections;
    }

    @Override
    public void performInspection(IInspection inspection) {
        inspection.setFacility(this.getFacility());
        inspectionList.add(inspection);
    }

    @Override
    public float getOccupiedPercentage() {
//        if (facility.getFacilityInformation().getCapacity() == 0) return 1;
//        return (float)facility.getTenants().size()/(float)facility.getFacilityInformation().getCapacity();
        return 0;
    }

    @Override
    public int getAvailableCapacity() {
//        return facility.getFacilityInformation().getCapacity() - facility.getTenants().size();
        return 0;
    }

    @Override
    public int getNumberOfTenants() {
//        return facility.getTenants().size();
        return 0;
    }
}