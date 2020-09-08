package com.example.test.api;


import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface VoiceVerificationCodeApi {

    @GET("tree/json")
    Observable<ResponseBody> getVoiceCode();
}
