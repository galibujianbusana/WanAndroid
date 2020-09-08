package com.example.wanandroid.mvp;

import android.content.Context;
import android.os.Bundle;

import java.net.ContentHandler;

public interface Presenter<T extends BaseView> {


    void attach(T View);

    void restoreInstanceState(Bundle saveInstanceState);

    void saveInstanceState(Bundle bundle);

    void detach();

    void setContext(Context context);








}
