package com.example.interviewmanager.utils;

import android.util.Log;

/**
 * 日志工具类
 */
public class LogUtil {
    private static String name = "TAG";
    private static boolean isShow = true;

    public static void e(String value) {
        if (isShow) {
            Log.e(name, value);
        }
    }

    public static void v(String value) {
        if (isShow){
            Log.v(name, value);
        }
    }

    public static void d(String value) {
        if (isShow) {
            Log.d(name, value);
        }
    }

    public static void i(String value) {
        if (isShow) {
            Log.i(name, value);
        }
    }

    public static void w(String value) {
        if (isShow) {
            Log.w(name, value);
        }
    }

}
