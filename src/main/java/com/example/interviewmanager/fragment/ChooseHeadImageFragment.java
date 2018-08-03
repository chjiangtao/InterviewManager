package com.example.interviewmanager.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewmanager.R;
import com.example.interviewmanager.utils.ReceiveImageFromCameraUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseHeadImageFragment extends Fragment {
    private ReceiveImageFromCameraUtil cameraUtil=new ReceiveImageFromCameraUtil(getActivity());

    public ChooseHeadImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_choose_head_image, container, false);

        return view;
    }

    private void getCameraImage(){
        startActivityForResult(cameraUtil.getCameraIntent(),1);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
