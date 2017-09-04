package com.example.user.cw1.dz5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by ya on 06.08.2017.
 */

public class dz5Service extends Service {
    private BroadcastReceiver receiver;
    private  boolean WIFI_FLAG = false;;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("FUCK", "Запустили Service");
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        receiver= new BroadcastReceiver () {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e("FUCK", "Запустили HomeWorkBroadCastReciever");
                WifiManager manager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                int number = manager.getWifiState();
                switch (number) {
                    case WifiManager.WIFI_STATE_DISABLED:
                        Log.e("FUCK", "Вот в чем: WIFI_STATE_DISABLED");
                        WIFI_FLAG = false;
                        //  Intent sendMessageFalse = new Intent();
                        //  sendMessageFalse.putExtra(Activity_HomeWork05.FLAG, false);
                        //  sendBroadcast(sendMessageFalse);
                        Log.e("FUCK", "FLAG IS"+WIFI_FLAG);

//                        Toast toast = new Toast(getApplicationContext());
//                       // toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//                        toast.setDuration(Toast.LENGTH_LONG);
//                        toast.setText("Wi-FI выключен");
//                        toast.show();
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Wi-FI OFF", Toast.LENGTH_SHORT);
                        toast.show();
                        break;

                    case WifiManager.WIFI_STATE_ENABLED:
                        Log.e("FUCK", "Вот в чем: WIFI_STATE_ENABLED");
                        WIFI_FLAG = true;
                        // Intent sendMessageTrue = new Intent();
                        //  sendMessageTrue.putExtra(Activity_HomeWork05.FLAG, true);
                        // sendBroadcast(sendMessageTrue);
                        Log.e("FUCK", "FLAG IS "+WIFI_FLAG);

                        Toast toast2 = Toast.makeText(getApplicationContext(),
                                "Wi-FI ON", Toast.LENGTH_SHORT);
                        toast2.show();
                        break;
                }
            }


        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(receiver, intentFilter);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        Log.e("FUCK", "УБИЛИ Service");
    }
}


