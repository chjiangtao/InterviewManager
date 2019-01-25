package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;

import com.example.interviewmanager.R;
import com.example.interviewmanager.base.BaseFragment;
import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.single.InterviewSingle;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowInterviewFragment extends BaseFragment {

    private int itemPosition=0;
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
            itemPosition=bundle.getInt("position",0);
        }
        InterviewSingle interviewSingle=InterviewSingle.getIntance();
        messageList=interviewSingle.getMessages();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager=getActivity().findViewById(R.id.show_interview_fragment_vp);
        FragmentManager manager=getFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(manager) {
            @Override
            public Fragment getItem(int position) {
                return ViewPagerItemFragment.newInstance(position);
            }

            @Override
            public int getCount() {
                return messageList.size();
            }
        });
        viewPager.setCurrentItem(itemPosition,false);
    }

    @Override
    protected boolean onKeyDown(KeyEvent event) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_show_interview;
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
