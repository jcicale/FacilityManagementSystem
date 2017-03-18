package com.tsolomonphillips.model.administrator;

import com.tsolomonphillips.model.facility.IFacility;

import javax.imageio.stream.IIOByteBuffer;
import java.util.List;

/**
 * Created by juliacicale1 on 2/18/17.
 */
public interface IAdministrator
{
    void setFacility(IFacility facility);
    IFacility getFacility();
    void setInspectionList(List<IInspection> inspectionList);
    List<IInspection> getInspectionList();

    List<IInspection> listInspections();
    void performInspection(IInspection inspection);

    float getOccupiedPercentage(); //calcUsageRate method
    int getAvailableCapacity();
    int getNumberOfTenants(); //actualUsageRate method

}
