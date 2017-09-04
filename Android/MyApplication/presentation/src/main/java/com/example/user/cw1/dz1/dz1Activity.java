package com.example.user.cw1.dz1;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.cw1.R;

/**
 * Created by user on 24.07.2017.
 */
public class dz1Activity extends Activity implements View.OnClickListener {

    public static final String KEY_USERNAME="KEY_USERNAME" ;
    public static final String KEY_PASSWORD="KEY_PASSWORD" ;
    private Button helloButton;
    private TextView textView1;
    private TextView textView2;
    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textChange();
        }
    } ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz1);
        Log.d("newActivity","onCreate");
        helloButton=(Button)findViewById(R.id.helloButton);
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(onClickListener);
        String username= getIntent().getStringExtra(KEY_USERNAME);
        String password= getIntent().getStringExtra(KEY_PASSWORD);
        if(!username.equals(""))
        textView1.setText(username);
        if(!password.equals(""))
        textView2.setText(password);
        helloButton.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                textChange();
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
        textChange();

    }

    private void textChange(){

        CharSequence temp=textView1.getText();
        textView1.setText(textView2.getText());
        textView2.setText(temp);

    }
}
