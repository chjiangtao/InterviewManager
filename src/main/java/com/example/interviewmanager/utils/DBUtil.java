package com.example.interviewmanager.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.interviewmanager.DB.MySQLiteOpenHelper;
import com.example.interviewmanager.constant.Constant;
import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.entity.InterviewMessageWithLabel;
import com.example.interviewmanager.entity.Label;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库相关
 */
public class DBUtil {
    private SQLiteDatabase db;

    public DBUtil(Context context) {
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(context);
        if (db == null) {
            db = helper.getWritableDatabase();
        }
    }

    /**
     * 插入一个面试信息
     *
     * @param message
     * @return
     */
    public boolean insert(InterviewMessage message) {
        ContentValues values = new ContentValues();
        values.put("companyName", message.getCompanyName());
        values.put("address", message.getAddress());
        values.put("telephone", message.getTelephone());
        values.put("contact", message.getContact());
        values.put("office", message.getOffice());
        values.put("date", message.getDate());
        values.put("salary", message.getSalary());
        values.put("remark",message.getRemark());
        long num = db.insert(Constant.INTERVIEW_TABLE_NAME, null, values);
        db.close();
        if (num != -1) {
            return true;
        }
        return false;
    }

    /**
     * 获取所有的面试信息
     *
     * @return
     */
    public List<InterviewMessage> getAllInterviewMessages() {
        List<InterviewMessage> messageList = new ArrayList<>();
        Cursor cursor = db.query(Constant.INTERVIEW_TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            InterviewMessage interviewMessage = new InterviewMessage();
            interviewMessage.setAddress(cursor.getString(cursor.getColumnIndex("address")));
            interviewMessage.setCompanyName(cursor.getString(cursor.getColumnIndex("companyName")));
            interviewMessage.setContact(cursor.getString(cursor.getColumnIndex("contact")));
            interviewMessage.setDate(cursor.getString(cursor.getColumnIndex("date")));
            interviewMessage.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            interviewMessage.setOffice(cursor.getString(cursor.getColumnIndex("office")));
            interviewMessage.setSalary(cursor.getString(cursor.getColumnIndex("salary")));
            messageList.add(interviewMessage);
        }
        db.close();
        return messageList;
    }

    /**
     * 获取一个公司的所有标签
     */
    public List<Label> getAllLabels(String companyName) {
        List<Label> labels=new ArrayList<>();
        Cursor cursor=db.query(Constant.LABEL_TABLE_NAME,null, null, null, null, null, null);
        cursor.moveToFirst();
        while(cursor.moveToNext()){
            Label label=new Label();
            label.setLabel(cursor.getString(cursor.getColumnIndex("label")));
            label.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            label.setCompanyName(cursor.getString(cursor.getColumnIndex("companyName")));
            labels.add(label);
        }
        return labels;
    }
}
