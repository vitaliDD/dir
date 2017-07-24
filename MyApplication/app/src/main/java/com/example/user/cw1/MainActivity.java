package com.example.user.cw1;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

/**
 * Created by user on 24.07.2017.
 */
public class MainActivity extends Activity  {


    private Button helloButton;
    private Button byeButton;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("newActivity","onCreate");
        helloButton=(Button)findViewById(R.id.helloButton);
        //helloButton.setText("fdf");
        byeButton=(Button)findViewById(R.id.byeButton);

        helloButton.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                i++;
                helloButton.setText("Button "+i);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("newActivity", "onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("newActivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("newActivity", "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("newActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("newActivity", "onPause");
    }


}
