package com.example.user.cw1.cw9;

import android.app.Activity;


import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.example.user.cw1.base.BaseViewModel;
import com.example.user.domain.entity.ProfileModel;
import com.example.user.domain.entity.ProfileId;
import com.example.user.domain.interaction.base.ProfileUseCase;
import com.example.user.domain.interaction.base.SaveProfileUseCase;

import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by user on 09.08.2017.
 */
public class Cw9BaseViewModel implements BaseViewModel {





    public enum STATE {PROGRESS, DATA}
    public Activity activity;
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableInt age = new ObservableInt(0);
    public ObservableField<STATE> state= new ObservableField<>(STATE.PROGRESS);
    public Cw9BaseViewModel(Activity activity) {
        this.activity = activity;
    }
    private ProfileUseCase useCase= new ProfileUseCase();
    private SaveProfileUseCase saveProfileUseCase=new SaveProfileUseCase();

    @Override
    public void init() {

    }

    @Override
    public void release() {



    }

    @Override
    public void resume() {
        ProfileId profileId= new ProfileId();
        profileId.setId("123");

        ProfileModel profileModel= new ProfileModel();
        profileModel.setAge(119);
        profileModel.setName("Ishlanbek");
        profileModel.setSurname("Mamedov");


//        saveProfileUseCase.execute(profileModel, new DisposableObserver<Void>() {
//            @Override
//            public void onNext(Void aVoid) {
//                Log.e("AAA","OK");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e("AAAA items = ", e.toString());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e("AAAA item", "onComplete");
//
//            }
//        });


        ProfileModel profile= useCase.execute(profileId, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(ProfileModel profile) {//если все хорошо, то сюда получаем
                name.set(profile.getName());
                surname.set(profile.getSurname());
                age.set(profile.getAge());
                state.set(STATE.DATA);



            }

            @Override
            public void onError(Throwable e) {
                Log.e("AAA", "error =", e);


            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void pause() {

        useCase.dispose();
       //saveProfileUseCase.dispose();
    }


}