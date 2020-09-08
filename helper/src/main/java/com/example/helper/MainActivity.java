package com.example.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.helper.adapter.MyAdapter;
import com.example.helper.db.info.Gu;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    MyAdapter adapter;
    List<Gu> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        adapter = new MyAdapter(this,data);
        lv.setAdapter(adapter);
    }
}
