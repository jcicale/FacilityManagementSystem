package test;

import com.tsolomonphillips.model.facility.Facility;
import com.tsolomonphillips.model.facility.FacilityType;
import com.tsolomonphillips.model.facility.IFacility;
import com.tsolomonphillips.model.facility.Tenant;
import com.tsolomonphillips.model.maintenance.MaintenanceOrder;
import com.tsolomonphillips.model.maintenance.MaintenanceRequest;
import com.tsolomonphillips.model.maintenance.ProblemType;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by juliacicale1 on 2/18/17.
 */
public class FacilityTests {

    //test listFacility, addNewFacility, addFacilityDetail and facility structure setup
    @Test
    public void simpleFacilityTest() {
        IFacility firstApartmentComplex = new Facility("First Apartment Complex", FacilityType.COMPLEX, 0, 0);
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        IFacility roomTwo = new Facility("Room Two", FacilityType.ROOM, 1, 900);
        buildingOne.addFacility(roomOne);
        buildingOne.addFacility(roomTwo);
        firstApartmentComplex.addFacility(buildingOne);
        firstApartmentComplex.getFacilityInformation().setName("NameChange");
        assertEquals(3, firstApartmentComplex.getFacilityInformation().getCapacity());
        assertEquals(2, buildingOne.getFacilityList().size());
        assertEquals("NameChange", firstApartmentComplex.getFacilityInformation().getName());

    }

