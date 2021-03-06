package com.example.interviewmanager.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.interviewmanager.constant.Constant;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public MySQLiteOpenHelper(Context context){
        super(context, Constant.DB_NAME,null,Constant.DB_VERSION);
    }

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="create table if not exists "+Constant.INTERVIEW_TABLE_NAME+"(" +
                "_id integer primary key autoincrement," +
                "companyName text," +
                "address text," +
                "telephone text," +
                "contact  text," +
                "office text," +
                "date text," +
                "remark text," +
                "salary text)";
        String sqlLabel="create table if not exists "+Constant.LABEL_TABLE_NAME+"(" +
                "_id integer primary key autoincrement," +
                "companyName text," +
                "label text)";
        String sqlLocation="create table if not exists "+Constant.LOCATION_TABLE_NAME+"(" +
                "_id integer primary key autoincrement," +
                "address text," +
                "province text," +
                "city text," +
                "district text," +
                "street text)";

         sqLiteDatabase.execSQL(sql);
         sqLiteDatabase.execSQL(sqlLabel);
         sqLiteDatabase.execSQL(sqlLocation);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
