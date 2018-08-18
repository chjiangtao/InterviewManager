package com.example.interviewmanager.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络相关
 */
public class NetworkUtil {

    //判断网络是否连接
    public static boolean isNetworkAvailabel(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //网络信息
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null){
            return true;
        }
        return false;
    }

    //判断是否是WIFI
    public static boolean isWifi(Context context){
        //网络连接管理器
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //网络信息
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.getType()==connectivityManager.TYPE_WIFI){
             return true;
        }
        return false;
    }

    //判断是否是手机流量
    public static boolean isMobile(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //网络信息
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.getType()==connectivityManager.TYPE_MOBILE){
            return true;
        }
        return false;
    }
}