    //testing getFacilityInformation, getAvailableCapacity and another type of setup
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
        assertEquals(FacilityType.BUILDING, officeOne.getFacilityInformation().getFacilityType());
        assertEquals("Office One", officeOne.getFacilityInformation().getName());
        assertEquals(3, officeOne.getFacilityInformation().getCapacity());
    }

    //test removeFacility
    @Test
    public void removeFacilityTest() {
        IFacility firstApartmentComplex = new Facility("First Apartment Complex", FacilityType.COMPLEX, 0, 0);
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        IFacility roomTwo = new Facility("Room Two", FacilityType.ROOM, 1, 900);
        buildingOne.addFacility(roomOne);
        buildingOne.addFacility(roomTwo);
        firstApartmentComplex.addFacility(buildingOne);
        assertEquals(2, buildingOne.getFacilityList().size());
        assertEquals(3, buildingOne.getFacilityInformation().getCapacity());
        buildingOne.removeFacility(roomTwo);
        assertEquals(1, buildingOne.getFacilityList().size());
        assertEquals(2, buildingOne.getFacilityInformation().getCapacity());
    }

    //testing assignFacilityToUse
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
    public void removeTenantTest() {
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 1, 500);
        Tenant tenantOne = new Tenant("Tenant One");
        roomOne.removeTenant(tenantOne);
        assertEquals(null, tenantOne.getTenantFacility());
    }

    //testing vacateFacility
    @Test
    public void simpleVacateTest() {
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 500);
        Tenant tenantOne = new Tenant("Tenant One");
        Tenant tenantTwo = new Tenant("Tenant Two");
        roomOne.addTenant(tenantOne);
        roomOne.addTenant(tenantTwo);
        roomOne.vacateFacility();
        assertEquals(0, roomOne.getTenants().size());
        assertEquals(null, tenantOne.getTenantFacility());
        assertEquals(null, tenantTwo.getTenantFacility());
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

    //testing actualUsage and calcUsageRate
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

    //testing listInspections
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

    //testing makeFacilityMaintenanceRequest
    @Test
    public void maintenanceRequestTest() {
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        buildingOne.addFacility(roomOne);
        Tenant tenantOne = new Tenant("Tenant One");
        roomOne.addTenant(tenantOne);
        assertEquals(0, roomOne.getMaintenance().getLog().getPendingMaintenance().size());
        MaintenanceRequest sampleRequest = tenantOne.makeFacilityMaintenanceRequest(ProblemType.ELECTRICAL);
        assertEquals(1, roomOne.getMaintenance().getLog().getPendingMaintenance().size());

    }

    //testing scheduleMaintenance
    @Test
    public void scheduleMaintenanceTest() {
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        buildingOne.addFacility(roomOne);
        Tenant tenantOne = new Tenant("Tenant One");
        roomOne.addTenant(tenantOne);
        MaintenanceRequest sampleRequest = tenantOne.makeFacilityMaintenanceRequest(ProblemType.ELECTRICAL);
        MaintenanceOrder sampleOrder = roomOne.getMaintenance().createMaintenanceOrder(sampleRequest);
        assertEquals(0, roomOne.getMaintenance().getSchedule().getMaintenanceOrders().size());
        assertEquals(true, roomOne.getMaintenance().getSchedule().getMap().isEmpty());
        roomOne.getMaintenance().scheduleMaintenance(sampleOrder);
        assertEquals(false, roomOne.getMaintenance().getSchedule().getMap().isEmpty());
        assertEquals(sampleOrder, roomOne.getMaintenance().getSchedule().getMaintenanceOrders().get(0));
    }

    //testing calcMaintenanceCostForFacility
    @Test
    public void calcMaintenanceCostTest() {
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        buildingOne.addFacility(roomOne);
        Tenant tenantOne = new Tenant("Tenant One");
        roomOne.addTenant(tenantOne);
        MaintenanceRequest sampleRequest = tenantOne.makeFacilityMaintenanceRequest(ProblemType.ELECTRICAL);
        MaintenanceOrder sampleOrder = roomOne.getMaintenance().createMaintenanceOrder(sampleRequest);
        roomOne.getMaintenance().scheduleMaintenance(sampleOrder);
        double cost = roomOne.getMaintenance().calcMaintCostForFacility(sampleOrder);
        assertEquals(300.0, cost); //electrical issues always cost 300
    }

    //testing calcProblemRateForFacility, problem rate is the total number of completed maintenance issues
    @Test
    public void problemRateTest() {
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        buildingOne.addFacility(roomOne);
        Tenant tenantOne = new Tenant("Tenant One");
        roomOne.addTenant(tenantOne);
        MaintenanceRequest sampleRequest = tenantOne.makeFacilityMaintenanceRequest(ProblemType.ELECTRICAL);
        MaintenanceOrder sampleOrder = roomOne.getMaintenance().createMaintenanceOrder(sampleRequest);
        roomOne.getMaintenance().scheduleMaintenance(sampleOrder);
        roomOne.getMaintenance().doMaintenance(sampleRequest);
        assertEquals(1, roomOne.getMaintenance().calcProblemRateForFacility());
        MaintenanceRequest sampleRequestTwo = tenantOne.makeFacilityMaintenanceRequest(ProblemType.PLUMBING);
        MaintenanceOrder sampleOrderTwo = roomOne.getMaintenance().createMaintenanceOrder(sampleRequest);
        roomOne.getMaintenance().scheduleMaintenance(sampleOrder);
        roomOne.getMaintenance().doMaintenance(sampleRequest);
        assertEquals(2, roomOne.getMaintenance().calcProblemRateForFacility());
    }

    //testing calcDownTimeForFacility, down time is total number of days
    //required to perform all maintenance that has been completed on that facility
    @Test
    public void downTimeTest() {
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        buildingOne.addFacility(roomOne);
        Tenant tenantOne = new Tenant("Tenant One");
        roomOne.addTenant(tenantOne);
        MaintenanceRequest sampleRequest = tenantOne.makeFacilityMaintenanceRequest(ProblemType.ELECTRICAL); // downtime of 2
        MaintenanceOrder sampleOrder = roomOne.getMaintenance().createMaintenanceOrder(sampleRequest);
        roomOne.getMaintenance().scheduleMaintenance(sampleOrder);
        roomOne.getMaintenance().doMaintenance(sampleRequest);
        assertEquals(2, roomOne.getMaintenance().calcDownTimeForFacility());
        MaintenanceRequest sampleRequestTwo = tenantOne.makeFacilityMaintenanceRequest(ProblemType.PLUMBING); // downtime of 1
        MaintenanceOrder sampleOrderTwo = roomOne.getMaintenance().createMaintenanceOrder(sampleRequestTwo);
        roomOne.getMaintenance().scheduleMaintenance(sampleOrderTwo);
        roomOne.getMaintenance().doMaintenance(sampleRequestTwo);
        assertEquals(3, roomOne.getMaintenance().calcDownTimeForFacility()); //total downtime of 3
    }

    //test listMaintenance (completed maintenance) and listMaintRequests (pending maintenance)
    @Test
    public void completedMaintenanceRequestsTest() {
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        buildingOne.addFacility(roomOne);
        Tenant tenantOne = new Tenant("Tenant One");
        roomOne.addTenant(tenantOne);
        MaintenanceRequest sampleRequest = tenantOne.makeFacilityMaintenanceRequest(ProblemType.ELECTRICAL);
        MaintenanceOrder sampleOrder = roomOne.getMaintenance().createMaintenanceOrder(sampleRequest);
        assertEquals(1, roomOne.getMaintenance().getLog().getPendingMaintenance().size());
        assertEquals(0, roomOne.getMaintenance().getLog().getCompletedMaintenance().size());
        roomOne.getMaintenance().scheduleMaintenance(sampleOrder);
        roomOne.getMaintenance().doMaintenance(sampleRequest);
        assertEquals(0, roomOne.getMaintenance().getLog().getPendingMaintenance().size());
        assertEquals(1, roomOne.getMaintenance().getLog().getCompletedMaintenance().size());
        MaintenanceRequest sampleRequestTwo = tenantOne.makeFacilityMaintenanceRequest(ProblemType.PLUMBING);
        assertEquals(1, roomOne.getMaintenance().getLog().getPendingMaintenance().size());
        assertEquals(1, roomOne.getMaintenance().getLog().getCompletedMaintenance().size());
        MaintenanceOrder sampleOrderTwo = roomOne.getMaintenance().createMaintenanceOrder(sampleRequestTwo);
        roomOne.getMaintenance().scheduleMaintenance(sampleOrderTwo);
        roomOne.getMaintenance().doMaintenance(sampleRequestTwo);
        assertEquals(0, roomOne.getMaintenance().getLog().getPendingMaintenance().size());
        assertEquals(2, roomOne.getMaintenance().getLog().getCompletedMaintenance().size());
    }

    //test listFacilityProblems
    @Test
    public void facilityProblemsTest() {
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        buildingOne.addFacility(roomOne);
        Tenant tenantOne = new Tenant("Tenant One");
        roomOne.addTenant(tenantOne);
        assertEquals(0, roomOne.getMaintenance().listFacilityProblems().size());
        MaintenanceRequest sampleRequest = tenantOne.makeFacilityMaintenanceRequest(ProblemType.ELECTRICAL);
        MaintenanceOrder sampleOrder = roomOne.getMaintenance().createMaintenanceOrder(sampleRequest);
        roomOne.getMaintenance().scheduleMaintenance(sampleOrder);
        roomOne.getMaintenance().doMaintenance(sampleRequest);
        assertEquals(1, roomOne.getMaintenance().listFacilityProblems().size());
        assertEquals(ProblemType.ELECTRICAL, roomOne.getMaintenance().listFacilityProblems().get(0));
        MaintenanceRequest sampleRequestTwo = tenantOne.makeFacilityMaintenanceRequest(ProblemType.PLUMBING);
        MaintenanceOrder sampleOrderTwo = roomOne.getMaintenance().createMaintenanceOrder(sampleRequestTwo);
        roomOne.getMaintenance().scheduleMaintenance(sampleOrderTwo);
        roomOne.getMaintenance().doMaintenance(sampleRequestTwo);
        assertEquals(2, roomOne.getMaintenance().listFacilityProblems().size());
        assertEquals(ProblemType.PLUMBING, roomOne.getMaintenance().listFacilityProblems().get(1));
    }
}
