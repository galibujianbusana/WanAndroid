package com.example.helper.db.utils;

import android.widget.Toast;

import com.example.helper.db.helper.OperaUtil;
import com.example.helper.db.info.Gu;
import com.example.helper.db.info.ListInfo;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {

    private static  final OkHttpClient mOkHttpClient = new OkHttpClient();
    private static final String BASE_URL = "http://hq.sinajs.cn/list=sh";

    /**
     *  http://hq.sinajs.cn/list=sh601006
     */
    public static void http(String url){

        String urlOk = BASE_URL + url;
        LogUtil.v("this is http  url:  is  " + urlOk);
        final Request request = new Request.Builder()
                .url(urlOk)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.d("this is http error ! "+ e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gu gu = ParseUtil.parse(response);
                if(gu == null){

                }else{
                    OperaUtil.insert(gu);
                }

            }
        });



    }

    public static void httpAddList(String url){

        String urlOk = BASE_URL + url;
        LogUtil.v("this is http  url:  is  " + urlOk);
        final Request request = new Request.Builder()
                .url(urlOk)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.d("this is http error ! "+ e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gu gu = ParseUtil.parse(response);
                if(gu == null){

                }else{
                    OperaUtil.insertListInfo(new ListInfo(gu.getName(),gu.getNumber()));
                }

            }
        });



    }

}
