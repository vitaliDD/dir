package com.example.user.cw1.cw9;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.user.cw1.R;
import com.example.user.cw1.base.BaseActivity;
import com.example.user.cw1.databinding.ActivityCw9Binding;
//import com.example.user.cw1.databinding.ActivityCw8Binding;
//import com.example.user.cw1.databinding.ActivityCw9Binding;

/**
 * Created by user on 09.08.2017.
 */
public class Cw9Activity extends BaseActivity{

    //ObservableField<String> helloText= new ObservableField<>("Uhahahahah");

    public static void show(Activity activity){

        Intent intent=new Intent(activity, Cw9Activity.class);
        activity.startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Cw9BaseViewModel viewModel=new Cw9BaseViewModel(this);
        this.viewModel= viewModel;

        ActivityCw9Binding binding= DataBindingUtil.setContentView(this, R.layout.activity_cw9);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
    }
}
