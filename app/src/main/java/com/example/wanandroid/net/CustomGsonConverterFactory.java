package com.example.wanandroid.net;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class CustomGsonConverterFactory extends Converter.Factory {

    private Context context;

    public static CustomGsonConverterFactory create(Context context) {
        return  new CustomGsonConverterFactory(new Gson(),context);
    }


    public static CustomGsonConverterFactory create() {
        return  new CustomGsonConverterFactory(new Gson());
    }

    private final Gson gson;

    private CustomGsonConverterFactory(Gson gson ,Context context) {
        this.gson = gson;
        this.context=context;
    }

    private CustomGsonConverterFactory(Gson gson) {
        this.gson = gson;

    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new CheckGsonResponseBodyConverter<>(gson, adapter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new CheckGsonRequestBodyConverter<>(gson, adapter,context );
    }
}
