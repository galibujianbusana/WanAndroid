package com.example.helper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.helper.adapter.ListAdapter;
import com.example.helper.adapter.MyAdapter;
import com.example.helper.db.helper.OperaUtil;
import com.example.helper.db.helper.PathUtil;
import com.example.helper.db.helper.SQLiteDBHelper;
import com.example.helper.db.info.Gu;
import com.example.helper.db.info.ListInfo;
import com.example.helper.db.utils.HttpUtil;
import com.example.helper.db.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private MyAdapter adapter;
    private List<Gu> data;

    private ListView lvList;
    private ListAdapter listAdapter;
    private List<ListInfo> dataList;

    private TextView tv, tv2,tv3,tv4;

    private LinearLayout layoutBase;
    private EditText editNo;
    private TextView tvAdd;

    private static final Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {
            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        statue();
        SQLiteDBHelper.setDBPath(PathUtil.getSDCardPath(this));
        SQLiteDBHelper.init();
        lv = findViewById(R.id.lv);
        data = new ArrayList<>();
        adapter = new MyAdapter(this,data);
        lv.setAdapter(adapter);

        lvList = findViewById(R.id.lvList);
        dataList = OperaUtil.findAllNumber();
        listAdapter = new ListAdapter(this,dataList);
        lvList.setAdapter(listAdapter);

        tv = findViewById(R.id.tv);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lvList.getVisibility() == View.GONE){
                    dataList.clear();
                    dataList.addAll(OperaUtil.findAllNumber());
                    LogUtil.d("this is dataList  size :" + dataList.size());
                    listAdapter.notifyDataSetChanged();
                    lvList.setVisibility(View.VISIBLE);
                }else{
                    lvList.setVisibility(View.GONE);
                }

            }
        });
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListInfo info = dataList.get(i);
                String number = info.getNumber();
                lvList.setVisibility(View.GONE);
                data.clear();
                data.addAll(OperaUtil.findByNumber(number));
                adapter.notifyDataSetChanged();
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(layoutBase.getVisibility() == View.VISIBLE){
                    layoutBase.setVisibility(View.GONE);
                }else{
                    editNo.setText("");
                    layoutBase.setVisibility(View.VISIBLE);
                }

            }
        });

        layoutBase = findViewById(R.id.layoutBase);
        editNo = findViewById(R.id.editNo);
        tvAdd = findViewById(R.id.tvAdd);
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutBase.setVisibility(View.GONE);
                String s = editNo.getText().toString().trim();
                if(s.length() > 0){
                    HttpUtil.httpAddList(s);
                }

            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataList.clear();
                dataList.addAll(OperaUtil.findAllNumber());
                for (int i = 0; i < dataList.size(); i ++){
                    HttpUtil.http(dataList.get(i).getNumber());
                }

            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OperaUtil.delete();
            }
        });
    }



    public void statue(){
        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
