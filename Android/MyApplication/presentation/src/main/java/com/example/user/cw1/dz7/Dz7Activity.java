package com.example.user.cw1.dz7;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.user.cw1.R;
import com.example.user.cw1.databinding.ActivityDz7Binding;
import com.squareup.picasso.Picasso;

/**
 * Created by ya on 13.08.2017.
 */

public class Dz7Activity extends Activity {
   // public ObservableField<User> User= new ObservableField<>(new User());


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);
        ActivityDz7Binding binding= DataBindingUtil.setContentView(this, R.layout.activity_dz7);
       // String url="http://mobi.pro-z.net/images/pictures/cartoons_026.jpg";
        String url="https://pp.userapi.com/c622030/v622030761/3d95f/une8N_plRH8.jpg";
        User user=new User(27,"male","Valeriy","Matyloynak",url);
        binding.setUser(user);




    }
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }
}
