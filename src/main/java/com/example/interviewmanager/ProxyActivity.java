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

import com.example.interviewmanager.entity.EventMessage;
import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.fragment.AdFragment;
import com.example.interviewmanager.fragment.AddNewInterviewFragment;
import com.example.interviewmanager.fragment.GuidePageFragment;
import com.example.interviewmanager.fragment.LoginFragment;
import com.example.interviewmanager.fragment.MainFragment;
import com.example.interviewmanager.fragment.NewInterviewTextFragment;
import com.example.interviewmanager.impl.OnViewClickListener;
import com.example.interviewmanager.impl.TransferData;
import com.example.interviewmanager.utils.DatabaseUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;



public class ProxyActivity extends FragmentActivity implements  TransferData,OnViewClickListener {

    private boolean isFrist = true;
    private SharedPreferences sp;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private TransferData transferData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_proxy);
        EventBus.getDefault().register(this);
        chooseFragment();
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

    @Override
    public InterviewMessage getInputData() {
        NewInterviewTextFragment newInterviewTextFragment = new NewInterviewTextFragment();
        return newInterviewTextFragment.getInputData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(EventMessage message) {
//         if(){
//
//         }
    }

    @Override
    public void onViewClick(View view) {
        switch (view.getId()){
            case R.id.start_main_fragment:
                startFragment(new MainFragment());
                DatabaseUtil util = new DatabaseUtil(ProxyActivity.this);
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
}
