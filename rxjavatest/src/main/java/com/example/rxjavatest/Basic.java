package com.example.rxjavatest;

import androidx.annotation.Nullable;

public class Basic {

    public static ThreadLocal<Long> x = new ThreadLocal<Long>(){
        @Nullable
        @Override
        protected Long initialValue() {
            System.out.println("this is initialValue ");
            return 1001L;
        }
    };

      public static void main(String[] args) {

          System.out.println(x.get());
    }

}
