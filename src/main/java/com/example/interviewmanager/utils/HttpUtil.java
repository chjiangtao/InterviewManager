package com.example.interviewmanager.utils;

import android.content.Context;
import android.util.Log;

import com.example.interviewmanager.constant.Constant;
import com.example.interviewmanager.impl.OnDownloadListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {

    private Context mContext;

    public HttpUtil(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 验证用户名和密码
     * @param name
     * @param password
     * @return
     */
    public boolean login(String name,String password){
        OkHttpClient client=new OkHttpClient();
        RequestBody body=new FormBody.Builder()
                .add("name",name)
                .add("password",password)
                .build();
        Request request=new Request.Builder()
                .url(Constant.LOGIN_URL)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Headers headers=response.headers();
                 for(int i=0;i<headers.size();i++){
                     Log.e("test",headers.name(i)+" "+headers.value(i));
                 }
                 Log.e("test","onResponse: "+response.body().string());
            }
        });
       return false;
    }

    /**
     * 获取服务器端的版本
     * @return
     */
    public String getVersionCode(){
        int version=0;
        String result=null;
        OkHttpClient client=new OkHttpClient();
        RequestBody body=new FormBody.Builder()
                .add("code", String.valueOf(version))
                .build();
        Request request=new Request.Builder()
                .url(Constant.UPDATE_URL)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
        return result;
    }

    /**
     * 下载新版本的apk
     */
    public void downloadAPK(final String fileName, final OnDownloadListener onDownloadListener){
        OkHttpClient client=new OkHttpClient();
        FileUtil fileUtil=new FileUtil(mContext);
        final String dir=fileUtil.getFilePath();
        Request request=new Request.Builder().url(Constant.DOWNLOAD_APK_URL).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //下载失败
                onDownloadListener.onDownloadFailed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is=null;
                byte[] buf=new byte[2048];
                int len=0;
                FileOutputStream fileOutputStream=null;
                File file=new File(dir);
                if(!file.exists()){
                    file.mkdirs();
                }
                File dataFile=new File(file,fileName);
                try {
                    is=response.body().byteStream();
                    long total=response.body().contentLength();
                    fileOutputStream=new FileOutputStream(dataFile);
                    long sum=0;
                    while((len=is.read(buf))!=-1){
                        fileOutputStream.write(buf,0,len);
                        sum+=len;
                        int progress=(int)(sum*1.0f/total*100);
                        //更新进度条
                        onDownloadListener.onDownloading(progress);
                    }
                    onDownloadListener.onDownloadcomplete(dataFile);
                }catch (Exception e){
                    onDownloadListener.onDownloadFailed(e);
                }finally {
                    try{
                        if(is!=null){
                            is.close();
                        }
                    }catch (IOException e){

                    }
                    try{
                        if(fileOutputStream!=null){
                            fileOutputStream.close();
                        }
                    }catch (IOException e){

                    }
                }

            }
        });
    }
}
