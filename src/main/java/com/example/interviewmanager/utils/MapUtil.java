package com.example.interviewmanager.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 地图相关
 */
public class MapUtil {
    private Context mContext;

    public MapUtil(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 检查是否安装特定apk
     * @param packageName
     * @return
     */
    private boolean isAvilible(String packageName){
        final PackageManager packageManager=mContext.getPackageManager();
        List<PackageInfo> packageInfos=packageManager.getInstalledPackages(0);
        List<String> packageNames=new ArrayList<>();
        if(packageInfos!=null){
            for (int i=0;i<packageInfos.size();i++){
                String pName=packageInfos.get(i).packageName;
                packageNames.add(pName);
            }
        }
        return packageNames.contains(packageName);
    }



}
