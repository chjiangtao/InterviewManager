package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;

import com.example.interviewmanager.R;
import com.example.interviewmanager.base.BaseFragment;
import com.example.interviewmanager.custom.ADCountDownView;

import org.greenrobot.eventbus.EventBus;

/**
 * 广告页
 */
public class AdFragment extends BaseFragment {

    private ADCountDownView adCountDownView;

    private int containerId;

    public static AdFragment newInstance(int containerId){
        Bundle bundle=new Bundle();
        bundle.putInt("containerId",containerId);
        AdFragment adFragment=new AdFragment();
        adFragment.setArguments(bundle);
        return adFragment;
    }

    @Override
    protected boolean onKeyDown(KeyEvent event) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ad;
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adCountDownView=getActivity().findViewById(R.id.ad_fragment_count_down_view);
        adCountDownView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new String("main"));
            }
        });
    }
}
