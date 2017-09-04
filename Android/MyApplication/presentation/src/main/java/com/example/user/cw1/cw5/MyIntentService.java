package com.example.user.cw1.cw5;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by user on 02.08.2017.
 */
public class MyIntentService extends IntentService {
    public static final String KEY_ACTION="KEY_ACTION";
    public static final String MY_ACTION="com.example.user.cw1.cw5.MY_ACTION";//название события

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e("AAA", "onHandleIntent()" );
        String action = intent.getStringExtra(KEY_ACTION);


        //Log.e("AAA","onHandleIntent() action "+action);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intentReceiver =new Intent(MY_ACTION);
        sendBroadcast(intentReceiver);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("AAA", "onHandleIntent() onDestroy");
    }
}
