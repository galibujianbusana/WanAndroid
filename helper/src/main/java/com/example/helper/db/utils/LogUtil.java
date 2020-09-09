package com.example.helper.db.utils;

public class LogUtil {
    public static void d(String msg){
        android.util.Log.d("HelperTag", msg);
    }

    public static void v(String msg){
        android.util.Log.v("HelperTag", msg);
    }
}
