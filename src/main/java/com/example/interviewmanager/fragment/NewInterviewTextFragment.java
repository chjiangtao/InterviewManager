package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.interviewmanager.R;
import com.example.interviewmanager.entity.InterviewMessage;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewInterviewTextFragment extends Fragment {

    private EditText companyNameet;
    private EditText addresset;
    private EditText contactet;
    private EditText telephoneet;
    private EditText officeet;
    private EditText salaryet;
    private EditText dateet;
    private  String companyName;
//    private String address;
//    private String contact;
//    private String telephone;
//    private String office;
//    private String salary;
//    private String date;
    private InterviewMessage message=new InterviewMessage();

    public NewInterviewTextFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_new_interview_text, container, false);
        companyNameet= view.findViewById(R.id.new_interview_text_fragment_companyName);
        companyNameet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                 companyName=editable.toString();
                 Log.e("test",""+companyName);
            }
        });
        addresset=view.findViewById(R.id.new_interview_text_fragment_address);
        contactet=view.findViewById(R.id.new_interview_text_fragment_contact);
        telephoneet=view.findViewById(R.id.new_interview_text_fragment_telephone);
        officeet=view.findViewById(R.id.new_interview_text_fragment_office);
        salaryet=view.findViewById(R.id.new_interview_text_fragment_salary);
        dateet=view.findViewById(R.id.new_interview_text_fragment_data);

        return view;
    }

    public InterviewMessage getInputData() {
        message.setCompanyName("hahahah");
        return message;
    }

}
