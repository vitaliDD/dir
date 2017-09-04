package com.example.user.cw1.cw7;


import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;


import com.example.user.cw1.R;
import com.example.user.cw1.databinding.ActivityCw7Binding;

import java.util.Observable;

/**
 * Created by user on 07.08.2017.
 */
public class Cw7Activity extends Activity {
    public ObservableField<String> myText=new ObservableField<>("Ura, nichego ne rabotaet!");
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCw7Binding binding= DataBindingUtil.setContentView(this, R.layout.activity_cw7);
        binding.setActivity(this);
        binding.superTextView.setText("fjdskjfs");

        //setContentView(R.layout.activity_cw7);
    }

    @Override
    protected void onResume() {
        super.onResume();
        thread=new Thread(new Runnable() {
            @Override
            public void run() {


                for(int i=0;i<3;i++){
                    final int a=i;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            myText.set(String.valueOf(a));
                        }
                    });


                }
            }
        });

        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
