package com.example.ya.testapp;

import android.app.Application;



import com.example.ya.testapp.di.AppComponent;
import com.example.ya.testapp.di.AppModule;
import com.example.ya.testapp.di.DaggerAppComponent;


/**
 * Created by ya
 * on 24.11.2017.
 */

public class App extends Application {

    public static AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        appComponent= DaggerAppComponent.builder().
                appModule(new AppModule(this))
                .build();
   }
}
