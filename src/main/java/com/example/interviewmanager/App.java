package com.example.interviewmanager;


import com.example.interviewmanager.base.BaseApplication;

import org.litepal.LitePal;

public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        LitePal.initialize(this);
    }
}
