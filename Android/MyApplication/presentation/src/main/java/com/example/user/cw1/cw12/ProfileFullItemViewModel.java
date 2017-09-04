package com.example.user.cw1.cw12;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.user.cw1.base.BaseFullItemViewModel;
import com.example.user.cw1.base.BaseViewModel;
import com.example.user.cw1.databinding.ItemProfileFullBinding;
import com.example.user.domain.entity.ProfileId;
import com.example.user.domain.entity.cw12ProfileModel;
import com.example.user.domain.interaction.base.cw12UseCase.GetProfileCw12UseCase;
import com.example.user.domain.interaction.base.cw12UseCase.SaveProfileCw12UseCase;
import com.example.user.domain.interaction.base.cw12UseCase.UpdateProfileCw12UseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by ya on 30.08.2017.
 */

public class ProfileFullItemViewModel implements BaseViewModel {

    ObservableField<String> name = new ObservableField<>("");
    ObservableField<String> surname = new ObservableField<>("");
    ObservableInt age = new ObservableInt(0);
    ObservableField<String> editFlag=new ObservableField<>("gone");
    ProfileId id = new ProfileId();
    Activity activity;
    ItemProfileFullBinding binding;
    cw12ProfileModel cw12ProfileModel=new cw12ProfileModel();
    GetProfileCw12UseCase getProfileCw12UseCase = new GetProfileCw12UseCase();
    SaveProfileCw12UseCase saveProfileCw12UseCase = new SaveProfileCw12UseCase();
    UpdateProfileCw12UseCase updateProfileCw12UseCase=new UpdateProfileCw12UseCase();


    public ProfileFullItemViewModel(String id, ItemProfileFullBinding binding, Activity  activity) {
        this.id.setId(id);
        this.binding=binding;
        this.activity=activity;
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<String> getEditFlag() {
        return editFlag;
    }

    public void setEditFlag(ObservableField<String> editFlag) {
        this.editFlag = editFlag;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableField<String> getSurname() {
        return surname;
    }

    public void setSurname(ObservableField<String> surname) {
        this.surname = surname;
    }

    public ObservableInt getAge() {
        return age;
    }

    public void setAge(ObservableInt age) {
        this.age = age;
    }


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

        getProfileCw12UseCase.execute(id, new DisposableObserver<cw12ProfileModel>() {
            @Override
            public void onNext(@NonNull cw12ProfileModel cw12ProfileModel) {
                name.set(cw12ProfileModel.getName());
                surname.set(cw12ProfileModel.getSurname());
                age.set(cw12ProfileModel.getAge());
                fillProfileModel();
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void pause() {
        getProfileCw12UseCase.dispose();
        saveProfileCw12UseCase.dispose();

    }

    public void onEditUpdateClick(View view) {
        Log.e("qwe", "onUpdateClick " + id);

        Log.e("qwe", "onEditUpdateClick " + name.get()+" "+surname.get()+" "+age.get());

        updateProfileCw12UseCase.execute(cw12ProfileModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.e("qqqq", "onError updateProfileCw12UseCase " + e);


            }

            @Override
            public void onComplete() {

            }
        });

        Toast.makeText(activity,"UPDATE this note with "+name.get() +" "+surname.get()+" "+age.get(),Toast.LENGTH_LONG).show();



    }

    public void onSetEnableClick(View view){
        setEn();


      //  binding.buttonEdit.setText("update this");



    }
    public void onAddClick(View view) {
        Log.e("qwe", "onAddClick ");
        fillProfileModel();
        Log.e("qwe", "onAddClick " + name.get()+" "+surname.get()+" "+age.get());
        saveProfileCw12UseCase.execute(cw12ProfileModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("qqqq", "onError saveProfileCw12UseCase " + e);
            }

            @Override
            public void onComplete() {

            }
        });
        Toast.makeText(activity,"ADD "+name.get() +" "+surname.get()+" "+age.get(),Toast.LENGTH_LONG).show();


    }
    private void fillProfileModel(){

        cw12ProfileModel.setAge(age.get());
        cw12ProfileModel.setName(name.get());
        cw12ProfileModel.setSurname(surname.get());
        cw12ProfileModel.setId(id.getId());


    }
    public void setEn(){
        binding.editTextAge.setEnabled(true);
        binding.editTextName.setEnabled(true);
        binding.editTextSurname.setEnabled(true);

    }
    public void setDis(){
        binding.editTextAge.setEnabled(false);
        binding.editTextName.setEnabled(false);
        binding.editTextSurname.setEnabled(false);

    }


}