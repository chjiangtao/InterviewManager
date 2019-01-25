package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.view.KeyEvent;

import com.example.interviewmanager.R;
import com.example.interviewmanager.base.BaseFragment;

/**
 * 统计
 */
public class StatisticsFragment extends BaseFragment {


    public StatisticsFragment() {
        // Required empty public constructor
    }

    @Override
    protected boolean onKeyDown(KeyEvent event) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_statistics;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getFragmentContainerId() {
        return 0;
    }

}
