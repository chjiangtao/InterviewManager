package com.example.interviewmanager.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;

import com.example.interviewmanager.R;
import com.example.interviewmanager.base.BaseFragment;
import com.example.interviewmanager.utils.ReceiveImageFromCameraUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseHeadImageFragment extends BaseFragment {
    private ReceiveImageFromCameraUtil cameraUtil=new ReceiveImageFromCameraUtil(getActivity());

    public ChooseHeadImageFragment() {
        // Required empty public constructor
    }

    @Override
    protected boolean onKeyDown(KeyEvent event) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_choose_head_image;
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

    private void getCameraImage(){
        startActivityForResult(cameraUtil.getCameraIntent(),1);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
