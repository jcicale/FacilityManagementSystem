package com.tsolomonphillips.client;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.tsolomonphillips.model.administrator.IInspection;
import com.tsolomonphillips.model.facility.Facility;
import com.tsolomonphillips.model.facility.FacilityType;
import com.tsolomonphillips.model.facility.IFacility;
import com.tsolomonphillips.model.facility.ITenant;
import com.tsolomonphillips.model.maintenance.Maintenance;
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

        //Instantiate the first building
        IFacility buildingOne = (IFacility) context.getBean("facility");
        buildingOne.setName("Building One");
        buildingOne.setFacilityType(FacilityType.BUILDING);
        buildingOne.setBaseCapacity(0);
        buildingOne.setBaseRate(0);

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

        //perform some inspections
        IInspection firstInspection = (IInspection) context.getBean("inspection");
        Date currentDate = (Date) context.getBean("currentDate");
        firstInspection.setDate(currentDate);
        firstInspection.setID(UUID.randomUUID().toString());
        firstApartmentComplex.getAdministrator().performInspection(firstInspection);

        System.out.println(firstInspection.getFacility());
    }
}