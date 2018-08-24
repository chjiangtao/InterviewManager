package com.example.interviewmanager.utils;

import android.content.Context;
import android.content.pm.PackageManager;

import com.example.interviewmanager.dialog.UpdateDialog;
import com.example.interviewmanager.entity.UpdateMessage;

/**
 * 更新APK
 */
public class UpdateAPKUtil {
    private Context mContext;

     private int versionCode=0;

    public UpdateAPKUtil(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 判断是否需要更新
     * @return
     */
    public void hasUpdate(){
        HttpUtil httpUtil=new HttpUtil(mContext);
        String result=httpUtil.getVersionCode();
        JSONUtil jsonUtil=new JSONUtil();
        UpdateMessage message=jsonUtil.getUpdateMessage(result);
        getVersionCode();
        if(message.getVersionCode()>versionCode){//需要更新
            UpdateDialog dialog=new UpdateDialog(mContext);
            dialog.show(message.getMessage());
        }
    }

    /**
     * 获取当前的系统版本
     */
    public void getVersionCode(){
        try {
            versionCode=mContext.getPackageManager().
                    getPackageInfo(mContext.getPackageName(),0).versionCode;
            LogUtil.e(versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
