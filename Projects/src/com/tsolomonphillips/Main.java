package com.tsolomonphillips;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args)
    {

        //BeanFactory factory = new XmlPortletApplicationContext();
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Maintenance maintenance = (Maintenance) context.getBean("facility");

        IFacility facility = maintenance.getIFacility();







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
