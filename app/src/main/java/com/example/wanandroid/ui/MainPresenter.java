package com.example.wanandroid.ui;

import com.example.wanandroid.model.VoiceVerificationCodeInfo;
import com.example.wanandroid.mvp.BaseView;
import com.example.wanandroid.mvp.RxPresenter;
import com.example.wanandroid.repository.VoiceVerificationCodeRepository;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Subscriber;

public class MainPresenter extends RxPresenter<BaseView> {

    private VoiceVerificationCodeRepository codeRepository;


    public MainPresenter(VoiceVerificationCodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public void getCode(){

       subscriptions.add(observeOnView(codeRepository.getVoiceCode(new VoiceVerificationCodeInfo("1886423070","SMS_FORGETPWD_CODE"))).subscribe(
               new Subscriber<ResponseBody>() {
                   @Override
                   public void onCompleted() {

                   }

                   @Override
                   public void onError(Throwable e) {

                       baseView.hideLoading();
                   }

                   @Override
                   public void onNext(ResponseBody responseBody) {
                       baseView.showLoading();
                   }
               }
       ));
   }

}
