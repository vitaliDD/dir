package com.example.user.domain.interaction.base;

import com.example.user.data.entity.Profile;
import com.example.user.data.net.RestService;
import com.example.user.domain.entity.ProfileModel;
import com.example.user.domain.interaction.base.cw12UseCase.Cw12UseCase;

import io.reactivex.Observable;

/**
 * Created by user on 11.08.2017.
 */
public class SaveProfileUseCase extends Cw12UseCase<ProfileModel, Void> {
    @Override
    protected Observable<Void> buildUseCase(ProfileModel param) {



        //все,что выше удалим, когда реализуем rest


                     Profile profileData=new Profile();
                     //flat, filter,flatMap, subscribeWith - самые частые методы
                     profileData.setName(param.getName());
                     profileData.setSurname(param.getSurname());
                     profileData.setAge(param.getAge());
                     return RestService.getInstance().saveProfile1(profileData);
                 }


}
