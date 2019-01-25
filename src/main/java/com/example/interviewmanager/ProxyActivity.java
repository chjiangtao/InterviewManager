package com.example.interviewmanager;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.interviewmanager.base.BaseActivity;
import com.example.interviewmanager.fragment.AdFragment;
import com.example.interviewmanager.fragment.GuidePageFragment;
import com.example.interviewmanager.fragment.LoginFragment;
import com.example.interviewmanager.utils.LocationUtil;
import com.example.interviewmanager.utils.NetworkUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.LitePal;


public class ProxyActivity extends BaseActivity {

    private int containerId;
    private boolean isFrist = true;
    private SharedPreferences sp;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private long mExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_proxy);
        LitePal.getDatabase();
        containerId=R.id.fragment_container;
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
        sp=getSharedPreferences("firstStart", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sp.edit();
        isFrist=sp.getBoolean("isFirst",true);
        if(isFrist){
           edit.putBoolean("isFirst",false);
           edit.apply();
           startFragment(GuidePageFragment.newInstance(containerId));
        }else{
            startFragment(AdFragment.newInstance(containerId));
        }
    }

    public void startFragment(Fragment fragment) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment).addToBackStack(null);
        transaction.commit();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void startFragment(String message) {
            startFragment(LoginFragment.newInstance(containerId));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if((System.currentTimeMillis()-mExitTime)>3000){
            Toast.makeText(this, "再按一次退出面试管家", Toast.LENGTH_SHORT).show();
            mExitTime=System.currentTimeMillis();
        }else{
            finish();
            System.exit(0);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.id.fragment_container;
    }
}
