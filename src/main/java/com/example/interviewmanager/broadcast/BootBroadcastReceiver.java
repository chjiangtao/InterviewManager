package com.example.interviewmanager.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.interviewmanager.service.SystemDateService;

/**
 * 监听系统开机和关机广播
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    private static final String ACTION="android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "开机了", Toast.LENGTH_LONG).show();
        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            Log.e("test","已经开机了");
        }
        Log.e("test","开机了");
        Intent startServiceIntent=new Intent(context, SystemDateService.class);
        startServiceIntent.setAction(ACTION);
        context.startService(startServiceIntent);
    }
}
