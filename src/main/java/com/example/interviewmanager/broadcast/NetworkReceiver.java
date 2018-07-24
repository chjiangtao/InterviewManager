package com.example.interviewmanager.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

public class NetworkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_NEW_STATE, 0);
            switch (wifiState) {
                case WifiManager.WIFI_STATE_DISABLED://关闭
                    break;
                case WifiManager.WIFI_STATE_ENABLED://已连接
                    break;
            }
        }

        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
             //获取联网状态的NetworkInfo对象
            NetworkInfo info=intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            if(info!=null){
                if(NetworkInfo.State.CONNECTED==info.getState()&&info.isAvailable()){
                    if(info.getType()==ConnectivityManager.TYPE_WIFI||
                            info.getType()==ConnectivityManager.TYPE_MOBILE){
                        Toast.makeText(context, "网络连接成功", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(context, "断开", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
