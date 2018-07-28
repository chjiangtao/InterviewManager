package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewmanager.R;
import com.example.interviewmanager.custom.ADCountDownView;
import com.example.interviewmanager.impl.OnButtonClickListener;

/**
 * 广告页
 */
public class AdFragment extends Fragment {

    private ADCountDownView adCountDownView;
    public AdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ad, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adCountDownView=getActivity().findViewById(R.id.ad_fragment_count_down_view);
        adCountDownView.setOnButtonClickListener(new OnButtonClickListener() {
            @Override
            public void onButtonClick(View view, Fragment fragment) {

            }

            @Override
            public void onItemClick(Fragment fragment, int position) {

            }

            @Override
            public void onButtonClick(View view) {
                Log.e("test","======================");
            }
        });
    }
}
