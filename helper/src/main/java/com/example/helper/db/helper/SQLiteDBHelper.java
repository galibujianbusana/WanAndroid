package com.example.helper.db.helper;

import android.database.sqlite.SQLiteDatabase;

import java.io.File;

public class SQLiteDBHelper {

    private static String DB_PATH;
    private static final String DB_NAME = "GuoLi.db";  // 数据库名称
    public static final String TABLE_NAME = "gu";
    public static final String TABLE_NAME_2 = "gu_no";

    public void setDBPath(String s){
        this.DB_PATH = s;
    }

    public void init(){
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
        db.close();
    }

    public static SQLiteDatabase getSqLiteDatabase() {
        return SQLiteDatabase.openOrCreateDatabase(DB_PATH+File.separator+DB_NAME, null);
    }
}
