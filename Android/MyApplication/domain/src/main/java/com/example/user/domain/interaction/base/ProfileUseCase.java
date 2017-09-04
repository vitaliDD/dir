package com.example.user.domain.interaction.base;

//import com.example.user.data.entity.Profile;
import com.example.user.data.entity.Profile;
import com.example.user.data.net.RestService;
import com.example.user.domain.entity.ProfileId;
import com.example.user.domain.entity.ProfileModel;
//import com.example.user.domain.entity.ProfileModel;
//import com.example.user.domain.entity.ProfileId;


import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by user on 11.08.2017.
 */
public class ProfileUseCase extends UseCase<ProfileId, ProfileModel> {

    @Override
    protected Observable<ProfileModel> buildUseCase(ProfileId param) {

        return RestService.getInstance().getProfiles1()
             .map(new Function<List<Profile>, ProfileModel>() {
                 @Override
                 public ProfileModel apply(List<Profile> profileList) throws Exception {
                     Profile profileData=profileList.get(2);
                     //flat, filter,flatMap, subscribeWith - самые частые методы
                     ProfileModel profileModel = new ProfileModel();
                     profileModel.setName(profileData.getName());
                     profileModel.setSurname(profileData.getSurname());
                     profileModel.setAge(profileData.getAge());
                     return profileModel;
                 }
             });
    }
}
