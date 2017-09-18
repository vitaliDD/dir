package com.doschechko.matylionak.wcguide.maps;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doschechko.matylionak.wcguide.R;
import com.doschechko.matylionak.wcguide.base.BaseFragment;
import com.doschechko.matylionak.wcguide.databinding.ActivityItemWcBinding;


public class Activity_Item_WC extends BaseFragment {


    public Activity_Item_WC() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Activity_Item_WC_ViewModel viewModel= new Activity_Item_WC_ViewModel();
        this.viewModel=viewModel;
        viewModel.setActivity(this);
        ActivityItemWcBinding binding  = DataBindingUtil.inflate(
                inflater, R.layout.activity_item_wc, container, false);
        binding.setViewModel(viewModel);
        View view = binding.getRoot();

        return view;
    }



}
