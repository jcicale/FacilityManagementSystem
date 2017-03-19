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
    private List<IInspection> allInspections;

//    public Administrator(IFacility facility) {
//        this.facility = facility;
//    }

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

    @Override
    public void setAllInspections(List<IInspection> allInspections) {
        this.allInspections = allInspections;
    }

    @Override
    public List<IInspection> getAllInspections() {
        return allInspections;
    }

    @Override
    public List<IInspection> listInspections() {
        List<IInspection> allInspectionsList = allInspections;
        allInspectionsList.addAll(inspectionList);
        for (IFacility facility : facility.getSubFacilities()) {
            allInspectionsList.addAll(facility.getAdministrator().listInspections());
        }
        return allInspectionsList;
    }

    @Override
    public void performInspection(IInspection inspection) {
        //when an administrator performs an inspection, it will be set for his/her facility, rather than doing this in client
        inspection.setFacility(this.getFacility());
        inspectionList.add(inspection);
    }

    @Override
    public float getOccupiedPercentage() {
        if (facility.getFacilityInformation().getCapacity() == 0) return 1;
        return (float)facility.listActualUsage().size()/(float)facility.getFacilityInformation().getCapacity() * 100;
    }

    @Override
    public int getAvailableCapacity() {
        return facility.getFacilityInformation().getCapacity() - facility.listActualUsage().size();
    }

    @Override
    public int getNumberOfTenants() {
        return facility.getFacilityTenants().size();
    }

}