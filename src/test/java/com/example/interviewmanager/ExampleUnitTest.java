package com.example.interviewmanager;

import android.util.Log;

import com.example.interviewmanager.entity.CurrentDate;
import com.example.interviewmanager.utils.DateUtil;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getDate(){
        String temp="2018-8-11 11:50:00";
        DateUtil dateUtil=new DateUtil();
        CurrentDate date=dateUtil.countDownTime(temp);
    }
}