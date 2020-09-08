package com.example.wanandroid.net;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

public class CheckGsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private Context context;

    CheckGsonRequestBodyConverter(Gson gson, TypeAdapter<T> adapter,Context context) {
        this.gson = gson;
        this.adapter = adapter;
        this.context=context;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        //Buffer buffer = new Buffer();
        //Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
        //JsonWriter jsonWriter = gson.newJsonWriter(writer);
        //adapter.write(jsonWriter, value);
        //jsonWriter.close();

        //if(ShareRefrenceUtils.getFrontPath(context)!=null&&ShareRefrenceUtils.getBackPath(context)!=null){
        ////if(value instanceof ){
        //  Buffer buffer = new Buffer();
        //  Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
        //  JsonWriter jsonWriter = gson.newJsonWriter(writer);
        //  adapter.write(jsonWriter, value);
        //  jsonWriter.close();
        //  return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
        //}
        PublicModel model = new PublicModel(value);
        String json2 = gson.toJson(model);
        return RequestBody.create(MEDIA_TYPE, json2);
    }
}

