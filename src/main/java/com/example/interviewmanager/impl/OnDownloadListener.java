package com.example.interviewmanager.impl;

import java.io.File;

/**
 * 下载数据接口
 */
public interface OnDownloadListener {

    void onDownloadcomplete(File file);

    void onDownloading(int progress);

    void onDownloadFailed(Exception e);
}
