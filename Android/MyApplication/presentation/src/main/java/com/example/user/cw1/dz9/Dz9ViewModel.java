package com.example.user.cw1.dz9;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.example.user.cw1.R;
import com.example.user.cw1.base.BaseViewModel;
//import com.example.user.domain.entity.Profile;
import com.example.user.cw1.databinding.ActivityDz9Binding;
import com.example.user.cw1.dz6.Dz6Activity;
import com.example.user.cw1.dz6.Dz6Adapter;
import com.example.user.domain.entity.ProfileId;
import com.example.user.domain.entity.dz9Entity.LinkModel;
import com.example.user.domain.interaction.base.ProfileUseCase;
import com.example.user.domain.interaction.base.dz9Base.LinkUseCase;

import java.util.ArrayList;

/**
 * Created by user on 09.08.2017.
 */
public class Dz9ViewModel implements BaseViewModel {

    private LinkUseCase linkUseCase=new LinkUseCase();
    private RecyclerView recyclerView;
    public Activity activity;
    //public ObservableArrayList<ArrayList<String>> stringArrayList= new ObservableArrayList<>();
    public ArrayList<String> stringArrayList= new ArrayList<>();
    public Dz9ViewModel(Activity activity) {
        this.activity = activity;
    }
//   public enum STATE {PROGRESS, DATA}

    @Override
    public void init() {

    }

    @Override
    public void release() {



    }

    @Override
    public void resume() {

        LinkModel linkModel=linkUseCase.execute();
        stringArrayList=(ArrayList<String>)linkModel.getStringArrayList().clone();

        ActivityDz9Binding binding = DataBindingUtil.setContentView(activity,R.layout.activity_dz9);

        //recyclerView = (RecyclerView) activity.findViewById(R.id.dz9recyclerView);
        recyclerView=binding.dz9recyclerView;
        GridLayoutManager gridLayoutManager= new GridLayoutManager(activity,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        Dz9Adapter adapter=new Dz9Adapter(stringArrayList,activity);
        recyclerView.setAdapter(adapter);
//        state.set(STATE.DATA);

    }

    @Override
    public void pause() {

    }


}