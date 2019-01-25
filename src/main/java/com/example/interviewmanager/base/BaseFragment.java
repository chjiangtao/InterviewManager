package com.example.interviewmanager.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * created by 道长 at 2018/8/27
 */
public abstract class BaseFragment extends Fragment {


    protected View mRootView;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView=inflater.inflate(getLayoutId(),null);
        unbinder=ButterKnife.bind(this,mRootView);
        initData(getArguments());
        initView();
        return mRootView;
    }

    public void addFragment(BaseFragment fragment){
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(getFragmentContainerId(),fragment).hide(this).addToBackStack(null).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected abstract boolean onKeyDown(KeyEvent event);

    protected abstract int getLayoutId();

    protected abstract void initData(Bundle bundle);

    protected abstract void initView();

    protected abstract int getFragmentContainerId();
}
