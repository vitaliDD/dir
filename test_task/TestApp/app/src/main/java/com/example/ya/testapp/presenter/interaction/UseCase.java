package com.example.ya.testapp.presenter.interaction;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Общий интерфейс для всех UseCase который выполняется в другом потоке
 */

public abstract class UseCase<InParam, OutParam> {
    private Disposable disposable;

    //подписываемся
    protected abstract Observable<OutParam> builtUseCase(InParam param);

    public void execute(InParam param, DisposableObserver<OutParam> disposableObserver) {
        disposable = builtUseCase(param)
                .observeOn(AndroidSchedulers.mainThread()) //куда возвращается
                .subscribeOn(Schedulers.newThread()) //где выполняется
                .subscribeWith(disposableObserver);
    }

    //отписываемся
    public void dispose() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}
