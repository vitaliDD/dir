package com.example.user.cw1.cw12;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.user.cw1.R;
import com.example.user.cw1.base.BaseActivity;
import com.example.user.cw1.databinding.ItemProfileFullBinding;


/**
 * Created by ya on 31.08.2017.
 */

public class cw12ProfileFullItemActivity extends BaseActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("qwe","cw12ProfileFullItemActivity  ocCreate");
        Intent intent = getIntent();
        String id = intent.getStringExtra("ID");
        Log.e("qwe","ocCreate id = "+id);
        ItemProfileFullBinding binding=DataBindingUtil.setContentView(this,R.layout.item_profile_full);
        ProfileFullItemViewModel viewModel = new ProfileFullItemViewModel(id,binding,this);
       // ProfileFullItemViewModel viewModel = new ProfileFullItemViewModel(id);


        this.viewModel= viewModel;
        //ActivityCw12Binding binding= DataBindingUtil.setContentView(this, R.layout.activity_cw12);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);






    }
}
