package com.doschechko.matylionak.wcguide.maps;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doschechko.matylionak.wcguide.R;
import com.doschechko.matylionak.wcguide.base.BaseFragment;
import com.doschechko.matylionak.wcguide.databinding.ActivityMapsBinding;

public class Activity_Maps extends BaseFragment {

// implements  OnMapReadyCallback
    public Activity_Maps() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Activity_MapsViewModel viewModel= new Activity_MapsViewModel();
        this.viewModel=viewModel;
        viewModel.setActivity(this);
        ActivityMapsBinding binding= DataBindingUtil.inflate(inflater, R.layout.activity_maps,container,false);
        View mView = binding.getRoot();
        binding.setViewModel(viewModel);

        return mView;
    }

}
