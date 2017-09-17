package com.doschechko.matylionak.wcguide.maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doschechko.matylionak.wcguide.R;
import com.doschechko.matylionak.wcguide.base.BaseFragment;
import com.doschechko.matylionak.wcguide.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Activity_Maps extends BaseFragment{

// implements  OnMapReadyCallback
    public Activity_Maps() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Activity_MapsViewModel viewModel= new Activity_MapsViewModel();
        this.viewModel=viewModel;
        viewModel.setActivity(this);


        ActivityMapsBinding binding= DataBindingUtil.inflate(inflater,R.layout.activity_maps,container,false);
        View mView = binding.getRoot();


        //mView = inflater.inflate(R.layout.activity_maps, container, false);

//        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
//       // SupportMapFragment mapFragment =this.getChildFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
        binding.setViewModel(viewModel);

        return mView;
    }

}
