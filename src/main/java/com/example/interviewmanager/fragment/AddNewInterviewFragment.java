package com.example.interviewmanager.fragment;



import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interviewmanager.R;
import com.example.interviewmanager.base.BaseFragment;
import com.example.interviewmanager.entity.InterviewMessage;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewInterviewFragment extends BaseFragment implements View.OnClickListener {
    private FragmentTransaction transaction;

    private TextView choosewordOrimage;
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
    protected boolean onKeyDown(KeyEvent event) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_add_new_inter_view;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView() {
        changeView(1);
        companyNameET=mRootView.findViewById(R.id.new_interview_text_companyName);
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
        addressET=mRootView.findViewById(R.id.new_interview_text_address);
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
        contactET=mRootView.findViewById(R.id.new_interview_text_contact);
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
        telephoneET=mRootView.findViewById(R.id.new_interview_text_telephone);
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
        officeET=mRootView.findViewById(R.id.new_interview_text_office);
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
        salaryET=mRootView.findViewById(R.id.new_interview_text_salary);
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
        dateET=mRootView.findViewById(R.id.new_interview_text_date);
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
        remarkET=mRootView.findViewById(R.id.new_interview_text_remark);
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
        choosewordOrimage = mRootView.findViewById(R.id.add_new_interview_fragment_word_tv);
        choosewordOrimage.setOnClickListener(this);
        submit = mRootView.findViewById(R.id.add_new_interview_fragment_submit);
        submit.setOnClickListener(this);
        save = mRootView.findViewById(R.id.add_new_interview_fragment_save);
        save.setOnClickListener(this);
        back=mRootView.findViewById(R.id.add_new_inter_view_fragment_back);
        back.setOnClickListener(this);
    }

    @Override
    protected int getFragmentContainerId() {
        return 0;
    }

    /**
     * 切换View   1  显示文字View  2   显示图片View
     * @param type
     */
    private void changeView(int type){
        FrameLayout frameLayout=mRootView.findViewById(R.id.add_new_interview_fragment_container);
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


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_new_interview_fragment_word_tv:
                if (isShowImageFragment) {
                    choosewordOrimage.setBackgroundResource(R.drawable.add_new_interview_fragment_word);
                    save.setVisibility(View.GONE);
                    submit.setVisibility(View.VISIBLE);
                    isShowImageFragment = false;
                } else {
                    choosewordOrimage.setBackgroundResource(R.drawable.add_new_interview_fragment_camera);
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
                interviewMessage.setCompanyName(companyName);
                interviewMessage.setAddress(address);
                interviewMessage.setDate(date);
                interviewMessage.setSalary(salary);
                interviewMessage.setOffice(office);
                interviewMessage.setTelephone(telephone);
                interviewMessage.setContact(contact);
                interviewMessage.setRemark(remark);
                boolean success=interviewMessage.save();
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
