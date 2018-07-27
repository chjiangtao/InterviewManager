package com.example.interviewmanager.utils;

import android.util.Log;

public class LogUtil{
     private String name;
     private boolean isShow;

    public LogUtil(String name,boolean isShow) {
        this.name = name;
        this.isShow=isShow;
    }

    public void e(String value){
        if(isShow){
            Log.e(name,value);
        }

    }
}
