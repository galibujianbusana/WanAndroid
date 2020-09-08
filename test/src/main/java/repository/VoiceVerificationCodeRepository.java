package repository;


import okhttp3.ResponseBody;
import rx.Observable;

public interface VoiceVerificationCodeRepository {

    Observable<ResponseBody> getVoiceCode();
}
