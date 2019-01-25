package com.example.interviewmanager.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;


public abstract class BaseActivity extends FragmentActivity {

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Fragment fragment=getSupportFragmentManager().findFragmentById(getLayoutId());
        if(fragment instanceof BaseFragment){
            ((BaseFragment) fragment).onKeyDown(event);
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 获取布局id
     * @return
     */
    protected abstract int getLayoutId();


}
