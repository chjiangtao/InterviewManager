package com.example.interviewmanager.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import com.example.interviewmanager.R;


/**
 * 发布面试通知
 */
public class InterviewMessageNotification {
    private Context mConext;

    public InterviewMessageNotification(Context mConext) {
        this.mConext = mConext;
    }

    public  void releaseMessage(){
        NotificationManager manager=(NotificationManager)mConext.getSystemService(mConext.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(mConext);
        mBuilder.setContentTitle("这是标题")
                .setContentText("这是内容")
                .setLargeIcon(BitmapFactory.decodeResource(mConext.getResources(), R.mipmap.ic_launcher))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setTicker("这是测试内容")
                .setDefaults(Notification.DEFAULT_SOUND);
        manager.notify(10,mBuilder.build());
    }
}
