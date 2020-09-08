package com.example.wanandroid.error;


import java.io.IOException;

public class ApiException extends IOException {
    public final String status;
    public final String errMsg;
    public final ApiError apiError;

    public ApiException(String status, String msg) {
        super(msg);
        this.status = status;
        this.errMsg = msg;
        apiError = ApiError.newBuilder().code(status).message(msg).build();
    }

    public ApiException(ApiError apiError) {
        this.status = apiError.code;
        this.errMsg = apiError.message;
        this.apiError = apiError;
    }

    public String toString() {
        return "Api error code : " + status + " , Api error message : " + errMsg;
    }

    public ApiError apiError() {
        return apiError;
    }
}

