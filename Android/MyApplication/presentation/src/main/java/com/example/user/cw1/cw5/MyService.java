package com.example.user.cw1.cw5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by user on 02.08.2017.
 */

//service - фоновый процесс
public class MyService extends Service{


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("AAA", "onCreate");
        //stopSelf(); сам себя остановить
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {//
        Log.e("AAA", "onBind");
        return null;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("AAA", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("AAA", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("AAA", "onDestroy");
    }
}
