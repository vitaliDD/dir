package com.example.user.cw1;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by ya on 30.07.2017.
 */

public class TestApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
