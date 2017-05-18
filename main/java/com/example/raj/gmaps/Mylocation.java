package com.example.raj.gmaps;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by raj on 3/13/2017.
 */

public class Mylocation extends Activity implements LocationListener {

    LocationManager manager;
    LocationListener locationListener;



    double lat,lng;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylocation);



        manager = (LocationManager) getSystemService(getApplicationContext().LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        sendlocatoin();


    }

    @Override
    public void onLocationChanged(Location location) {
        //tv.setText("Latitude:"+location.getLatitude()+"\n"+"Longitude:"+location.getLongitude());
        lat = location.getLatitude();
        lng = location.getLongitude();


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }






    public void sendlocatoin(){

       /* Bundle basket = new Bundle();
        basket.putDouble("lat",lat);
        basket.putDouble("lng",lng);*/
        Toast.makeText(Mylocation.this, lat+"king"+lng, Toast.LENGTH_SHORT).show();
       /* Intent a = new Intent(Mylocation.this,MapsActivity.class);
        a.putExtras(basket);
        startActivity(a);
        finish();*/
    }


}
