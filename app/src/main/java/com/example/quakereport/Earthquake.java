package com.example.quakereport;

public class Earthquake {
    /** Website URL of the earthquake */
    private String mUrl;
   // private String mMagnitude;
    /** Magnitude of the earthquake */
    private double mMagnitude;

    private String mLocation;


    /** Time of the earthquake */
    private long mTimeInMilliseconds;
    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the location where the earthquake happened
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *                           earthquake happened
     * @param url is the website URL to find more details about the earthquake
     */
//Constructor
    public Earthquake(double magnitude, String location, long timeInMilliseconds,String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    //return magnitude of the earthquake
    public double getmMagnitude() {
        return mMagnitude;
    }
//return Location of the earthquake
    public String getmLocation() {
        return mLocation;
    }
    /**
     * Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }
}
