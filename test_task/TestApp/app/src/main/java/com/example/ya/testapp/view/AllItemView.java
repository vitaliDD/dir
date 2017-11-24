package com.example.ya.testapp.view;

import com.example.ya.testapp.presenter.entity.MultimediumPresenter;

import java.util.List;

/**
 * Created by ya
 * on 24.11.2017.
 */

public interface AllItemView {

    void dismissProgress();
    void startNewActivity(String item);
    void showError(int error);
    void setAdapter(List<MultimediumPresenter> multPresList);

}
