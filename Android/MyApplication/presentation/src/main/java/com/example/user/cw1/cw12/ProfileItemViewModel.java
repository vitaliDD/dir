package com.example.user.cw1.cw12;

import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.example.user.cw1.base.BaseItemViewHolder;
import com.example.user.cw1.base.BaseItemViewModel;
import com.example.user.domain.entity.ProfileModel;
import com.example.user.domain.entity.cw12ProfileModel;

import java.util.Observable;

/**
 * Created by user on 18.08.2017.
 */
public class ProfileItemViewModel extends BaseItemViewModel<cw12ProfileModel> {

    public ObservableField<String> name= new ObservableField<>("");
   // public ObservableField<String> id= new ObservableField<>("");
    String id;

    @Override
    public void setItem(cw12ProfileModel item, int position) {
        Log.e("AAA", "ITEM " + position);
        Log.e("AAA", "ITEM name " + item.getName());
        name.set(item.getName());
        //id.set(item.getId());
        id=item.getId();
        Log.e("qwe", "setItem "+item.getId());

    }
    public void onClick(View view){
        Log.e("qwe", "click "+id);
        Intent intent = new Intent(view.getContext(),cw12ProfileFullItemActivity.class);
        intent.putExtra("ID", id);
        view.getContext().startActivity(intent);






    }
}
