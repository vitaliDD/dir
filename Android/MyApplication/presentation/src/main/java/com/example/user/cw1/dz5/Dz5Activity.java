package com.example.user.cw1.dz5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.user.cw1.R;
import com.example.user.cw1.cw5.MyIntentService;

/**
 * Created by ya on 05.08.2017.
 */

public class Dz5Activity extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz5);
        startService(new Intent(this,dz5Service.class));

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(new Intent(this,dz5Service.class));
    }
}
