package com.example.user.cw1;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by user on 24.07.2017.
 */
public class MainActivity extends Activity implements View.OnClickListener {


    private Button helloButton;
    private TextView text1;
    private TextView text2;
    String strChange;
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeText();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("newActivity","onCreate");
        helloButton=(Button)findViewById(R.id.helloButton);
        text1=(TextView) findViewById(R.id.text1);
        text2=(TextView) findViewById(R.id.text2);

        text1.setOnClickListener(onClickListener);
        text2.setOnClickListener(this);
        helloButton.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                changeText();
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


    @Override
    public void onClick(View v) {
       changeText();
    }

    private void changeText(){

        strChange=(String)text1.getText();
        text1.setText(text2.getText());
        text2.setText(strChange);

    }
}
