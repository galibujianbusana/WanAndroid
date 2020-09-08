package com.example.wanandroid.net;

import android.content.Context;

import com.example.wanandroid.model.VoiceVerificationCodeInfo;
import com.example.wanandroid.service.VoiceVerificationCodeApi;
import com.example.wanandroid.utils.MyBaseUrl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.Subject;

/**
 * Created by leo
 * on 2019/8/16.
 */
public class RetrofitManager {

    private static Retrofit retrofit;
    private VoiceVerificationCodeApi voiceVerificationCodeApi;

    //构造方法私有
    private RetrofitManager() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5000, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
               // .client(builder.build())
                //modify by zqikai 20160317 for 对http请求结果进行统一的预处理 GosnResponseBodyConvert
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(CustomGsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(MyBaseUrl.BASE_URL)
                .build();



    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final RetrofitManager INSTANCE = new RetrofitManager();
    }

    //获取单例
    public static RetrofitManager getInstance() {
        return SingletonHolder.INSTANCE;
    }


    private OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);
        return builder.build();
    }

    public static Retrofit getRetrofit(){
        if(retrofit != null){
            return retrofit;
        }else{
            return null;
        }
    }

}
