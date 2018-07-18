package com.example.interviewmanager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interviewmanager.MainActivity;
import com.example.interviewmanager.ProxyActivity;
import com.example.interviewmanager.R;
import com.example.interviewmanager.adapter.ViewPagerAdapter;
import com.example.interviewmanager.custom.Indicator;
import com.example.interviewmanager.impl.OnButtonClickListener;

import java.util.ArrayList;
import java.util.List;



/**
 * 引导页
 */
public class GuidePageFragment extends Fragment {

    private ViewPager vp;
    private Indicator indicator;
    private TextView startFragment;

    private List<View> views=new ArrayList<View>();

    private OnButtonClickListener onButtonClickListener;
    public GuidePageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_guide_page, container, false);
        indicator=view.findViewById(R.id.fragment_guide_page_indicator);
        vp=view.findViewById(R.id.fragment_guide_page_vp);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicator.setCurrentIndex(position);
                if(position>=views.size()-1){
                    indicator.setVisibility(View.GONE);
                    startFragment.setVisibility(View.VISIBLE);
                }else{
                    indicator.setVisibility(View.VISIBLE);
                    startFragment.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ViewPagerAdapter adapter=new ViewPagerAdapter(views);
        vp.setAdapter(adapter);
        startFragment=view.findViewById(R.id.start_main_fragment);
        startFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(onButtonClickListener!=null){
                     onButtonClickListener.onClick(startFragment,new MainFragment());
                 }
            }
        });
        return view;
    }

    private void initData(){
        views.add(LayoutInflater.from(getActivity()).inflate(R.layout.vp_item_first,null));
        views.add(LayoutInflater.from(getActivity()).inflate(R.layout.vp_item_second,null));
        views.add(LayoutInflater.from(getActivity()).inflate(R.layout.vp_item_three,null));
        views.add(LayoutInflater.from(getActivity()).inflate(R.layout.vp_item_four,null));
    }

    public OnButtonClickListener getOnButtonClick(){
        return onButtonClickListener;
    }
    public void setButtonClickListener(OnButtonClickListener onButtonClickListener){
        Log.e("test","=====================");
        this.onButtonClickListener=onButtonClickListener;
    }
}