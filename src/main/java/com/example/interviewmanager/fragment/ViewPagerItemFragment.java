package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;

import com.example.interviewmanager.R;
import com.example.interviewmanager.base.BaseFragment;
import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.single.InterviewSingle;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerItemFragment extends BaseFragment {

    private int itemPosition=0;

    private List<InterviewMessage> mMessageList;

    public static ViewPagerItemFragment newInstance(int position) {
        Bundle args = new Bundle();
        ViewPagerItemFragment fragment = new ViewPagerItemFragment();
        args.putInt("position",position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null){
            itemPosition=bundle.getInt("position");
        }
        InterviewSingle interviewSingle=InterviewSingle.getIntance();
        mMessageList=interviewSingle.getMessages();
    }

    @Override
    protected boolean onKeyDown(KeyEvent event) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_view_pager_item;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getFragmentContainerId() {
        return 0;
    }

}
