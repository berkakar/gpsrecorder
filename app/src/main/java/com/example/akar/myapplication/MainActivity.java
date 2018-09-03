package com.example.akar.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private LocationManager locationManager;
    private LocationListener locationListener;

    public void startRecordingGPS(View view) {
        System.out.println("Start Recording GPS");

        TextView statusText = (TextView) findViewById(R.id.statusText);
        statusText.append("Start Recording GPS\n");
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new MyLocationListener(statusText);
        boolean isGpsPermissionGranted = false;


        isGpsPermissionGranted = (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED);


        if(isGpsPermissionGranted == false) {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_ASK_PERMISSIONS);
            statusText.append("Req Permission for ACCESS FINE LOCATION\n");
            System.out.println("Req Permission");
        }
         else {
            this.disableOrEnableTheButton((Button) findViewById(R.id.startRecordingButton),false);
            //this.disableOrEnableTheButton((Button) findViewById(R.id.),false);
            int minDistance = 0;
            int minTime = 5000;
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime,0,locationListener);
            statusText.append("Location Updates will come " + " Minimum Time: " + minTime + " Minimum Distance: " +  minDistance  + "\n");
            System.out.println("Location Updates will come");






            }
    }

    public void stopRecordingGPS(View view){
        System.out.println("Stop Recording GPS");
        TextView statusText = (TextView) findViewById(R.id.statusText);
        //statusText.setText("Stop Recording GPS");
        statusText.append("Stop Recording GPS\n");
        locationManager.removeUpdates(locationListener);
        locationListener = null;
        locationManager = null;

    }

    private void disableOrEnableTheButton(Button buttonToBeDisabled, boolean enabledTrue){

        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_main);

        for(int i=0; i < layout.getChildCount(); i++){
            View child = layout.getChildAt(i);

            if (child instanceof Button){
                if (buttonToBeDisabled.equals(child)) {
                    child.setEnabled(enabledTrue);
                }
                else {
                    child.setEnabled(!enabledTrue);
                }
            }
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getActionBar();

        Button startRecordingButton = (Button) findViewById(R.id.startRecordingButton);
        Button stopRecordingButton = (Button) findViewById(R.id.stopRecordingButton);
        Button optionsButton = (Button) findViewById(R.id.optionsButton);
        startRecordingButton.setEnabled(true);
        stopRecordingButton.setEnabled(false);
        optionsButton.setEnabled(true);




    }
}
