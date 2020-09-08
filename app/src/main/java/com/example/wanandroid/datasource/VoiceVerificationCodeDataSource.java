package com.example.wanandroid.datasource;

import android.util.Log;

import com.example.wanandroid.model.VoiceVerificationCodeInfo;
import com.example.wanandroid.repository.VoiceVerificationCodeRepository;
import com.example.wanandroid.service.VoiceVerificationCodeApi;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;

public class VoiceVerificationCodeDataSource implements VoiceVerificationCodeRepository {


    private VoiceVerificationCodeApi api;

    public VoiceVerificationCodeDataSource(Retrofit retrofit) {
        if(retrofit == null){
            Log.d("TAG2", "VoiceVerificationCodeDataSource: this is null ");
        }
        this.api = retrofit.create(VoiceVerificationCodeApi.class);
    }


    @Override
    public Observable<ResponseBody> getVoiceCode(VoiceVerificationCodeInfo info) {
        return api.getVoiceCode(info);
    }
}


