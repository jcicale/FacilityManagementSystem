package com.tsolomonphillips.client;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.tsolomonphillips.model.facility.Facility;
import com.tsolomonphillips.model.facility.FacilityType;
import com.tsolomonphillips.model.facility.IFacility;
import com.tsolomonphillips.model.maintenance.Maintenance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("***************** Application Context instantiated! ******************");

        IFacility firstApartmentComplex = (IFacility) context.getBean("facility");
        firstApartmentComplex.setName("First Apartment Complex");

        //adding a facility - one apartment complex containing one building which contains two rooms
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        IFacility roomTwo = new Facility("Room Two", FacilityType.ROOM, 1, 900);
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




    }
}