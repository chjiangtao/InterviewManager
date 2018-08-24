package com.example.interviewmanager.entity;

/**
 * 更新
 */
public class UpdateMessage {
    private int versionCode;
    private String message;

    public UpdateMessage(int versionCode, String message) {
        this.versionCode = versionCode;
        this.message = message;
    }

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
