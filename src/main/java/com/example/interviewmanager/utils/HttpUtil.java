package com.example.interviewmanager.utils;

import android.util.Log;

import com.example.interviewmanager.constant.Constant;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {


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


}
