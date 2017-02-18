package com.tsolomonphillips;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello world");

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
