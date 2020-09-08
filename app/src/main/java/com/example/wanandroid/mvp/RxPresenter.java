package com.example.wanandroid.mvp;

import android.content.Context;
import android.os.Bundle;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class RxPresenter<T extends BaseView> implements Presenter<T> {

    protected final CompositeSubscription subscriptions = new CompositeSubscription();
    protected T baseView;
    protected Context context;


    @Override
    public void attach(T view) {
        this.baseView = view;
    }

    @Override
    public void restoreInstanceState(Bundle saveInstanceState) {
    }

    @Override
    public void saveInstanceState(Bundle bundle) {

    }

    @Override
    public void detach() {
        subscriptions.clear();
        baseView = null;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    protected <T> Observable<T> observeOnView(Observable<T> observable) {
        /*if (!NetworkUtils.isActiveNetwork(context)) {
            return Observable.error(new HttpException("001", "网络问题导致"));
        }*/
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
    protected <T> Observable<T> observeOnView2(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}
