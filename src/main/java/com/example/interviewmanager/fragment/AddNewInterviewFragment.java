package com.example.interviewmanager.fragment;



import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interviewmanager.R;
import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.utils.DBUtil;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewInterviewFragment extends Fragment implements View.OnClickListener {
    private FragmentTransaction transaction;

    private View view;
    private Toolbar tb;
    private TextView choosewordOrmage;
    private TextView submit;
    private TextView save;
    private boolean isShowImageFragment = false;
    private TextView back;

    private EditText companyNameET;
    private EditText addressET;
    private EditText contactET;
    private EditText telephoneET;
    private EditText officeET;
    private EditText salaryET;
    private EditText dateET;
    private EditText remarkET;

    private String companyName;
    private String address;
    private String contact;
    private String telephone;
    private String office;
    private String salary;
    private String date;
    private String remark;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_new_inter_view, container, false);
        changeView(1);
        companyNameET=view.findViewById(R.id.new_interview_text_companyName);
        companyNameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                companyName=s.toString();
            }
        });
        addressET=view.findViewById(R.id.new_interview_text_address);
        addressET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                address=s.toString();
            }
        });
        contactET=view.findViewById(R.id.new_interview_text_contact);
        contactET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                contact=s.toString();
            }
        });
        telephoneET=view.findViewById(R.id.new_interview_text_telephone);
        telephoneET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                telephone=s.toString();
            }
        });
        officeET=view.findViewById(R.id.new_interview_text_office);
        officeET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                  office=s.toString();
            }
        });
        salaryET=view.findViewById(R.id.new_interview_text_salary);
        salaryET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                salary=s.toString();
            }
        });
        dateET=view.findViewById(R.id.new_interview_text_date);
        dateET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                 date=s.toString();
            }
        });
        remarkET=view.findViewById(R.id.new_interview_text_remark);
        remarkET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                remark=s.toString();
            }
        });
        return view;
    }

    /**
     * 切换View   1  显示文字View  2   显示图片View
     * @param type
     */
    private void changeView(int type){
        FrameLayout frameLayout=view.findViewById(R.id.add_new_interview_fragment_container);
        int id = 0;
        switch (type){
            case 1:
                id=R.layout.new_interview_text;
                break;
            case 2:
                id=R.layout.new_interview_image;
                break;
        }
        View textView=getLayoutInflater().inflate(id,frameLayout,false);
        frameLayout.addView(textView);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        back=getActivity().findViewById(R.id.add_new_inter_view_fragment_back);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_new_interview_fragment_word_tv:
                if (isShowImageFragment) {
                    choosewordOrmage.setBackgroundResource(R.drawable.add_new_interview_fragment_word);
                    save.setVisibility(View.GONE);
                    submit.setVisibility(View.VISIBLE);
                    isShowImageFragment = false;
                } else {
                    choosewordOrmage.setBackgroundResource(R.drawable.add_new_interview_fragment_camera);
                    submit.setVisibility(View.GONE);
                    save.setVisibility(View.VISIBLE);
                    isShowImageFragment = true;
                }
                break;
            case R.id.add_new_interview_fragment_save:
                if(TextUtils.isEmpty(companyName)){
                    Toast.makeText(getContext(), "公司名不能为空！", Toast.LENGTH_SHORT).show();
                    break;
                }
                InterviewMessage interviewMessage=new InterviewMessage();
                DBUtil dbUtil=new DBUtil(getContext());
                interviewMessage.setCompanyName(companyName);
                interviewMessage.setAddress(address);
                interviewMessage.setDate(date);
                interviewMessage.setSalary(salary);
                interviewMessage.setOffice(office);
                interviewMessage.setTelephone(telephone);
                interviewMessage.setContact(contact);
                interviewMessage.setRemark(remark);
                boolean success=dbUtil.insert(interviewMessage);
                //关闭软键盘
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(getContext().INPUT_METHOD_SERVICE);
                 if(imm.isActive()&&getActivity().getCurrentFocus()!=null){
                     if(getActivity().getCurrentFocus().getWindowToken()!=null){
                         imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                                 InputMethodManager.HIDE_NOT_ALWAYS);
                     }
                 }
                if (success){
                    Toast.makeText(getContext(), "新增计划成功！", Toast.LENGTH_SHORT).show();
                    EventBus.getDefault().post(interviewMessage);
                }else{
                    Toast.makeText(getContext(), "新增计划失败！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.add_new_inter_view_fragment_back:

                break;
            case R.id.add_new_interview_fragment_submit:
                break;

        }
    }
}
