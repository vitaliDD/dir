package com.example.ya.testapp.presenter;

import com.example.ya.testapp.view.AllItemView;

/**
 * Created by ya
 * on 24.11.2017.
 */

public interface AlllItemBasePresenter {

    void getList();
    void onPause();
    void onItemClick(String item);
    void attachView(AllItemView view) ;
    void detachView();

}
