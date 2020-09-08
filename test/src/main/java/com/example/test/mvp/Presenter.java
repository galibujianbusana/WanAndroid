package com.example.test.mvp;

import android.content.Context;
import android.os.Bundle;

public interface Presenter<T extends BaseView> {


    void attach(T View);

    void restoreInstanceState(Bundle saveInstanceState);

    void saveInstanceState(Bundle bundle);

    void detach();

    void setContext(Context context);








}
