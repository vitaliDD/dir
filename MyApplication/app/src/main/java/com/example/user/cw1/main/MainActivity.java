package com.example.user.cw1.main;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.cw1.R;
import com.example.user.cw1.cw2.cw2Activity;
import com.example.user.cw1.cw3.cw3Activity;
import com.example.user.cw1.dz1.dz1Activity;
import com.example.user.cw1.dz2.dz2Activity;
import com.example.user.cw1.dz3.dz3Activity;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by user on 26.07.2017.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button dz1Button =(Button) findViewById(R.id.dz1Button);
        final Button dz2Button =(Button) findViewById(R.id.dz2Button);
        final Button dz3Button =(Button) findViewById(R.id.dz3Button);
        final Button cw3Button =(Button) findViewById(R.id.cw3Button);
        final Button cw2Button =(Button) findViewById(R.id.cw2Button);

        dz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this,cw2Activity.class);
                startActivity(intent);
            }
        });
        dz2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this,dz2Activity.class);
                startActivity(intent);
            }
        });
        dz3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this,dz3Activity.class);
                startActivity(intent);
            }
        });


        cw3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,cw3Activity.class);
                startActivity(intent);
            }
        });
        cw2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,cw2Activity.class);
                startActivity(intent);
            }
        });
    }
}
