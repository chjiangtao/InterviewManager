package com.example.interviewmanager.entity;

import org.litepal.crud.LitePalSupport;

/**
 * 更新
 */
public class UpdateMessage extends LitePalSupport {

    private int versionCode;

    private String message;

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
