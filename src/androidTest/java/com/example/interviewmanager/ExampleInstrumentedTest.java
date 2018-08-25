package com.example.interviewmanager;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.entity.Location;
import com.example.interviewmanager.utils.DBUtil;
import com.example.interviewmanager.utils.LocationUtil;
import com.example.interviewmanager.utils.LogUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private Context context;
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

//        UpdateAPKUtil updateAPKUtil=new UpdateAPKUtil(appContext);
//        updateAPKUtil.getVersionCode();
        assertEquals("com.example.interviewmanager", appContext.getPackageName());
    }

    private void  getContext(){
         context=InstrumentationRegistry.getTargetContext();
    }
    @Test
    public void dbGetAllMessage(){
        getContext();
        DBUtil dbUtil=new DBUtil(context);
        List<InterviewMessage> lists=dbUtil.getAllInterviewMessages();
        LogUtil.e("数据的长度 "+lists.size());
    }

    @Test
    public void getLocation(){
        getContext();
//        LocationUtil locationUtil =new LocationUtil(context);
//        locationUtil.getLocation();
        DBUtil dbUtil=new DBUtil(context);
        Location location=dbUtil.getLocation();
    }
}
