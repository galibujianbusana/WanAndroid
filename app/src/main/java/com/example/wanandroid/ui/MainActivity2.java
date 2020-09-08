package com.example.wanandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.datasource.VoiceVerificationCodeDataSource;
import com.example.wanandroid.mvp.BaseView;
import com.example.wanandroid.net.RetrofitManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity2 extends AppCompatActivity  implements BaseView {


    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mainPresenter = new MainPresenter(new VoiceVerificationCodeDataSource(
                RetrofitManager.getInstance().getRetrofit()
        ));


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG2", "onClick:  this is click!");
               // mainPresenter.getCode();
                new Thread(){

                    @Override
                    public void run() {
                        super.run();
                        test();
                    }
                }.start();

            }
        });

    }

    @Override
    public void showLoading() {
        Toast.makeText(this,"show",Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(this,"hide",Toast.LENGTH_LONG).show();

    }

    private void test(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();

        Request request = new Request.Builder()
                .url("http://www.publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Example")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.body().close();
    }

    class LoggingInterceptor implements Interceptor {
        @Override public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            Log.d("LoggingInterceptor",String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            Log.d("LoggingInterceptor",String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));

            return response;
        }
    }
}