package com.tsolomonphillips;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args)
    {
        IFacility firstApartmentComplex = new Facility("First Apartment Complex", FacilityType.COMPLEX, 0, 0);
        IFacility buildingOne = new Facility("Building One", FacilityType.BUILDING, 0, 0);
        IFacility roomOne = new Facility("Room One", FacilityType.ROOM, 2, 1200);
        IFacility roomTwo = new Facility("Room Two", FacilityType.ROOM, 1, 900);
        buildingOne.addFacility(roomOne);
        buildingOne.addFacility(roomTwo);
        firstApartmentComplex.addFacility(buildingOne);
        System.out.println(firstApartmentComplex.getFacilityInformation().getCapacity());


        /*SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String date = "04/21/1998";
        try
        {
            System.out.println(sdf.parse(date));
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        */

        String date = "02/17/2017";
        convertStringToDate(date);



    }

    static void convertStringToDate(String date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try
        {
            System.out.println(sdf.parse(date));
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}
