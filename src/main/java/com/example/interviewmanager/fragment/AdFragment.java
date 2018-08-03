package com.example.interviewmanager.fragment;


import android.content.Context;
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
    private OnButtonClickListener onButtonClickListener;

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
        adCountDownView.setOnViewClickListener(new ADCountDownView.OnViewClickListener() {
            @Override
            public void onViewClick(View view) {
//                 onButtonClickListener.onButtonClick(view);

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        if(context instanceof OnButtonClickListener){
            onButtonClickListener=(OnButtonClickListener)context;
        }else{
            throw new RuntimeException(context.toString()+" must implement OnButtonLinstener");
        }
        super.onAttach(context);
    }
}
