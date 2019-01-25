package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interviewmanager.R;
import com.example.interviewmanager.base.BaseFragment;
import com.example.interviewmanager.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment {


    @BindView(R.id.login_fragment_user_name_et)
    TextInputEditText loginFragmentUserNameEt;
    @BindView(R.id.login_fragment_password_et)
    TextInputEditText loginFragmentPasswordEt;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.login_fragment_auto_cb)
    CheckBox loginFragmentAutoCb;
    @BindView(R.id.login_fragment_remember_password)
    CheckBox loginFragmentRememberPassword;
    @BindView(R.id.login_fragment_forget_password)
    TextView loginFragmentForgetPassword;
    @BindView(R.id.login_fragment_cardview)
    CardView loginFragmentCardview;
    @BindView(R.id.fab)
    FloatingActionButton fab;


    private int containerId;

    private  String name=null;

    private  String password=null;

    private SharedPreferencesUtil sp;

    private boolean isCheck=false;

    public static LoginFragment newInstance(int containerId) {
        Bundle bundle = new Bundle();
        bundle.putInt("containerId", containerId);
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            containerId = bundle.getInt("containerId");
        }
        sp=new SharedPreferencesUtil(getActivity(),"login");
    }

    @Override
    protected boolean onKeyDown(KeyEvent event) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initData(Bundle bundle) {
       if (sp.contain("name")){
           name=String.valueOf(sp.get("name",null));
           password=String.valueOf(sp.get("password",null));
           loginFragmentUserNameEt.setText(name);
           loginFragmentPasswordEt.setText(password);
           loginFragmentRememberPassword.setChecked(true);
       }

       if(sp.contain("auto")){

       }
    }

    @Override
    protected void initView() {
        loginFragmentUserNameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                 name=s.toString();
            }
        });
        loginFragmentPasswordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                password=s.toString();
            }
        });

        loginFragmentAutoCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    sp.put("auto","auto");
                }else{
                    sp.removeValueByKey("auto");
                }
            }
        });
        loginFragmentRememberPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheck=isChecked;
                if(isChecked){
                    if(TextUtils.isEmpty(name)||TextUtils.isEmpty(password)){
                        Toast.makeText(getContext(), "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                        return ;
                    }
                     sp.put("name",name);
                     sp.put("password",password);
                }
            }
        });
    }

    @Override
    protected int getFragmentContainerId() {
        return containerId;
    }

    @OnClick({ R.id.login_btn, R.id.login_fragment_auto_cb, R.id.login_fragment_remember_password, R.id.login_fragment_forget_password, R.id.login_fragment_cardview, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                if(TextUtils.isEmpty(name)||TextUtils.isEmpty(password)){
                    Toast.makeText(getContext(), "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(!isCheck){//登录时没有点击保存密码，则清除保存的以前的登录数据
                    sp.clearAll();
                    Log.e("TAG","ischeck");
                }
                break;

            case R.id.login_fragment_forget_password:
                break;

            case R.id.fab:
                break;
        }
    }


}
