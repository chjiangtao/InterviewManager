package com.example.interviewmanager.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class SharedPreferencesUtil {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public SharedPreferencesUtil(Context context,String name) {
       sharedPreferences=context.getSharedPreferences(name,Context.MODE_PRIVATE);
       editor=sharedPreferences.edit();
    }

    /**
     * 保存数据
     * @param key
     * @param object
     */
    public void put(String key,Object object){
        if(object instanceof String){
            editor.putString(key,(String)object);
        }else if(object instanceof Integer){
            editor.putInt(key,(Integer) object);
        }else if(object instanceof Boolean){
            editor.putBoolean(key,(Boolean) object);
        }else if(object instanceof Float){
            editor.putFloat(key,(Float)object);
        }else if (object instanceof Long){
            editor.putLong(key,(Long)object);
        }else{
            editor.putString(key,object.toString());
        }
        editor.commit();
    }

    /**
     * 获取数据
     * @param key
     * @param defaultObject
     * @return
     */
    public Object get(String key,Object defaultObject){
        if(defaultObject instanceof String){
            return sharedPreferences.getString(key,(String)defaultObject);
        }else if(defaultObject instanceof Integer){
            return sharedPreferences.getInt(key,(Integer)defaultObject);
        }else if(defaultObject instanceof Boolean){
            return sharedPreferences.getBoolean(key,(Boolean)defaultObject);
        }else if(defaultObject instanceof Float){
            return sharedPreferences.getFloat(key,(Float)defaultObject);
        }else if(defaultObject instanceof Long){
            return sharedPreferences.getLong(key,(Long)defaultObject);
        }else{
            return sharedPreferences.getString(key,null);
        }
    }

    /**
     * 删除key对应的值
     * @param key
     */
    public void removeValueByKey(String key){
        editor.remove(key);
        editor.commit();
    }

    /**
     * 清除所有数据
      */
    public void clearAll(){
        editor.clear();
        editor.commit();
    }

    /**
     * 查询一个key是否存在
     * @param key
     * @return
     */
    public boolean contain(String key){
        return sharedPreferences.contains(key);
    }

    public Map<String,?> getAll(){
        return sharedPreferences.getAll();
    }
}
