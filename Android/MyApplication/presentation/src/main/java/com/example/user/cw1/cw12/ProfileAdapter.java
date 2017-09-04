package com.example.user.cw1.cw12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user.cw1.base.BaseAdapter;
import com.example.user.cw1.base.BaseItemViewHolder;
import com.example.user.domain.entity.ProfileModel;
import com.example.user.domain.entity.cw12ProfileModel;

/**
 * Created by user on 18.08.2017.
 */
//public class ProfileAdapter extends BaseAdapter<ProfileModel, ProfileItemViewModel> {
//
//    private Context context;
//
//    public ProfileAdapter(Context context) {
//        this.context = context;
//    }
//
//    @Override
//    public BaseItemViewHolder<ProfileModel, ProfileItemViewModel, ?> onCreateViewHolder(ViewGroup parent, int viewType)
//    {
//        ProfileItemViewModel itemViewModel = new ProfileItemViewModel();
//        return  ProfileItemViewHolder.create(LayoutInflater.from(context),
//                parent, itemViewModel);
//    }
//}
public class ProfileAdapter extends BaseAdapter<cw12ProfileModel, ProfileItemViewModel> {

    @Override
    public ProfileItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModel itemViewModel = new ProfileItemViewModel();
        return ProfileItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }
}