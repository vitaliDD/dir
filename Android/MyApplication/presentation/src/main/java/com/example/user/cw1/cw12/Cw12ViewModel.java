package com.example.user.cw1.cw12;

import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.user.cw1.base.BaseViewModel;
import com.example.user.data.entity.Profile;
import com.example.user.domain.entity.ProfileId;
import com.example.user.domain.entity.ProfileModel;
import com.example.user.domain.entity.cw12ProfileModel;
import com.example.user.domain.interaction.base.cw12UseCase.GetProfileListCw12UseCase;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by user on 09.08.2017.
 */
public class Cw12ViewModel implements BaseViewModel {
    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state= new ObservableField<>(STATE.PROGRESS);
    private Activity activity;

    private GetProfileListCw12UseCase getProfileListUseCase=new GetProfileListCw12UseCase();
    public ProfileAdapter adapter=new ProfileAdapter();

    Cw12ViewModel(Activity activity){

        this.activity=activity;

    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        getProfileListUseCase.execute(null, new DisposableObserver<List <cw12ProfileModel>>(){

            @Override
            public void onNext(List< cw12ProfileModel> profileModels) {
                adapter.setItems(profileModels);
                state.set(STATE.DATA);
                Log.e("AAAA items = " + profileModels.size(),"");

            }

            @Override
            public void onError(Throwable e) {
                Log.e("AAA","error_cw12 = ",e);
            }

            @Override
            public void onComplete() {
            }
        });

    }

    @Override
    public void pause() {
        getProfileListUseCase.dispose();

//        useCase.dispose();
//        saveProfileUseCase.dispose();
    }


}