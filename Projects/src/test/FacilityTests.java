package test;

import com.tsolomonphillips.Facility;
import com.tsolomonphillips.FacilityType;
import com.tsolomonphillips.IFacility;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by juliacicale1 on 2/18/17.
 */
public class FacilityTests {
    @Test
    public void simpleFacilityTest() {
        IFacility firstApartmentComplex = new Facility("First Apartment Complex", FacilityType.COMPLEX, 0, 0);
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        IFacility roomTwo = new Facility("Room Two", FacilityType.ROOM, 1, 900);
        buildingOne.addFacility(roomOne);
        buildingOne.addFacility(roomTwo);
        firstApartmentComplex.addFacility(buildingOne);
        assertEquals(3, firstApartmentComplex.getFacilityInformation().getCapacity());

    }

}
