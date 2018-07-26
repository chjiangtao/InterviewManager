package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewmanager.R;
import com.example.interviewmanager.impl.TransferData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewInterviewTextFragment extends Fragment implements TransferData{

    private TextInputEditText companyName;
    private TextInputEditText address;
    private TextInputEditText contact;
    private TextInputEditText telephone;
    private TextInputEditText office;
    private TextInputEditText salary;
    private TextInputEditText data;
    private AddNewInterviewFragment addNewInterviewFragment;

    public NewInterviewTextFragment() {
        // Required empty public constructor

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addNewInterviewFragment=new AddNewInterviewFragment();
//        addNewInterviewFragment.getTransferData(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_new_interview_text, container, false);
        companyName=view.findViewById(R.id.new_interview_text_fragment_companyName);
        address=view.findViewById(R.id.new_interview_text_fragment_address);
        contact=view.findViewById(R.id.new_interview_text_fragment_contact);
        telephone=view.findViewById(R.id.new_interview_text_fragment_telephone);
        office=view.findViewById(R.id.new_interview_text_fragment_office);
        salary=view.findViewById(R.id.new_interview_text_fragment_salary);
        data=view.findViewById(R.id.new_interview_text_fragment_data);
        return view;
    }

    @Override
    public List<Map<String,String>> getInputData() {
        List<Map<String,String>> lists=new ArrayList<>();
        Map<String,String> map=new HashMap<>();
        map.put("companyName",companyName.getText().toString());
        map.put("address",address.getText().toString());
        map.put("contact",contact.getText().toString());
        map.put("telephone",telephone.getText().toString());
        map.put("office",office.getText().toString());
        map.put("salary",salary.getText().toString());
        map.put("data",data.getText().toString());
        lists.add(map);
        return lists;
    }
    

}
