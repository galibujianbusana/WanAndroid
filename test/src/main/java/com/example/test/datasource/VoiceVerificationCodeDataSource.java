package com.example.test.datasource;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.test.api.VoiceVerificationCodeApi;

import okhttp3.ResponseBody;
import repository.VoiceVerificationCodeRepository;
import retrofit2.Retrofit;
import rx.Observable;

public class VoiceVerificationCodeDataSource implements VoiceVerificationCodeRepository {


    private VoiceVerificationCodeApi api;

    public VoiceVerificationCodeDataSource(@NonNull Retrofit retrofit) {
        if(retrofit == null){
            Log.d("TAG2", "VoiceVerificationCodeDataSource: this is null ");
        }
        this.api = retrofit.create(VoiceVerificationCodeApi.class);
    }


    @Override
    public Observable<ResponseBody> getVoiceCode( ) {
        return api.getVoiceCode();
    }
}


