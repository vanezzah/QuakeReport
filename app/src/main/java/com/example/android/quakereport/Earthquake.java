package com.example.android.quakereport;


import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vanessawanner on 19.07.18.
 */

public class Earthquake {

    //variables

    private Double mMagnitude;
    private String mLocation;
    private long mTimeinmilliseconds;
    private String mUrl;

    // constructor

    public Earthquake (Double mag, String location, long timeinmilliseconds, String url) {
     mMagnitude = mag;
     mLocation = location;
     mTimeinmilliseconds = timeinmilliseconds;
     mUrl = url;

    }

    // Methods

    public Double getMagnitude() {
        return mMagnitude;
           }


    public String getLocation() {
        return mLocation;
    }


    public long getTimeinmilliseconds() {
        return mTimeinmilliseconds;
    }

    public String getUrl() {
        return mUrl;

    }





}
