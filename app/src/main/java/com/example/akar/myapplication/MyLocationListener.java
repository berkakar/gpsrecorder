package com.example.akar.myapplication;

import android.location.Location;
import android.os.Bundle;

import android.location.LocationListener;
import android.widget.TextView;

/**
 * Created by Akar on 12.02.2018.
 */

/*---------- Listener class to get coordinates ------------- */
public class MyLocationListener implements LocationListener {

    TextView statusText;

    MyLocationListener(TextView textView){
        statusText = textView;

    }

    @Override
    public void onLocationChanged(Location loc) {
        String longitude = "" + loc.getLongitude();
        String latitude = "" + loc.getLatitude();
        System.out.println("Longitude: " + longitude +   " Latitude: "  + latitude + "\n");
        statusText.append("Longitude: " + longitude +   " Latitude: "  + latitude + "\n");
        statusText.append("Longitude: " + longitude +   " Latitude: "  + latitude + "\n");



    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}


}
