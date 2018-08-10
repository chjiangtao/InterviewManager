package com.example.interviewmanager.utils;

import android.util.Log;

import com.example.interviewmanager.entity.CurrentDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间相关
 */
public class DateUtil {
    private Calendar cal;

    public DateUtil() {
        cal=Calendar.getInstance();
    }

    /**
     * 获取系统当前时间
     * @return
     */
    public CurrentDate getCurrentTime(){
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        int minute=cal.get(Calendar.MINUTE);
        CurrentDate date=new CurrentDate(year,month,day,hour,minute);
        System.out.print(date.toString());
        return date;
    }

    /**
     * 获取倒计时的时间
     * @param time
     * @return
     */
    public CurrentDate countDownTime(String time){
        Calendar iterviewTime=Calendar.getInstance();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            iterviewTime.setTime(format.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long difference=iterviewTime.getTimeInMillis()-cal.getTimeInMillis();
        if(difference<0){//过了面试时间
            return null;
        }
        int second= (int) (difference/1000);
        return null;
    }
}
