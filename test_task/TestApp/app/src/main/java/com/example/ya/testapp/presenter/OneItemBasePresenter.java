package com.example.ya.testapp.presenter;

import com.example.ya.testapp.view.OneItemView;

/**
 * Created by ya
 * on 24.11.2017.
 */

public interface OneItemBasePresenter {
    void attachView(OneItemView view);
    void showText();
    void detachView();

}
