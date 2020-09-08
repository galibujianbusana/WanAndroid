package com.example.wanandroid.net;


public class HttpResponse<T> {
    public String code;
    public String message;
    public T result;

    public HttpResponse(String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    @Override public String toString() {
        return "code:" + code + "------message:" + message;
    }

    public String getCode() {
        return code;
    }

    public T getObject() {
        return result;
    }


}
