package com.example.user.domain.interaction.base.cw12UseCase;

//import com.example.user.data.entity.Profile;

import com.example.user.data.entity.Profile;
import com.example.user.data.entity.cw12Profile;
import com.example.user.data.net.RestService;
import com.example.user.domain.entity.ProfileId;
import com.example.user.domain.entity.ProfileModel;
import com.example.user.domain.entity.cw12ProfileModel;
import com.example.user.domain.interaction.base.UseCase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

//import com.example.user.domain.entity.ProfileModel;
//import com.example.user.domain.entity.ProfileId;

/**
 * Created by user on 11.08.2017.
 */
public class GetProfileCw12UseCase extends Cw12UseCase<ProfileId, cw12ProfileModel> {

    @Override
    protected Observable<cw12ProfileModel> buildUseCase(ProfileId param) {

        return RestService.getInstance().getProfile(param.getId())
             .map(new Function<cw12Profile, cw12ProfileModel>() {
                 @Override
                 public cw12ProfileModel apply(cw12Profile profileData) throws Exception {
                     //cw12Profile profileData=new cw12Profile();
                     //flat, filter,flatMap, subscribeWith - самые частые методы
                     cw12ProfileModel profileModel = new cw12ProfileModel();
                     profileModel.setName(profileData.getName());
                     profileModel.setSurname(profileData.getSurname());
                     profileModel.setAge(profileData.getAge());
                     return profileModel;
                 }
             });
    }
}
