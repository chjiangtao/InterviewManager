package com.example.interviewmanager.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.interviewmanager.R;
import com.example.interviewmanager.adapter.ViewPagerAdapter;
import com.example.interviewmanager.base.BaseFragment;
import com.example.interviewmanager.custom.Indicator;
import com.example.interviewmanager.transformer.ZoomOutPageTransformer;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;



/**
 * 引导页
 */
public class GuidePageFragment extends BaseFragment {

    private ViewPager vp;
    private Indicator indicator;
    private TextView startFragment;

    private List<View> views=new ArrayList<View>();


    public static GuidePageFragment newInstance(int containerId){
        Bundle bundle=new Bundle();
        bundle.putInt("containerId",containerId);
        GuidePageFragment fragment=new GuidePageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected boolean onKeyDown(KeyEvent event) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_guide_page;
    }

    @Override
    protected void initData(Bundle bundle) {
        views.add(LayoutInflater.from(getActivity()).inflate(R.layout.vp_item_first,null));
        views.add(LayoutInflater.from(getActivity()).inflate(R.layout.vp_item_second,null));
        views.add(LayoutInflater.from(getActivity()).inflate(R.layout.vp_item_three,null));
        views.add(LayoutInflater.from(getActivity()).inflate(R.layout.vp_item_four,null));
    }

    @Override
    protected void initView() {
        indicator=mRootView.findViewById(R.id.fragment_guide_page_indicator);
        vp=mRootView.findViewById(R.id.fragment_guide_page_vp);
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
        vp.setPageTransformer(true, new ZoomOutPageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                rollingPage(page,position);
            }
        });
        vp.setAdapter(adapter);
        startFragment=mRootView.findViewById(R.id.start_main_fragment);
        startFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new String("main"));
            }
        });
    }

    @Override
    protected int getFragmentContainerId() {
        return 0;
    }

    public void rollingPage(View view,float position){
        if(position>=-1&&position<=1){
            view.setPivotX(0);
            if(position<0){
                view.setTranslationX(-position*view.getWidth());
                view.setRotationY(90*position);
                view.setScaleX(1-Math.abs(position));
            }
            else{
                view.setTranslationX(-position*view.getWidth());
            }
        }
    }
}
