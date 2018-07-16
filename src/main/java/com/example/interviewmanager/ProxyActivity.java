package com.example.interviewmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.interviewmanager.fragment.AdFragment;
import com.example.interviewmanager.fragment.GuidePageFragment;
import com.example.interviewmanager.fragment.MainFragment;

public class ProxyActivity extends FragmentActivity {

    private boolean isFrist=true;
    private SharedPreferences sp;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private GuidePageFragment guidePageFragment=new GuidePageFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_proxy);
        guidePageFragment.setOnButtonClick(new GuidePageFragment.OnButtonClick() {
            @Override
            public void onClick(View view) {
                startFragment(new MainFragment());
            }
        });
        chooseFragment();
    }
    private  void chooseFragment(){
        startFragment(guidePageFragment);
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
}
