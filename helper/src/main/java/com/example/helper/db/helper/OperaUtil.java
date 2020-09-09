package com.example.helper.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.helper.db.info.Gu;
import com.example.helper.db.info.ListInfo;
import com.example.helper.db.utils.LogUtil;


import java.util.ArrayList;
import java.util.List;

import static com.example.helper.db.helper.SQLiteDBHelper.TABLE_NAME;
import static com.example.helper.db.helper.SQLiteDBHelper.TABLE_NAME_2;

public class OperaUtil {

    /**
     * "number varchar(50)," +
     * "name varchar(20)," +
     * "time varchar(100)," +
     * "beginPrice varchar(100)," +
     * "endPrice varchar(100)," +
     * "highestPrice varchar(100)," +
     * "minimumPrice varchar(100)," +
     * "amplitude varchar(50))");
     *
     * @param gu
     * @return
     */

    public static boolean insert(Gu gu) {
        if(guContain(gu)){
            update(gu);
            return true;
        }else{
            LogUtil.d("this is insert !!!");
            SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
            try {
                db.execSQL("insert into  "+ TABLE_NAME + " (number,name,time,beginPrice,endPrice,highestPrice,minimumPrice,amplitude) " +
                                "values(?,?,?,?,?,?,?,?)",
                        new Object[]{
                                gu.getNumber(), gu.getName(), gu.getTime(), gu.getBeginPrice(),
                                gu.getEndPrice(),gu.getHighestPrice(),gu.getMinimumPrice(),gu.getAmplitude()
                        });
                db.close();
                LogUtil.d("this is insert  GU:  is ok !");

                return true;
            } catch (Exception e) {
                LogUtil.d("this is insert  GU:  is error !");

                System.out.println(e.toString());
            }

            return false;
        }

    }

    public static void delete() {
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
        db.execSQL("delete from " + TABLE_NAME );
        db.close();
    }

    public static List<Gu> findByNumber(String params) {
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
        Cursor cursor = db.rawQuery("select * from  "+ TABLE_NAME+"  where number = ?  order by time ASC", new String[]{params + ""});

        LogUtil.d("this is select num:" + params);
        List<Gu> data = new ArrayList<>();
        while (cursor.moveToNext()) {
            String number = cursor.getString(cursor.getColumnIndex("number"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            String beginPrice = cursor.getString(cursor.getColumnIndex("beginPrice"));
            String endPrice = cursor.getString(cursor.getColumnIndex("endPrice"));
            String highestPrice = cursor.getString(cursor.getColumnIndex("highestPrice"));
            String minimumPrice = cursor.getString(cursor.getColumnIndex("minimumPrice"));
            String amplitude = cursor.getString(cursor.getColumnIndex("amplitude"));
            Gu gu = new Gu();
            gu.setNumber(number).setName(name).setTime(time).setBeginPrice(beginPrice)
                    .setEndPrice(endPrice).setHighestPrice(highestPrice).setMinimumPrice(minimumPrice)
                    .setAmplitude(amplitude);
            data.add(gu);
            LogUtil.d("this is select   GU:  " + gu.toString());

        }
        if(data.size()  == 0){
            LogUtil.d("this is select   GU: NULL ! " );
            findAllGu();
        }


        return data;
    }

    public static List<Gu> findAllGu(){
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
        Cursor cursor = db.rawQuery("select * from  "+ TABLE_NAME, null );

        List<Gu> data = new ArrayList<>();
        if (cursor.moveToNext()) {
            String number = cursor.getString(cursor.getColumnIndex("number"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            String beginPrice = cursor.getString(cursor.getColumnIndex("beginPrice"));
            String endPrice = cursor.getString(cursor.getColumnIndex("endPrice"));
            String highestPrice = cursor.getString(cursor.getColumnIndex("highestPrice"));
            String minimumPrice = cursor.getString(cursor.getColumnIndex("minimumPrice"));
            String amplitude = cursor.getString(cursor.getColumnIndex("amplitude"));
            Gu gu = new Gu();
            gu.setNumber(number).setName(name).setTime(time).setBeginPrice(beginPrice)
                    .setEndPrice(endPrice).setHighestPrice(highestPrice).setMinimumPrice(minimumPrice)
                    .setAmplitude(amplitude);
            data.add(gu);
            LogUtil.d("this is select   GU:  " + gu.toString());

        }else {
            LogUtil.d("this is select   GU:   NULL !"  );

        }
        return data;
    }

    public static boolean guContain(Gu gu){
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
        Cursor cursor = db.rawQuery("select * from  "+ TABLE_NAME +" where number =? and time = ? ", new String[]{ gu.getNumber(),gu.getTime()} );
        if(cursor.getCount() > 0){
            cursor.close();
            return  true;
        }else{
            return  false;
        }

    }

    public static List<ListInfo> findAllNumber(){
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
        Cursor cursor = db.rawQuery("select * from  "+ TABLE_NAME_2, null);
        List<ListInfo> data = new ArrayList<>();
        while (cursor.moveToNext()) {
            String number = cursor.getString(cursor.getColumnIndex("number"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            ListInfo info = new ListInfo(name,number);
            data.add(info);
            LogUtil.d("this is select num: " + info.toString());
        }
        cursor.close();
        return data;
    }

    public static boolean insertListInfo(ListInfo info){
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
        try {
            Cursor cursor = db.rawQuery("select * from  "+ TABLE_NAME_2+"  where number = ? ", new String[]{info.getNumber() + ""});
            if(cursor.getCount() > 0){
                cursor.close();
                LogUtil.d("this is exist !");
                return true;
            }
            db.execSQL("insert into  "+ TABLE_NAME_2 + " (name,number) " +
                            "values(?,?)",
                    new Object[]{
                            info.getName(), info.getNumber()
                    });
            db.close();
            LogUtil.d("this is insert list ok  !");
            return true;
        } catch (Exception e) {
            LogUtil.d("this is error !" + e.toString());

        }

        return false;
    }






    /**
     *      String number;
     *     String name;
     *     String time;
     *     String beginPrice;
     *     String endPrice;
     *     String highestPrice;
     *     String minimumPrice;
     *     String amplitude;
     * @param gu
     */
    public static void update(Gu gu) {
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
        db.execSQL("update "+ TABLE_NAME
                        + " set name=?,beginPrice=?,endPrice=?,highestPrice=?, minimumPrice=?,amplitude=?" +
                        " where time = ? and number = ?",
                new Object[]{
                        gu.getName(),gu.getBeginPrice(),gu.getEndPrice(),gu.getHighestPrice(),
                        gu.getMinimumPrice(),gu.getAmplitude(),gu.getTime(),gu.getNumber(),
        });
        db.close();
        LogUtil.d("this is update ");
    }


}
