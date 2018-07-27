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

import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.fragment.LoginFragment;
import com.example.interviewmanager.fragment.MainFragment;
import com.example.interviewmanager.fragment.NewInterviewTextFragment;
import com.example.interviewmanager.impl.OnButtonClickListener;
import com.example.interviewmanager.impl.TransferData;
import com.example.interviewmanager.utils.DatabaseUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Map;

public class ProxyActivity extends FragmentActivity implements OnButtonClickListener,TransferData{

    private boolean isFrist=true;
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
//        EventBus.getDefault().register(this);
        chooseFragment();
    }
    private  void chooseFragment(){
//        startFragment(new GuidePageFragment());
        startFragment(new MainFragment());
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
    public void startFragment(Fragment fragment){
        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }

    public void onButtonClick(View view,Fragment fragment) {
        switch (view.getId()){
            case R.id.start_main_fragment:
                startFragment(fragment);
                DatabaseUtil util=new DatabaseUtil(ProxyActivity.this);
//                util.insert(null);
                break;
            case R.id.main_fragment_fab:
                startFragment(fragment);
                break;
        }
    }

    @Override
    public void onItemClick(Fragment fragment, int position) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if(EventBus.getDefault().isRegistered(this)){
//            EventBus.getDefault().unregister(this);
//        }
    }

    @Override
    public InterviewMessage getInputData() {
        NewInterviewTextFragment newInterviewTextFragment=new NewInterviewTextFragment();
        return newInterviewTextFragment.getInputData();
    }
}
