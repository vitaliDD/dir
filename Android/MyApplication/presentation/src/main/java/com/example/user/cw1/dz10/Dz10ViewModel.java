package com.example.user.cw1.dz10;

import android.app.Activity;
import android.databinding.ObservableInt;
import android.util.Log;

import com.example.user.cw1.base.BaseViewModel;

import java.util.concurrent.TimeUnit;

//import com.example.user.domain.entity.Profile;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 09.08.2017.
 */
public class Dz10ViewModel implements BaseViewModel {


    public Activity activity;
    private Disposable disposable;
    public ObservableInt  interval=new ObservableInt(0);
    Observable observable;
    public Dz10ViewModel(Activity activity) {
        this.activity = activity;
    }



    @Override
    public void init() {


        disposable= Observable.interval(1, TimeUnit.SECONDS)
                //.filter(aLong1 -> aLong1 % 2 == 0)
               // .filter(new RxJavaPlugins.on)
                //.map(Long::intValue)
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(@NonNull Long aLong) throws Exception {
                        return (int)(long)aLong;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())// куда вернуть данные
                .subscribeOn(Schedulers.newThread())//в каком потоке выполнить
                .subscribeWith(new DisposableObserver<Integer>() {
                    @Override
                    public void onNext(@NonNull Integer integer) {
                        interval.set(integer);
                        Log.e("CCC","onNext");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }); //подписка и запуск

    }

    @Override
    public void release() {



    }

    @Override
    public void resume() {
       // disposable.



    }

    @Override
    public void pause() {
        if (!disposable.isDisposed()) {
            Log.e("CCC","dispose");

            disposable.dispose();

        }
    }


}