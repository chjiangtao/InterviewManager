package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewmanager.R;
import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.single.InterviewSingle;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowInterviewFragment extends Fragment {

    private int position=0;
    private List<InterviewMessage> messageList;

    private ViewPager viewPager;
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
        if(bundle!=null){
            position=bundle.getInt("position",0);
        }
        InterviewSingle interviewSingle=InterviewSingle.getIntance();
        messageList=interviewSingle.getMessages();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_show_interview, container, false);
        viewPager=view.findViewById(R.id.show_interview_fragment_vp);
        return view;
    }

}
