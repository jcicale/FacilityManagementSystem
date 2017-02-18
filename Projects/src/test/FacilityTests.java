package test;

import com.tsolomonphillips.Facility;
import com.tsolomonphillips.FacilityType;
import com.tsolomonphillips.IFacility;
import com.tsolomonphillips.Tenant;
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

    @Test
    public void simpleFacilityTestTwo() {
        IFacility officeOne = new Facility("Office One", FacilityType.BUILDING, 0, 2000);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 50);
        IFacility roomTwo = new Facility("Room Two", FacilityType.ROOM, 1, 50);
        officeOne.addFacility(roomOne);
        officeOne.addFacility(roomTwo);
        assertEquals(50.0, roomOne.getFacilityInformation().getRate());
        assertEquals(50.0, roomTwo.getFacilityInformation().getRate());
        assertEquals(2100.0, officeOne.getFacilityInformation().getRate());
    }

    @Test
    public void simpleTenantTest() {
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 1, 500);
        Tenant tenantOne = new Tenant("Tenant One");
        Tenant tenantTwo = new Tenant("Tenant Two");
        assertTrue(roomOne.addTenant(tenantOne));
        assertFalse(roomOne.addTenant(tenantTwo));
        roomOne.removeTenant(tenantOne);
        assertTrue(roomOne.addTenant(tenantTwo));
    }

    @Test
    public void simpleVacateTest() {
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 500);
        Tenant tenantOne = new Tenant("Tenant One");
        Tenant tenantTwo = new Tenant("Tenant Two");
        roomOne.addTenant(tenantOne);
        roomOne.addTenant(tenantTwo);
        roomOne.vacateFacility();
        assertEquals(0, roomOne.getTenants().size());
    }

    @Test
    public void buildingVacateTest() {
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        IFacility roomTwo = new Facility("Room Two", FacilityType.ROOM, 1, 900);
        buildingOne.addFacility(roomOne);
        buildingOne.addFacility(roomTwo);
        Tenant tenantOne = new Tenant("Tenant One");
        Tenant tenantTwo = new Tenant("Tenant Two");
        Tenant tenantThree = new Tenant("Tenant Three");
        roomOne.addTenant(tenantOne);
        roomOne.addTenant(tenantTwo);
        roomTwo.addTenant(tenantThree);
        buildingOne.vacateFacility();
        assertEquals(0, buildingOne.getTenants().size());
        assertEquals(0, roomOne.getTenants().size());
        assertEquals(0, roomTwo.getTenants().size());
    }

    @Test
    public void administratorTest() {
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        IFacility roomTwo = new Facility("Room Two", FacilityType.ROOM, 1, 900);
        buildingOne.addFacility(roomOne);
        buildingOne.addFacility(roomTwo);
        Tenant tenantOne = new Tenant("Tenant One");
        roomOne.addTenant(tenantOne);
        assertEquals(2, buildingOne.getAdministrator().getAvailableCapacity());
        assertEquals(1.0/3.0, buildingOne.getAdministrator().getOccupiedPercentage(), .001);
        assertEquals(1, buildingOne.getAdministrator().getNumberOfTenants());
    }

    @Test
    public void inspectionTest() {
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        IFacility roomTwo = new Facility("Room Two", FacilityType.ROOM, 1, 900);
        buildingOne.addFacility(roomOne);
        buildingOne.addFacility(roomTwo);
        roomOne.getAdministrator().performInspection();
        roomTwo.getAdministrator().performInspection();
        assertEquals(2, buildingOne.getAdministrator().listInspections().size());
        assertEquals(1, roomOne.getAdministrator().listInspections().size());
        assertEquals(1, roomTwo.getAdministrator().listInspections().size());
    }
}
