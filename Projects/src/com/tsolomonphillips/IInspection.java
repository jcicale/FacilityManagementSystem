package com.tsolomonphillips;

import java.util.Date;

/**
 * Created by juliacicale1 on 2/18/17.
 */
public interface IInspection {
    String getID();
    Date getDate();
    IFacility getFacility();
}
