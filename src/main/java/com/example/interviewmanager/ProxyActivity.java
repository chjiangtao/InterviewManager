package com.example.interviewmanager;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.fragment.AddNewInterviewFragment;
import com.example.interviewmanager.fragment.GuidePageFragment;
import com.example.interviewmanager.fragment.MainFragment;
import com.example.interviewmanager.impl.OnViewClickListener;
import com.example.interviewmanager.single.InterviewSingle;
import com.example.interviewmanager.utils.DBUtil;
import com.example.interviewmanager.utils.LocationUtil;
import com.example.interviewmanager.utils.NetworkUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;



public class ProxyActivity extends FragmentActivity implements  OnViewClickListener {

    private boolean isFrist = true;
    private SharedPreferences sp;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private InterviewMessage interviewMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_proxy);
        EventBus.getDefault().register(this);
        downloadData();
        chooseFragment();

    }

    /**
     * 更新位置、天气等数据
     */
    private void downloadData(){
        if(!NetworkUtil.isNetworkAvailabel(this)){
            Toast.makeText(this, "当前网络故障，请检查网络！", Toast.LENGTH_SHORT).show();
        }
        LocationUtil locationUtil =new LocationUtil(this);
        locationUtil.getLocation();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    private void chooseFragment() {
//        startFragment(new GuidePageFragment());
        startFragment(new GuidePageFragment());
//        sp=getSharedPreferences("firstStart", Context.MODE_PRIVATE);
//        SharedPreferences.Editor edit=sp.edit();
//        isFrist=sp.getBoolean("isFirst",true);
//        if(isFrist){
//           edit.putBoolean("isFirst",false);
//           edit.apply();
//           startFragment(new GuidePageFragment());
//        }else{
//            startFragment(new AdFragment());
//        }
    }

    public void startFragment(Fragment fragment) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(InterviewMessage message) {
        InterviewSingle interviewSingle=InterviewSingle.getIntance();
        startFragment(MainFragment.newInstance(message));
//        interviewMessage=message;
    }

    @Override
    public void onViewClick(View view) {
        switch (view.getId()){
            case R.id.start_main_fragment:
                startFragment(new MainFragment());
                DBUtil util = new DBUtil(ProxyActivity.this);
//                util.insert(null);
                break;
            case R.id.main_fragment_fab:
                startFragment(new AddNewInterviewFragment());
                break;

            case R.id.add_new_inter_view_fragment_back:
            case R.id.ad_fragment_count_down_view:
                startFragment(new MainFragment());
                break;
        }
    }

    @Override
    public void onViewClick(View view, Fragment fragment) {
        switch (view.getId()){
            case R.id.main_fragment_card_view:
                startFragment(fragment);
                break;
        }
    }
}
