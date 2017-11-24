package com.example.ya.testapp.presenter.interaction;

import com.example.ya.testapp.model.entity.JsonNYT;
import com.example.ya.testapp.model.net.RestService;
import com.example.ya.testapp.presenter.entity.MultimediumPresenter;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by user on 11.08.2017.
 */
public class UseCaseGetListCar extends UseCase<Void, List<MultimediumPresenter>> {


    @Override
    protected Observable<List<MultimediumPresenter>> builtUseCase(Void aVoid) {
        return RestService.getInstance().getJsonNYT()
                .map(new Function<JsonNYT, List<MultimediumPresenter>>() {
                    @Override
                    public List<MultimediumPresenter> apply(@NonNull JsonNYT listNYT) throws Exception {
                        List<MultimediumPresenter> listMultPres = new ArrayList<>();
                        for (int i = 0; i < 20; i++) {
                            MultimediumPresenter multPres = new MultimediumPresenter();
                            multPres.setUrl(listNYT.getResults().get(i).getMultimedia().get(4).getUrl());
                            multPres.setCaption(listNYT.getResults().get(i).getMultimedia().get(4).getCaption());
                            multPres.setCopyright(listNYT.getResults().get(i).getMultimedia().get(4).getCopyright());
                            listMultPres.add(multPres);
                        }
                        return listMultPres;
                    }
                });

    }
}
