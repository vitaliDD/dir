package com.example.user.cw1.cw12;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user.cw1.base.BaseItemViewHolder;
import com.example.user.cw1.databinding.ItemProfileBinding;
import com.example.user.domain.entity.ProfileModel;
import com.example.user.domain.entity.cw12ProfileModel;

/**
 * Created by user on 18.08.2017.
 */
public class ProfileItemViewHolder extends BaseItemViewHolder<cw12ProfileModel,
        ProfileItemViewModel, ItemProfileBinding> {

    public ProfileItemViewHolder(ItemProfileBinding binding,
                                 ProfileItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
    }

    public static ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                               ProfileItemViewModel viewModel) {
        ItemProfileBinding binding = ItemProfileBinding.inflate(inflater, parent, false);
        return new ProfileItemViewHolder(binding, viewModel);
    }
}