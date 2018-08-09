package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewmanager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowInterviewFragment extends Fragment {

    private int position;
    public static ShowInterviewFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        ShowInterviewFragment fragment = new ShowInterviewFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        position=bundle.getInt("position",0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_show_interview, container, false);
        return view;
    }

}
