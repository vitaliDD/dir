package com.example.user.cw1.cw8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.user.cw1.R;
import com.example.user.cw1.base.BaseActivity;
import com.example.user.cw1.databinding.ActivityCw8Binding;

/**
 * Created by user on 09.08.2017.
 */
public class Cw8Activity extends BaseActivity{

    //ObservableField<String> helloText= new ObservableField<>("Uhahahahah");

    public static void show(Activity activity){

        Intent intent=new Intent(activity, Cw8Activity.class);
        activity.startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Cw8ViewModel viewModel=new Cw8ViewModel(this);
        this.viewModel= viewModel;

        ActivityCw8Binding binding= DataBindingUtil.setContentView(this, R.layout.activity_cw8);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
    }
}
