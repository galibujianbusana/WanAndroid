package com.example.helper.db.helper;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.helper.db.utils.LogUtil;

import java.io.File;

public class SQLiteDBHelper {

    private static final String TAG = "SQLiteDBHelper";

    private static String DB_PATH;
    private static final String DB_NAME = "GuoLi.db";  // 数据库名称
    public static final String TABLE_NAME = "gu";
    public static final String TABLE_NAME_2 = "gu_no";

    public static void setDBPath(String s){
        DB_PATH = s;
        LogUtil.d("this is path "+ DB_PATH);
    }

    public static void init(){

        LogUtil.d("this is init ");
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DB_PATH+ File.separator+DB_NAME, null);
        db.execSQL("create table if not exists " + TABLE_NAME +  "(_id integer primary key autoincrement," +
                "number varchar(50)," +
                "name varchar(20)," +
                "time varchar(100)," +
                "beginPrice varchar(100)," +
                "endPrice varchar(100)," +
                "highestPrice varchar(100)," +
                "minimumPrice varchar(100)," +
                "amplitude varchar(50))");

        db.execSQL("create table if not exists " + TABLE_NAME_2 +  "(_id integer primary key autoincrement," +
                "number varchar(50)," +
                "name varchar(50)" +
                ")");
        LogUtil.d("this is init  end");
        db.close();
    }

    public static SQLiteDatabase getSqLiteDatabase() {
        return SQLiteDatabase.openOrCreateDatabase(DB_PATH+File.separator+DB_NAME, null);
    }
}
