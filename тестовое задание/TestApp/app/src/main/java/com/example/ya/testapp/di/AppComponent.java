package com.example.ya.testapp.di;

import com.example.ya.testapp.presenter.AlllItemPresenter;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by ya
 * on 11.09.2017.
 */
@Component(modules={AppModule.class})
@Singleton
public interface AppComponent {

    //связующее звено между аннотацией Inject и Dagger2(класс AppModule)

    public void inject(AlllItemPresenter presenter);

}
