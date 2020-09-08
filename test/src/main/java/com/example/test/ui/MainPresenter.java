package com.example.test.ui;

import android.util.Log;

import com.example.test.mvp.RxPresenter;

import java.io.IOException;

import okhttp3.ResponseBody;
import repository.VoiceVerificationCodeRepository;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainPresenter extends RxPresenter<MainView> {

    private static final String TAG = "MainPresenter";

    private VoiceVerificationCodeRepository voiceVerificationCodeRepository;

    public MainPresenter(VoiceVerificationCodeRepository voiceVerificationCodeRepository) {
        this.voiceVerificationCodeRepository = voiceVerificationCodeRepository;
    }

    public void getCode() {

        voiceVerificationCodeRepository.getVoiceCode()               //获取Observable对象
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                .observeOn(Schedulers.io())         //请求完成后在io线程中执行
                .doOnNext(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody userInfo) {
                        Log.d(TAG, "call: ");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        //请求失败
                        Log.d(TAG, "onError: ");

                        baseView.hideLoading();
                    }

                    @Override
                    public void onNext(ResponseBody userInfo) {
                        //请求成功
                        try {
                            Log.d(TAG, "onNext: " + userInfo.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        baseView.showLoading();

                    }
                });


    }
}
