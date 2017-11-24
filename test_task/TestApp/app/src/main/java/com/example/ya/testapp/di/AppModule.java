package com.example.ya.testapp.di;

import android.content.Context;

import com.example.ya.testapp.presenter.interaction.UseCaseGetListCar;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ya
 * on 11.09.2017.
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext(){

        return context;

    }

    @Provides
    public UseCaseGetListCar useCaseGetListCar(){

        return new UseCaseGetListCar();

    }


}
