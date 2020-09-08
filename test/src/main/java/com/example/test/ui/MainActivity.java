package com.example.test.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.datasource.VoiceVerificationCodeDataSource;
import com.example.test.net.RetrofitManager;


public class MainActivity extends AppCompatActivity implements MainView {


    private static final String TAG = "MainActivityTAG";


    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(new VoiceVerificationCodeDataSource(RetrofitManager.getRetrofit()));
        mainPresenter.attach(this);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.getCode();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detach();
    }

    @Override
    public void showLoading() {

        Log.d(TAG, "showLoading: ");
    }

    @Override
    public void hideLoading() {

        Log.d(TAG, "hideLoading: ");
    }
}
