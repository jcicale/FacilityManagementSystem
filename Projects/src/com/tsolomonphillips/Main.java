package com.tsolomonphillips;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args)
    {

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
        Date date = new Date();
        roomOne.getMaintenance().scheduleMaintenance(roomOne.getMaintenance().createMaintenanceOrder(tenantOne.makeFacilityMaintenanceRequest(ProblemType.COOLING, date)));



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

//        String date = "02/17/2017";
//        convertStringToDate(date);



    }

//    static void convertStringToDate(String date)
//    {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//        try
//        {
//            System.out.println(sdf.parse(date));
//        } catch (ParseException e)
//        {
//            e.printStackTrace();
//        }
//    }
}
