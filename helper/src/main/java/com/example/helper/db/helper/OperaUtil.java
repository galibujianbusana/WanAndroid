package com.example.helper.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.helper.db.info.Gu;


import java.util.ArrayList;
import java.util.List;

import static com.example.helper.db.helper.SQLiteDBHelper.TABLE_NAME;

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

    public boolean insert(Gu gu) {
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
        try {
            db.execSQL("insert into  "+ TABLE_NAME + " (number,name,time,beginPrice,endPrice,highestPrice,minimumPrice,amplitude) " +
                            "values(?,?,?,?,?,?,?,?)",
                    new Object[]{
                            gu.getNumber(), gu.getName(), gu.getTime(), gu.getBeginPrice(),
                            gu.getEndPrice(),gu.getHighestPrice(),gu.getMinimumPrice(),gu.getAmplitude()
            });
            db.close();
            return true;
        } catch (Exception e) {
          System.out.println(e.toString());
        }

        return false;
    }

    public void delete(String number) {
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
        db.execSQL("delete from " + TABLE_NAME + " where _id = " + number);
        db.close();
    }





    public List<Gu> findByNumber(String params) {
        SQLiteDatabase db = SQLiteDBHelper.getSqLiteDatabase();
        Cursor cursor = db.rawQuery("select * from  "+ TABLE_NAME+"  where number = ?  order by time ASC", new String[]{params + ""});
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

        }
        return data;
    }



}
