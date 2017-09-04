package com.example.user.cw1.cw13;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.example.user.cw1.R;

/**
 * Created by user on 21.08.2017.
 */
public class Cw13Activity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw13);

       if(savedInstanceState==null) {
           showFragment(getSupportFragmentManager(),new Cw13Fragment(),false);
       }

        Button button1=(Button)findViewById(R.id.cw13Button1);
        Button button2=(Button)findViewById(R.id.cw13Button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(),Cw13Fragment.newInstance(getSupportFragmentManager(),"fdfsf"),false);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(),new Cw13SecondFragment(),true);

            }
        });
    }
    public static void showFragment(FragmentManager fragmentManager,Fragment fragment, boolean addToBackStack){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
       // Cw13Fragment fragment= new Cw13Fragment();
        //fragment.getClass().getName()- вместо уникального флага фрагмента
        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getName());
        if(addToBackStack) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
