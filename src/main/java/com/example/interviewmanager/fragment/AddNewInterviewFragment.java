package com.example.interviewmanager.fragment;



import android.content.Context;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.interviewmanager.R;
import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.impl.OnButtonClickListener;
import com.example.interviewmanager.impl.TransferData;

import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewInterviewFragment extends Fragment implements View.OnClickListener {
    private FragmentTransaction transaction;

    private Toolbar tb;
    private TextView choosewordOrmage;
    private TextView submit;
    private TextView save;
    private boolean isShowImageFragment = false;

    private TextInputEditText companyName;
    private NewInterviewImageFragment imageFragment = new NewInterviewImageFragment();
    private NewInterviewTextFragment textFragment = new NewInterviewTextFragment();

    private TransferData transferData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_inter_view, container, false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startFragment(textFragment);
        isShowImageFragment = true;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        choosewordOrmage = getActivity().findViewById(R.id.add_new_interview_fragment_word_tv);
        choosewordOrmage.setOnClickListener(this);
        submit = getActivity().findViewById(R.id.add_new_interview_fragment_submit);
        submit.setOnClickListener(this);
        save = getActivity().findViewById(R.id.add_new_interview_fragment_save);
        save.setOnClickListener(this);
    }

    public void startFragment(Fragment fragment) {
        transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.add_new_interview_fragment_container, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_new_interview_fragment_word_tv:
                if (isShowImageFragment) {
                    choosewordOrmage.setBackgroundResource(R.drawable.add_new_interview_fragment_word);
                    save.setVisibility(View.GONE);
                    submit.setVisibility(View.VISIBLE);
                    startFragment(imageFragment);
                    isShowImageFragment = false;
                } else {
                    choosewordOrmage.setBackgroundResource(R.drawable.add_new_interview_fragment_camera);
                    startFragment(textFragment);
                    submit.setVisibility(View.GONE);
                    save.setVisibility(View.VISIBLE);
                    isShowImageFragment = true;
                }
                break;
            case R.id.add_new_interview_fragment_save:
               InterviewMessage message= transferData.getInputData();
               Log.e("test","message "+message.getCompanyName());
                break;
            case R.id.add_new_inter_view_fragment_back:

                break;
            case R.id.add_new_interview_fragment_submit:
                break;

        }
    }



    @Override
    public void onAttach(Context context) {
        if(context instanceof OnButtonClickListener){
            transferData=(TransferData)context;
        }else{
            throw new RuntimeException(context.toString()+"must implement TransferData");
        }
        super.onAttach(context);
    }


}
