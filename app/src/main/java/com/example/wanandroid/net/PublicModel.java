package com.example.wanandroid.net;

import okhttp3.MultipartBody;

public class PublicModel<T> {
    public T requestData;
    public MultipartBody imageF;
    public MultipartBody imageZ;

    public PublicModel(T requestData) {
        this.requestData = requestData;
    }

    public PublicModel(T requestData, MultipartBody imageF, MultipartBody imageZ) {
        this.requestData = requestData;
        this.imageF = imageF;
        this.imageZ = imageZ;
    }
}
