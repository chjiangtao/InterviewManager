package com.example.interviewmanager.utils;

import android.content.Context;

/**
 *
 */
public class FileUtil {
    private Context mContext;
    private String path;
    public FileUtil(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 获取APP的files目录 /data/data/<application package>/files
     * @return
     */
    public String getFilePath(){
        path=mContext.getFilesDir().getPath();
        return path;
    }


    public
}
