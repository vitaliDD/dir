package com.example.user.cw1.dz9;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.user.cw1.R;
import com.example.user.cw1.base.BaseActivity;
import com.example.user.cw1.cw9.Cw9Activity;
import com.example.user.cw1.databinding.ActivityCw9Binding;
import com.example.user.cw1.databinding.ActivityDz9Binding;

import java.util.ArrayList;

/**
 * Created by ya on 06.08.2017.
 */

public class Dz9Activity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Dz9ViewModel viewModel=new Dz9ViewModel(this);
        this.viewModel= viewModel;

        ActivityDz9Binding binding= DataBindingUtil.setContentView(this, R.layout.activity_dz9);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
    }


    public static void show(Activity activity){

        Intent intent=new Intent(activity, Dz9Activity.class);
        activity.startActivity(intent);

    }
}
