package com.example.ya.testapp.presenter;

import com.example.ya.testapp.view.OneItemView;

/**
 * Created by ya
 * on 24.11.2017.
 */

public class OneItemPresenter implements OneItemBasePresenter {

    private OneItemView view;

    @Override
    public void attachView(OneItemView view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void showText() {
        view.setText();
    }


}
