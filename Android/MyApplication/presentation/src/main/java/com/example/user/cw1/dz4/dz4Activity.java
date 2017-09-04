package com.example.user.cw1.dz4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.cw1.R;

import java.util.Calendar;

/**
 * Created by ya on 01.08.2017.
 */

public class dz4Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz4);
        TextView TextView=(TextView) findViewById(R.id.dz4TextView);
        ImageView imageView=(ImageView) findViewById(R.id.dz4ImageView);
        imageView.setBackgroundResource(R.drawable.sova);
        AnimationDrawable animationDrawable=(AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
        Calendar calendar=Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int hour = calendar.get(Calendar.HOUR);
        int mins = calendar.get(Calendar.MINUTE);
        TextView.setText(Integer.toString(hour)+ " "+Integer.toString(mins));

    }
}
