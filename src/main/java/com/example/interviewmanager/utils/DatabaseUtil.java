package com.example.interviewmanager.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.interviewmanager.DB.MySQLiteOpenHelper;
import com.example.interviewmanager.constant.Constant;
import com.example.interviewmanager.entity.InterviewMessage;

/**
 * 数据库相关
 */
public class DatabaseUtil {
    private SQLiteDatabase db;
    public DatabaseUtil(Context context) {
        MySQLiteOpenHelper helper=new MySQLiteOpenHelper(context);
        if(db==null){
            db=helper.getWritableDatabase();
        }
    }

    public void insert(InterviewMessage message){
        ContentValues values=new ContentValues();
        values.put("companyName","1");
        values.put("address","1");
        values.put("telephone","1");
        values.put("contact","1");
        values.put("office","1");
        values.put("data","1");
        values.put("salary","1");
        db.insert(Constant.TABLE_NAME,null,values);
    }
}
