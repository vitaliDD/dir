package com.doschechko.matylionak.wcguide.maps;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import com.doschechko.matylionak.wcguide.R;
import com.doschechko.matylionak.wcguide.base.BaseFragmentViewModel;
import com.doschechko.matylionak.wcguide.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by ya on 08.09.2017.
 */

public class Activity_MapsViewModel implements BaseFragmentViewModel, OnMapReadyCallback{


    Activity_Maps activity;
    private ActivityMapsBinding binding;


    public void setBinding(ActivityMapsBinding binding) {
        this.binding = binding;
    }

    public void setActivity(Activity_Maps activity) {
        this.activity = activity;
    }

    @Override
    public void init() {


        SupportMapFragment mapFragment = (SupportMapFragment) activity.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void release() {

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
       // MapsInitializer.initialize(activity.getContext());

        //this.googleMap = googleMap;
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        if (ActivityCompat.checkSelfPermission(activity.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(activity.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            return;
        }
        googleMap.setMyLocationEnabled(true);
        googleMap.setMapType(com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL);


        LatLng freeWC = new LatLng(53.852688, 27.466705);
        googleMap.addMarker(new MarkerOptions().position(freeWC).title("Free WC, app. 117"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(freeWC,10));

    }
}
