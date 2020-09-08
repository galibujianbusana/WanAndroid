package com.example.wanandroid.error;

public class ApiError {

    public final String code;

    public final String message;

    private ApiError(Builder builder) {
        code = builder.code;
        message = builder.message;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String code;
        private String message;

        private Builder() {
        }

        public Builder code(String val) {
            code = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public ApiError build() {
            return new ApiError(this);
        }
    }
}

