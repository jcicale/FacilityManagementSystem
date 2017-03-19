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


        //Instantiate the first building
        IFacility buildingOne = (IFacility) context.getBean("facility");
        buildingOne.setName("Building One");
        buildingOne.setFacilityType(FacilityType.BUILDING);
        buildingOne.setBaseCapacity(0);
        buildingOne.setBaseRate(0);
        buildingOne.getAdministrator().setFacility(buildingOne);

        //Instantiate two rooms
        IFacility roomOne = (IFacility) context.getBean("facility");
        roomOne.setName("Room One");
        roomOne.setFacilityType(FacilityType.ROOM);
        roomOne.setBaseCapacity(2);
        roomOne.setBaseRate(1200);
        IFacility roomTwo = (IFacility) context.getBean("facility");
        roomTwo.setName("Room Two");
        roomTwo.setFacilityType(FacilityType.ROOM);
        roomTwo.setBaseCapacity(1);
        roomTwo.setBaseRate(900);

        //add rooms to building, add building to complex
        buildingOne.addFacility(roomOne);
        buildingOne.addFacility(roomTwo);
        firstApartmentComplex.addFacility(buildingOne);

        //print out current facility status
        System.out.println("A new facility has been constructed! The facility name is " + firstApartmentComplex.getFacilityInformation().getName() + ".");
        System.out.println("The capacity of this facility is " + firstApartmentComplex.getFacilityInformation().getCapacity() + ".");
        System.out.println("There is " + firstApartmentComplex.getSubFacilities().size() + " direct sub-facility in this facility.");
        System.out.println();
        System.out.println("That sub-facility is called " + buildingOne.getFacilityInformation().getName() + ".");
        System.out.println("The capacity of " + buildingOne.getFacilityInformation().getName() + " is " + buildingOne.getFacilityInformation().getCapacity() + ".");
        System.out.println("There are " + buildingOne.getSubFacilities().size() + " direct sub-facilities in this facility.");
        System.out.println();
        for (IFacility facility : buildingOne.getSubFacilities()) {
            System.out.println("There is a direct sub-facility of " + buildingOne.getFacilityInformation().getName() + " called " + facility.getFacilityInformation().getName() + ".");
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
        buildingOne.addFacility(roomThree);
        System.out.println("Added "+ roomThree.getFacilityInformation().getName() + " to " + buildingOne.getName() + ".");
        System.out.println(firstApartmentComplex.getName() + " now has a capacity of " + firstApartmentComplex.getCapacity() + ".");

        //instantiate and add some tenants
        ITenant firstTenant = (ITenant) context.getBean("tenant");
        firstTenant.setName("Walter White");
        roomOne.addTenant(firstTenant);
        ITenant secondTenant = (ITenant) context.getBean("tenant");
        secondTenant.setName("Bruce Wayne");
        roomOne.addTenant(secondTenant);
        ITenant thirdTenant = (ITenant) context.getBean("tenant");
        //try to add a third tenant - won't work as it will go over capacity
        thirdTenant.setName("Maxwell Smart");
        roomOne.addTenant(thirdTenant);
        //put him in room two instead
        roomTwo.addTenant(thirdTenant);
        ITenant fourthTenant = (ITenant) context.getBean("tenant");
        fourthTenant.setName("Barack Obama");
        roomThree.addTenant(fourthTenant);
        ITenant fifthTenant = (ITenant) context.getBean("tenant");
        fifthTenant.setName("Ron Swanson");
        roomThree.addTenant(fifthTenant);

        //maybe some print statements here

        //instantiate and perform some inspections
        IInspection firstInspection = (IInspection) context.getBean("inspection");
        firstInspection.setID(UUID.randomUUID().toString());
        firstApartmentComplex.getAdministrator().performInspection(firstInspection);

        IInspection secondInspection = (IInspection) context.getBean("inspection");
        secondInspection.setID(UUID.randomUUID().toString());
        buildingOne.getAdministrator().performInspection(secondInspection);

        IInspection thirdInspection = (IInspection) context.getBean("inspection");
        thirdInspection.setID(UUID.randomUUID().toString());
        buildingOne.getAdministrator().performInspection(thirdInspection);

        //maybe some print statements here

        //instantiate and submit some maintenance requests
        IMaintenanceRequest firstMaintenanceRequest = (IMaintenanceRequest) context.getBean("maintenanceRequest");
        firstMaintenanceRequest.setIdNumber(UUID.randomUUID().toString());
        firstMaintenanceRequest.setProblemType(ProblemType.ELECTRICAL);
        thirdTenant.makeFacilityMaintenanceRequest(firstMaintenanceRequest);

        IMaintenanceRequest secondMaintenanceRequest = (IMaintenanceRequest) context.getBean("maintenanceRequest");
        secondMaintenanceRequest.setIdNumber(UUID.randomUUID().toString());
        secondMaintenanceRequest.setProblemType(ProblemType.PLUMBING);
        firstTenant.makeFacilityMaintenanceRequest(secondMaintenanceRequest);

        IMaintenanceRequest thirdMaintenanceRequest = (IMaintenanceRequest) context.getBean("maintenanceRequest");
        thirdMaintenanceRequest.setIdNumber(UUID.randomUUID().toString());
        thirdMaintenanceRequest.setProblemType(ProblemType.COOLING);
        fifthTenant.makeFacilityMaintenanceRequest(thirdMaintenanceRequest);

        IMaintenanceRequest fourthMaintenanceRequest = (IMaintenanceRequest) context.getBean("maintenanceRequest");
        firstMaintenanceRequest.setIdNumber(UUID.randomUUID().toString());
        firstMaintenanceRequest.setProblemType(ProblemType.HEATING);
        secondTenant.makeFacilityMaintenanceRequest(fourthMaintenanceRequest);

        //maybe some print statements here

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

        //use order and request to schedule maintenance
        Date firstDate = (Date) context.getBean("date");
        roomTwo.getMaintenance().scheduleMaintenance(firstMaintenanceOrder, firstDate);

        System.out.println("Schedule " + roomOne.getMaintenance().getSchedule().getMap().size());
        Date secondDate = (Date) context.getBean("date");
        roomOne.getMaintenance().scheduleMaintenance(secondMaintenanceOrder, secondDate);
        System.out.println("Schedule: " + roomOne.getMaintenance().getSchedule().getMap().size());

        Date thirdDate = (Date) context.getBean("date");
        roomThree.getMaintenance().scheduleMaintenance(thirdMaintenanceOrder, thirdDate);

        Date fourthDate = (Date) context.getBean("date");
        roomOne.getMaintenance().scheduleMaintenance(fourthMaintenanceOrder, fourthDate);
        System.out.println("Schedule: " + roomOne.getMaintenance().getSchedule().getMap().size());
    }
}