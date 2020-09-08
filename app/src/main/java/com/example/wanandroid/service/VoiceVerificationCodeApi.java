package com.example.wanandroid.service;

import com.example.wanandroid.model.VoiceVerificationCodeInfo;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface VoiceVerificationCodeApi {

    @POST("customer/sendVoiceMsg")
    Observable<ResponseBody> getVoiceCode(@Body VoiceVerificationCodeInfo request);
}
