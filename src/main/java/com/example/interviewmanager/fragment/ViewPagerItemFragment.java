package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.interviewmanager.R;
import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.single.InterviewSingle;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerItemFragment extends Fragment {

    private int itemPosition=0;

    private TextView id;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_view_pager_item, container, false);
        id=view.findViewById(R.id.id);
        id.setText(mMessageList.get(itemPosition).getCompanyName());
        return view;
    }

}
