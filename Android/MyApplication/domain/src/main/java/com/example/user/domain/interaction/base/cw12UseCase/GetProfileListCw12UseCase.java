package com.example.user.domain.interaction.base.cw12UseCase;


import com.example.user.data.entity.Profile;
import com.example.user.data.entity.cw12Profile;
import com.example.user.data.net.RestService;
import com.example.user.domain.entity.ProfileId;
import com.example.user.domain.entity.ProfileModel;
import com.example.user.domain.entity.cw12ProfileModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetProfileListCw12UseCase extends Cw12UseCase<ProfileId, List<cw12ProfileModel>> {

    @Override
    protected Observable<List<cw12ProfileModel>> buildUseCase(ProfileId param) {
        return RestService.getInstance().getProfiles().map(new Function<List<cw12Profile>, List<cw12ProfileModel>>() {
                    @Override
                    public List<cw12ProfileModel> apply(@NonNull List<cw12Profile> profiles) throws Exception {
                        List<cw12ProfileModel> list = new ArrayList<>();
                        for(cw12Profile profile: profiles) {
                            list.add(convert(profile));
                        }
                        return list;
                    }
                });

    }

    private cw12ProfileModel convert(cw12Profile dataModel) {
        cw12ProfileModel profileModel = new cw12ProfileModel();
        profileModel.setName(dataModel.getName());
        profileModel.setSurname(dataModel.getSurname());
        profileModel.setAge(dataModel.getAge());
        profileModel.setId(dataModel.getId());
        return profileModel;
    }
}
