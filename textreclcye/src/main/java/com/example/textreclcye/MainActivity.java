package com.example.textreclcye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Bean> beanList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            beanList.add(new Bean(String.format("第一组%d号", i + 1), "第一组"));
        }
        for (int i = 0; i < 6; i++) {
            beanList.add(new Bean(String.format("第二组%d号", i + 1), "第二组"));
        }
        for (int i = 0; i < 6; i++) {
            beanList.add(new Bean(String.format("第三组%d号", i + 1), "第三组"));
        }
        for (int i = 0; i < 6; i++) {
            beanList.add(new Bean(String.format("第四组%d号", i + 1), "第四组"));
        }
    }
}
