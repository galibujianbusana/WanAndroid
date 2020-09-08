package com.example.test.mvp;

import android.content.Context;
import android.os.Bundle;

import com.example.test.mvp.BaseView;
import com.example.test.mvp.Presenter;

public class BasePresenter<T> implements Presenter<BaseView> {

    Context context;

    protected BaseView baseView;

    @Override
    public void attach(BaseView View) {
        this.baseView = View;
    }

    @Override
    public void restoreInstanceState(Bundle saveInstanceState) {

    }

    @Override
    public void saveInstanceState(Bundle bundle) {

    }

    @Override
    public void detach() {
        baseView = null;
    }

    @Override
    public void setContext(Context context) {

        this.context = context;
    }
}
