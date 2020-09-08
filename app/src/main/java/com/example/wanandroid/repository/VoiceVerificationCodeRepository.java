package com.example.wanandroid.repository;

import com.example.wanandroid.model.VoiceVerificationCodeInfo;

import okhttp3.ResponseBody;
import rx.Observable;

public interface VoiceVerificationCodeRepository {

    Observable<ResponseBody> getVoiceCode(VoiceVerificationCodeInfo info);
}
