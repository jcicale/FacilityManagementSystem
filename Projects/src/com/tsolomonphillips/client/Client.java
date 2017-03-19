package com.tsolomonphillips.client;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.tsolomonphillips.model.administrator.IInspection;
import com.tsolomonphillips.model.facility.Facility;
import com.tsolomonphillips.model.facility.FacilityType;
import com.tsolomonphillips.model.facility.IFacility;
import com.tsolomonphillips.model.facility.ITenant;
import com.tsolomonphillips.model.maintenance.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("***************** Application Context instantiated! ******************");

        //Instantiate our first complex using Spring
        IFacility firstApartmentComplex = (IFacility) context.getBean("facility");
        firstApartmentComplex.setName("First Apartment Complex");
        firstApartmentComplex.setFacilityType(FacilityType.COMPLEX);
        firstApartmentComplex.setBaseCapacity(0);
        firstApartmentComplex.setBaseRate(0);
        firstApartmentComplex.getAdministrator().setFacility(firstApartmentComplex);
        firstApartmentComplex.getMaintenance().setFacility(firstApartmentComplex);


        //Instantiate the first building
        IFacility buildingOne = (IFacility) context.getBean("facility");
        buildingOne.setName("Building One");
        buildingOne.setFacilityType(FacilityType.BUILDING);
        buildingOne.setBaseCapacity(0);
        buildingOne.setBaseRate(0);
        buildingOne.getAdministrator().setFacility(buildingOne);
        buildingOne.getMaintenance().setFacility(buildingOne);

        //Instantiate two rooms
        IFacility roomOne = (IFacility) context.getBean("facility");
        roomOne.setName("Room One");
        roomOne.setFacilityType(FacilityType.ROOM);
        roomOne.setBaseCapacity(2);
        roomOne.setBaseRate(1200);
        roomOne.getAdministrator().setFacility(roomOne);
        roomOne.getMaintenance().setFacility(roomOne);

        IFacility roomTwo = (IFacility) context.getBean("facility");
        roomTwo.setName("Room Two");
        roomTwo.setFacilityType(FacilityType.ROOM);
        roomTwo.setBaseCapacity(1);
        roomTwo.setBaseRate(900);
        roomTwo.getAdministrator().setFacility(roomTwo);
        roomTwo.getMaintenance().setFacility(roomTwo);

        //add rooms to building, add building to complex
        buildingOne.addFacility(roomOne);
        buildingOne.addFacility(roomTwo);
        firstApartmentComplex.addFacility(buildingOne);

        //print out current facility status
        System.out.println("A new facility has been constructed! The facility name is " + firstApartmentComplex.getFacilityInformation().getName() + ".");
        System.out.println("The capacity of this facility is " + firstApartmentComplex.getFacilityInformation().getCapacity() + ".");
        System.out.println("There is " + firstApartmentComplex.getSubFacilities().size() + " direct sub-facility (a " + firstApartmentComplex.getSubFacilities().get(0).getFacilityInformation().getFacilityType() + ") in this facility.");
        System.out.println();
        System.out.println("That " + firstApartmentComplex.getSubFacilities().get(0).getFacilityInformation().getFacilityType() +" is called " + buildingOne.getFacilityInformation().getName() + ".");
        System.out.println("The capacity of " + buildingOne.getFacilityInformation().getName() + " is " + buildingOne.getFacilityInformation().getCapacity() + ".");
        System.out.println("There are " + buildingOne.getSubFacilities().size() + " direct sub-facilities (" + buildingOne.getSubFacilities().get(0).getFacilityInformation().getFacilityType() + "S) in this facility.");
        System.out.println();
        for (IFacility facility : buildingOne.getSubFacilities()) {
            System.out.println("There is a " + buildingOne.getSubFacilities().get(0).getFacilityInformation().getFacilityType() + " in " + buildingOne.getFacilityInformation().getName() + " called " + facility.getFacilityInformation().getName() + ".");
            System.out.println(facility.getFacilityInformation().getName() + " has a capacity of " + facility.getFacilityInformation().getCapacity() + ".");
        }
        System.out.println();
        //changed name of apartment complex
        firstApartmentComplex.getFacilityInformation().setName("The Loyola Apartments");
        System.out.println("The first facility's name has been updated to " + firstApartmentComplex.getFacilityInformation().getName() + ".");

        //add a third room
        IFacility roomThree = (IFacility) context.getBean("facility");
        roomThree.setName("Room Three");
        roomThree.setFacilityType(FacilityType.ROOM);
        roomThree.setBaseCapacity(2);
        roomThree.setBaseRate(2000);
        roomThree.getAdministrator().setFacility(roomThree);
        roomThree.getMaintenance().setFacility(roomThree);
        buildingOne.addFacility(roomThree);
        System.out.println(roomThree.getFacilityInformation().getName() + " has been added to " + buildingOne.getName() + ".");
        System.out.println(firstApartmentComplex.getName() + " now has a capacity of " + firstApartmentComplex.getCapacity() + ".");
        System.out.println();

        //instantiate and add some tenants
        System.out.println("Adding some tenants to the rooms...");
        ITenant firstTenant = (ITenant) context.getBean("tenant");
        firstTenant.setName("Walter White");
        System.out.println("Added a tenant to Room One.");
        roomOne.addTenant(firstTenant);
        ITenant secondTenant = (ITenant) context.getBean("tenant");
        secondTenant.setName("Bruce Wayne");
        roomOne.addTenant(secondTenant);
        System.out.println("Added a tenant to Room One.");
        ITenant thirdTenant = (ITenant) context.getBean("tenant");
        //try to add a third tenant - won't work as it will go over capacity
        thirdTenant.setName("Maxwell Smart");
        roomOne.addTenant(thirdTenant);
        //put him in room two instead
        roomTwo.addTenant(thirdTenant);
        System.out.println("Added a tenant to Room Two.");
        ITenant fourthTenant = (ITenant) context.getBean("tenant");
        fourthTenant.setName("Barack Obama");
        roomThree.addTenant(fourthTenant);
        System.out.println("Added a tenant to Room Three.");
        ITenant fifthTenant = (ITenant) context.getBean("tenant");
        fifthTenant.setName("Ron Swanson");
        roomThree.addTenant(fifthTenant);
        System.out.println("Added a tenant to Room Three.");

        System.out.println();
        System.out.println(roomOne.getName() + " currently has " + roomOne.getAdministrator().getNumberOfTenants() + " tenants, " + roomOne.getFacilityTenants().get(0).getName() + " and " + roomOne.getFacilityTenants().get(1).getName() + ".");
        System.out.println(roomTwo.getName() + " currently has " + roomTwo.getAdministrator().getNumberOfTenants() + " tenant, " + roomTwo.getFacilityTenants().get(0).getName() + ".");
        System.out.println(roomThree.getName() + " currently has " + roomThree.getAdministrator().getNumberOfTenants() + " tenants, " + roomThree.getFacilityTenants().get(0).getName() + " and " + roomThree.getFacilityTenants().get(1).getName() + ".");
        System.out.println();
        System.out.println("The current occupancy rate of " + firstApartmentComplex.getName() + " is " + firstApartmentComplex.getAdministrator().getOccupiedPercentage() + "%.");
        System.out.println();


        //instantiate and perform some inspections
        IInspection firstInspection = (IInspection) context.getBean("inspection");
        firstInspection.setID(UUID.randomUUID().toString());
        firstApartmentComplex.getAdministrator().performInspection(firstInspection);
        System.out.println("An Inspection has been performed.");

        IInspection secondInspection = (IInspection) context.getBean("inspection");
        secondInspection.setID(UUID.randomUUID().toString());
        buildingOne.getAdministrator().performInspection(secondInspection);
        System.out.println("An Inspection has been performed.");

        IInspection thirdInspection = (IInspection) context.getBean("inspection");
        thirdInspection.setID(UUID.randomUUID().toString());
        buildingOne.getAdministrator().performInspection(thirdInspection);
        System.out.println("An Inspection has been performed.");

        System.out.println();
        System.out.println(firstApartmentComplex.getName() + " has had " + firstApartmentComplex.getAdministrator().getInspectionList().size() + " inspections.");
        System.out.println(buildingOne.getName() + " has had " + buildingOne.getAdministrator().getInspectionList().size() + " inspections.");
        System.out.println(roomOne.getName() + " has had " + roomOne.getAdministrator().getInspectionList().size() + " inspections.");
        System.out.println(roomTwo.getName() + " has had " + roomTwo.getAdministrator().getInspectionList().size() + " inspections.");
        System.out.println(roomThree.getName() + " has had " + roomThree.getAdministrator().getInspectionList().size() + " inspections.");
        System.out.println();


        //instantiate and submit some maintenance requests
        IMaintenanceRequest firstMaintenanceRequest = (IMaintenanceRequest) context.getBean("maintenanceRequest");
        firstMaintenanceRequest.setIdNumber(UUID.randomUUID().toString());
        firstMaintenanceRequest.setProblemType(ProblemType.ELECTRICAL);
        thirdTenant.makeFacilityMaintenanceRequest(firstMaintenanceRequest);
        System.out.println(thirdTenant.getName() + " submitted a Maintenance Request for " + firstMaintenanceRequest.getFacility().getName()  + " of type " + firstMaintenanceRequest.getProblemType() + " with ID number " + firstMaintenanceRequest.getIdNumber() + " on " + firstMaintenanceRequest.getDateRequested());
        System.out.println("There is now " + roomTwo.getMaintenance().getLog().getPendingMaintenance().size() + " pending maintenance items and " + roomTwo.getMaintenance().getLog().getCompletedMaintenance().size() + " completed maintenance items for " + roomTwo.getName() + ".");


        IMaintenanceRequest secondMaintenanceRequest = (IMaintenanceRequest) context.getBean("maintenanceRequest");
        secondMaintenanceRequest.setIdNumber(UUID.randomUUID().toString());
        secondMaintenanceRequest.setProblemType(ProblemType.PLUMBING);
        firstTenant.makeFacilityMaintenanceRequest(secondMaintenanceRequest);
        System.out.println(firstTenant.getName() + " submitted a Maintenance Request for " + secondMaintenanceRequest.getFacility().getName()  + " of type " + secondMaintenanceRequest.getProblemType() + " with ID number " + secondMaintenanceRequest.getIdNumber() + " on " + secondMaintenanceRequest.getDateRequested());
        System.out.println("There is now " + roomOne.getMaintenance().getLog().getPendingMaintenance().size() + " pending maintenance items and " + roomOne.getMaintenance().getLog().getCompletedMaintenance().size() + " completed maintenance items for " + roomOne.getName() + ".");


        IMaintenanceRequest thirdMaintenanceRequest = (IMaintenanceRequest) context.getBean("maintenanceRequest");
        thirdMaintenanceRequest.setIdNumber(UUID.randomUUID().toString());
        thirdMaintenanceRequest.setProblemType(ProblemType.COOLING);
        fifthTenant.makeFacilityMaintenanceRequest(thirdMaintenanceRequest);
        System.out.println(fifthTenant.getName() + " submitted a Maintenance Request for " + thirdMaintenanceRequest.getFacility().getName()  + " of type " + thirdMaintenanceRequest.getProblemType() + " with ID number " + thirdMaintenanceRequest.getIdNumber() + " on " + thirdMaintenanceRequest.getDateRequested() );
        System.out.println("There is now " + roomThree.getMaintenance().getLog().getPendingMaintenance().size() + " pending maintenance items and " + roomThree.getMaintenance().getLog().getCompletedMaintenance().size() + " completed maintenance items for " + roomThree.getName() + ".");


        IMaintenanceRequest fourthMaintenanceRequest = (IMaintenanceRequest) context.getBean("maintenanceRequest");
        fourthMaintenanceRequest.setIdNumber(UUID.randomUUID().toString());
        fourthMaintenanceRequest.setProblemType(ProblemType.HEATING);
        secondTenant.makeFacilityMaintenanceRequest(fourthMaintenanceRequest);
        System.out.println(fourthTenant.getName() + " submitted a Maintenance Request for " + fourthMaintenanceRequest.getFacility().getName()  + " of type " + fourthMaintenanceRequest.getProblemType() + " with ID number " + fourthMaintenanceRequest.getIdNumber() + " on " + fourthMaintenanceRequest.getDateRequested() );
        System.out.println("There are now " + roomOne.getMaintenance().getLog().getPendingMaintenance().size() + " pending maintenance items and " + roomOne.getMaintenance().getLog().getCompletedMaintenance().size() + " completed maintenance items for " + roomOne.getName() + ".");
        System.out.println();

        //use those maintenance requests to populate some maintenance orders
        IMaintenanceOrder firstMaintenanceOrder = (IMaintenanceOrder) context.getBean("maintenanceOrder");
        firstMaintenanceOrder.setMaintenanceRequest(firstMaintenanceRequest);
        firstMaintenanceOrder.setDateSubmitted(firstMaintenanceOrder.getMaintenanceRequest().getDateRequested());
        firstMaintenanceOrder.setDownTime(firstMaintenanceOrder.calculateDowntime());
        firstMaintenanceOrder.setMaintenanceCost(firstMaintenanceOrder.calculateMaintenanceCost());

        IMaintenanceOrder secondMaintenanceOrder = (IMaintenanceOrder) context.getBean("maintenanceOrder");
        secondMaintenanceOrder.setMaintenanceRequest(secondMaintenanceRequest);
        secondMaintenanceOrder.setDateSubmitted(secondMaintenanceOrder.getMaintenanceRequest().getDateRequested());
        secondMaintenanceOrder.setDownTime(secondMaintenanceOrder.calculateDowntime());
        secondMaintenanceOrder.setMaintenanceCost(secondMaintenanceOrder.calculateMaintenanceCost());

        IMaintenanceOrder thirdMaintenanceOrder = (IMaintenanceOrder) context.getBean("maintenanceOrder");
        thirdMaintenanceOrder.setMaintenanceRequest(thirdMaintenanceRequest);
        thirdMaintenanceOrder.setDateSubmitted(thirdMaintenanceOrder.getMaintenanceRequest().getDateRequested());
        thirdMaintenanceOrder.setDownTime(thirdMaintenanceOrder.calculateDowntime());
        thirdMaintenanceOrder.setMaintenanceCost(thirdMaintenanceOrder.calculateMaintenanceCost());

        IMaintenanceOrder fourthMaintenanceOrder = (IMaintenanceOrder) context.getBean("maintenanceOrder");
        fourthMaintenanceOrder.setMaintenanceRequest(fourthMaintenanceRequest);
        fourthMaintenanceOrder.setDateSubmitted(fourthMaintenanceOrder.getMaintenanceRequest().getDateRequested());
        fourthMaintenanceOrder.setDownTime(fourthMaintenanceOrder.calculateDowntime());
        fourthMaintenanceOrder.setMaintenanceCost(fourthMaintenanceOrder.calculateMaintenanceCost());

        //maybe some print statements here
        System.out.println();
        System.out.println("A Maintenance Order has been created for Maintenance Request ID: " + firstMaintenanceRequest.getIdNumber() + ".");
        System.out.println("A Maintenance Order has been created for Maintenance Request ID: " + secondMaintenanceRequest.getIdNumber() + ".");
        System.out.println("A Maintenance Order has been created for Maintenance Request ID: " + thirdMaintenanceRequest.getIdNumber() + ".");
        System.out.println("A Maintenance Order has been created for Maintenance Request ID: " + fourthMaintenanceRequest.getIdNumber() + ".");
        System.out.println();
        System.out.println("Maintenance Request ID: " + firstMaintenanceRequest.getIdNumber() + " is expected to cause a downtime of " + firstMaintenanceOrder.getDowntime() + " days and cost $" + firstMaintenanceOrder.getMaintenanceCost() + "0.");
        System.out.println("Maintenance Request ID: " + secondMaintenanceRequest.getIdNumber() + " is expected to cause a downtime of " + secondMaintenanceOrder.getDowntime() + " days and cost $" + secondMaintenanceOrder.getMaintenanceCost() + "0.");
        System.out.println("Maintenance Request ID: " + thirdMaintenanceRequest.getIdNumber() + " is expected to cause a downtime of " + thirdMaintenanceOrder.getDowntime() + " days and cost $" + thirdMaintenanceOrder.getMaintenanceCost() + "0.");
        System.out.println("Maintenance Request ID: " + fourthMaintenanceRequest.getIdNumber() + " is expected to cause a downtime of " + fourthMaintenanceOrder.getDowntime() + " days and cost $" + fourthMaintenanceOrder.getMaintenanceCost() + "0.");
        System.out.println();

        //use order and request to schedule maintenance
        Date firstDate = (Date) context.getBean("date");
        roomTwo.getMaintenance().scheduleMaintenance(firstMaintenanceOrder, firstDate);
        System.out.println("Maintenance Request ID: " + firstMaintenanceRequest.getIdNumber() + " has been scheduled for " + roomTwo.getMaintenance().getSchedule().getMap().get(firstMaintenanceOrder));

        Date secondDate = (Date) context.getBean("date");
        roomOne.getMaintenance().scheduleMaintenance(secondMaintenanceOrder, secondDate);
        System.out.println("Maintenance Request ID: " + secondMaintenanceRequest.getIdNumber() + " has been scheduled for " + roomOne.getMaintenance().getSchedule().getMap().get(secondMaintenanceOrder));

        Date thirdDate = (Date) context.getBean("date");
        roomThree.getMaintenance().scheduleMaintenance(thirdMaintenanceOrder, thirdDate);
        System.out.println("Maintenance Request ID: " + thirdMaintenanceRequest.getIdNumber() + " has been scheduled for " + roomThree.getMaintenance().getSchedule().getMap().get(thirdMaintenanceOrder));

        Date fourthDate = (Date) context.getBean("date");
        roomOne.getMaintenance().scheduleMaintenance(fourthMaintenanceOrder, fourthDate);
        System.out.println("Maintenance Request ID: " + fourthMaintenanceRequest.getIdNumber() + " has been scheduled for " + roomOne.getMaintenance().getSchedule().getMap().get(fourthMaintenanceOrder));
        System.out.println();

        //do some maintenance
        roomTwo.getMaintenance().doMaintenance(firstMaintenanceRequest);
        System.out.println("Maintenance Request ID: " + firstMaintenanceRequest.getIdNumber() + " has been completed.");
        System.out.println("There are now " + roomTwo.getMaintenance().getLog().getPendingMaintenance().size() + " pending maintenance items and " + roomTwo.getMaintenance().getLog().getCompletedMaintenance().size() + " completed maintenance items for " + roomTwo.getName() + ".");

        roomOne.getMaintenance().doMaintenance(secondMaintenanceRequest);
        System.out.println("Maintenance Request ID: " + secondMaintenanceRequest.getIdNumber() + " has been completed.");
        System.out.println("There is now " + roomOne.getMaintenance().getLog().getPendingMaintenance().size() + " pending maintenance items and " + roomOne.getMaintenance().getLog().getCompletedMaintenance().size() + " completed maintenance items for " + roomOne.getName() + ".");

        roomThree.getMaintenance().doMaintenance(thirdMaintenanceRequest);
        System.out.println("Maintenance Request ID: " + thirdMaintenanceRequest.getIdNumber() + " has been completed.");
        System.out.println("There are now " + roomThree.getMaintenance().getLog().getPendingMaintenance().size() + " pending maintenance items and " + roomThree.getMaintenance().getLog().getCompletedMaintenance().size() + " completed maintenance items for " + roomThree.getName() + ".");

        roomOne.getMaintenance().doMaintenance(fourthMaintenanceRequest);
        System.out.println("Maintenance Request ID: " + fourthMaintenanceRequest.getIdNumber() + " has been completed.");
        System.out.println("There are now " + roomOne.getMaintenance().getLog().getPendingMaintenance().size() + " pending maintenance items and " + roomOne.getMaintenance().getLog().getCompletedMaintenance().size() + " completed maintenance items for " + roomOne.getName() + ".");
        System.out.println();

        System.out.println(roomThree.getName() + " is planned for demolition and will be removed.");
        //this won't work, because there are currently tenants occupying room three
        buildingOne.removeFacility(roomThree);
        //so we vacate the facility
        roomThree.vacateFacility();
        System.out.println(roomThree.getName() + " has been vacated. The number of tenants in " + roomThree.getName() + " is now " + roomThree.getFacilityTenants().size() + ".");
        buildingOne.removeFacility(roomThree);
        System.out.println(roomThree.getName() + " has been removed from " + buildingOne.getName() + ".");
        System.out.println(buildingOne.getName() + " now has " + buildingOne.getSubFacilities().size() + " direct sub-facilities (" + roomOne.getFacilityType() + "S).");


    }
}