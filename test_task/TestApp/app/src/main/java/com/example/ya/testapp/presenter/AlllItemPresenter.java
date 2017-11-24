package com.example.ya.testapp.presenter;

import com.example.ya.testapp.App;
import com.example.ya.testapp.R;
import com.example.ya.testapp.presenter.entity.MultimediumPresenter;
import com.example.ya.testapp.presenter.interaction.UseCaseGetListCar;
import com.example.ya.testapp.view.AllItemView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.observers.DisposableObserver;


public class AlllItemPresenter implements AlllItemBasePresenter {


    private AllItemView view;
    @Inject
    UseCaseGetListCar useCaseGetListCar;
    private ArrayList<MultimediumPresenter> multPresList;

    //ролучаем данные
    @Override
    public void getList() {
        multPresList = new ArrayList<>();
        useCaseGetListCar.execute(null, new DisposableObserver<List<MultimediumPresenter>>() {
            @Override
            public void onNext(List<MultimediumPresenter> multimediumPresenters) {
                multPresList.addAll(multimediumPresenters);
            }

            @Override
            public void onError(Throwable e) {
                view.showError(R.string.error);
            }

            @Override
            public void onComplete() {
                view.dismissProgress();
                view.setAdapter(multPresList);
            }
        });

    }

    //отписка
    @Override
    public void onPause() {
        if (useCaseGetListCar != null) {
            useCaseGetListCar.dispose();
        }
    }

    @Override
    public void onItemClick(String item) {
        view.startNewActivity(item);
    }

    @Override
    public void attachView(AllItemView view) {
        this.view = view;
        App.appComponent.inject(this);
    }

    @Override
    public void detachView() {
        view = null;
    }
}
