package com.example.user.cw1.dz10;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.user.cw1.R;
import com.example.user.cw1.base.BaseActivity;
import com.example.user.cw1.databinding.ActivityDz10Binding;


/**
 * Created by ya on 06.08.2017.
 */

public class Dz10Activity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Dz10ViewModel viewModel=new Dz10ViewModel(this);
        this.viewModel= viewModel;

        ActivityDz10Binding binding= DataBindingUtil.setContentView(this, R.layout.activity_dz10);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
    }


    public static void show(Activity activity){

        Intent intent=new Intent(activity, Dz10Activity.class);
        activity.startActivity(intent);

    }
}
