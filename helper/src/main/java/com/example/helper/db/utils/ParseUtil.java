package com.example.helper.db.utils;

import com.example.helper.db.info.Gu;

import java.io.IOException;

import okhttp3.Response;

public class ParseUtil {
    /**
     * var hq_str_sh601006="大秦铁路, 27.55, 27.25, 26.91, 27.55, 26.20, 26.91, 26.92,
     * 22114263, 589824680, 4695, 26.91, 57590, 26.90, 14700, 26.89, 14300,
     * 26.88, 15100, 26.87, 3100, 26.92, 8900, 26.93, 14230, 26.94, 25150, 26.95, 15220, 26.96, 2008-01-11, 15:05:32";
     * 这个字符串由许多数据拼接在一起，不同含义的数据用逗号隔开了，按照程序员的思路，顺序号从0开始。
     * 0：”大秦铁路”，股票名字；
     * 1：”27.55″，今日开盘价；
     * 2：”27.25″，昨日收盘价；
     * 3：”26.91″，当前价格；
     * 4：”27.55″，今日最高价；
     * 5：”26.20″，今日最低价；
     * 6：”26.91″，竞买价，即“买一”报价；
     * 7：”26.92″，竞卖价，即“卖一”报价；
     * 8：”22114263″，成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百；
     * 9：”589824680″，成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万；
     * 10：”4695″，“买一”申请4695股，即47手；
     * 11：”26.91″，“买一”报价；
     * 12：”57590″，“买二”
     * 13：”26.90″，“买二”
     * 14：”14700″，“买三”
     * 15：”26.89″，“买三”
     * 16：”14300″，“买四”
     * 17：”26.88″，“买四”
     * 18：”15100″，“买五”
     * 19：”26.87″，“买五”
     * 20：”3100″，“卖一”申报3100股，即31手；
     * 21：”26.92″，“卖一”报价
     * (22, 23), (24, 25), (26,27), (28, 29)分别为“卖二”至“卖四的情况”
     * 30：”2008-01-11″，日期；
     * 31：”15:05:32″，时间；
     */

    /**
     * var hq_str_sh600999="招商证券,21.220,21.180,21.440,21.650,20.920,21.440,21.450,30043512,639625567.000,208827,21.440,17700,21.430,29800,21.420,60983,21.410,40592,21.400,57070,21.450,18400,21.460,11430,21.470,23650,21.480,18370,21.490,2020-09-08,15:00:00,00,";
     */
    public static Gu parse(Response response) {
        String s = "";
        try {
            s = new String(response.body().bytes(),"GBK");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogUtil.v("this is response  " + s);
        String body = s.split("\\\"")[1];
        String data[] = body.split(",");
        Gu gu = new Gu();
        try {
            gu.setName(data[0]);
            gu.setNumber("");
            gu.setBeginPrice(data[1]);
            gu.setEndPrice(data[3]);
            gu.setHighestPrice(data[4]);
            gu.setMinimumPrice(data[5]);
            gu.setAmplitude("");
            gu.setTime(data[30]);

            String title  = s.split("sh")[1];
            String num = title.substring(0,6);
            gu.setNumber(num);
            double  cha =  Double.parseDouble(gu.getEndPrice()) -Double.parseDouble(gu.getBeginPrice()) ;
            double am = cha / (Double.parseDouble(gu.getBeginPrice())) * 100;
            gu.setAmplitude(String.format("%.2f", am));

            int index = 0;
            for (int i = 0; i < data.length; i ++){
                if(data[i].contains(":")){
                    index = i;
                }
            }
            gu.setTime(data[index - 1]);
            return gu;
        }catch (Exception e){
            return  null;
        }


    }
}
