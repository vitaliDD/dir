package com.example.user.domain.interaction.base;


import com.example.user.domain.entity.ProfileModel;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
//import io.reactivex.android.schedulers.AndroidSchedulers;


/**
 * Created by user on 11.08.2017.
 */
abstract  public class UseCase<InParam, OutParam> {

    private Disposable disposable;
    protected  abstract Observable<OutParam> buildUseCase(InParam param);


    public ProfileModel execute(InParam param, DisposableObserver<OutParam> disposableObserver){
        disposable=buildUseCase(param)
                .observeOn(AndroidSchedulers.mainThread())// куда вернуть данные
                .subscribeOn(Schedulers.newThread())//в каком потоке выполнить
                .subscribeWith(disposableObserver); //подписка и запуск


        return null;
    }
    public void dispose(){

        if(!disposable.isDisposed()){

            disposable.dispose();

        }

    }


}
