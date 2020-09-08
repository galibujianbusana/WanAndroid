package com.example.wanandroid.net;


import android.util.Log;

import com.example.wanandroid.error.ApiException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class CheckGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final TypeAdapter<T> adapter;
    private final Gson gson;
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private String jsonResult;

    CheckGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        String json = null;
        try {
            json = value.string();
            Log.d(this.getClass().getName(),"str-->:"+json);
            HttpResponse httpResponse = gson.fromJson(json, HttpResponse.class);
            if (httpResponse.result == null || httpResponse.result.equals("")) {
                errorHandle(httpResponse.code, httpResponse.message);
            }

            ByteArrayInputStream inputStream = new ByteArrayInputStream(gson.toJson(json).getBytes());
            Reader reader = new InputStreamReader(inputStream);
            JsonReader jsonReader = gson.newJsonReader(reader);
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }

    private void errorHandle(String code, String message) throws IOException {
        switch (code) {

            default:
                throw new ApiException(code, message);
        }
    }
}

