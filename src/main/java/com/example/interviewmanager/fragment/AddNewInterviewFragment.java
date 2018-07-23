package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewmanager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewInterviewFragment extends Fragment {
    private FragmentTransaction transaction;

    private Toolbar tb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_new_inter_view, container, false);
        tb=view.findViewById(R.id.add_new_interview_fragment_tb);
        tb.setTitle("haha");
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startFragment(new NewInterviewTextFragment());
    }

    public void startFragment(Fragment fragment){
        transaction=getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.add_new_interview_fragment_container,fragment);
        transaction.commit();
    }
}
