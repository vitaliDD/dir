package com.example.user.cw1.cw12;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.user.cw1.R;
import com.example.user.cw1.base.BaseActivity;
import com.example.user.cw1.databinding.ActivityCw12Binding;
//import com.example.user.cw1.databinding.ActivityCw8Binding;
import com.example.user.cw1.databinding.ActivityCw12Binding;

/**
 * Created by user on 09.08.2017.
 */
public class Cw12Activity extends BaseActivity{
    //ObservableField<String> helloText= new ObservableField<>("Uhahahahah");
    private String id="";

    public static void show(Activity activity){

        Intent intent=new Intent(activity, Cw12Activity.class);
        activity.startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Cw12ViewModel viewModel=new Cw12ViewModel(this);
        this.viewModel= viewModel;
        ActivityCw12Binding binding= DataBindingUtil.setContentView(Cw12Activity.this, R.layout.activity_cw12);
        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);

        super.onCreate(savedInstanceState);
    }
}
