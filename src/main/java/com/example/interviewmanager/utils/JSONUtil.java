package com.example.interviewmanager.utils;

import com.example.interviewmanager.entity.UpdateMessage;
import com.google.gson.Gson;

public class JSONUtil {

    /**
     * 解析更新数据
     * @param data
     * @return
     */
    public UpdateMessage getUpdateMessage(String data){
        Gson gson=new Gson();
        UpdateMessage message=gson.fromJson(data,UpdateMessage.class);
        return message;
    }
}
