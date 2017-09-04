package com.example.user.domain.interaction.base.cw12UseCase;

import com.example.user.data.entity.Profile;
import com.example.user.data.entity.cw12Profile;
import com.example.user.data.net.RestService;
import com.example.user.domain.entity.ProfileModel;
import com.example.user.domain.entity.cw12ProfileModel;

import io.reactivex.Observable;

/**
 * Created by user on 11.08.2017.
 */
public class SaveProfileCw12UseCase extends Cw12UseCase<cw12ProfileModel, Void> {
    @Override
    protected Observable<Void> buildUseCase(cw12ProfileModel param) {



        //все,что выше удалим, когда реализуем rest


                     cw12Profile profileData=new cw12Profile();
                     //flat, filter,flatMap, subscribeWith - самые частые методы
                     profileData.setName(param.getName());
                     profileData.setSurname(param.getSurname());
                     profileData.setAge(param.getAge());
                     return RestService.getInstance().saveProfile(profileData);
                 }


}
