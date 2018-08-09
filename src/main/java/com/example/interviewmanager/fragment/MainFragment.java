package com.example.interviewmanager.fragment;


import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.interviewmanager.R;
import com.example.interviewmanager.adapter.RecyclerViewAdapter;
import com.example.interviewmanager.impl.OnViewClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener{

    private DrawerLayout dl;
    private RecyclerView recyclerView;
    private List<String> datas=new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    private OnViewClickListener onViewClickListener;
    private RecyclerViewAdapter adapter;


    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        initData();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main, container, false);

        dl=view.findViewById(R.id.drawer_layout);
        floatingActionButton=view.findViewById(R.id.main_fragment_fab);
        floatingActionButton.setOnClickListener(this);
        recyclerView=view.findViewById(R.id.main_fragment_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
        adapter=new RecyclerViewAdapter(datas);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                 Log.e("test","点击了"+position);
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.tool_bar:
//                dl.openDrawer(Gravity.START);
//                break;
            case R.id.main_fragment_fab:
                onViewClickListener.onViewClick(floatingActionButton);
                break;
            case R.id.main_fragment_head_image:
                break;
        }
    }

    private void initData(){
        for(int i=0;i<100;i++){
            datas.add("数据"+i);
        }
    }

    public void showFABAnimation(View view)
    {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY,pvhZ).setDuration(400).start();
    }

    /**
     * func:隐藏fab的动画
     */

    public void hideFABAnimation(View view)
    {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 0f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 0f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 0f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY,pvhZ).setDuration(400).start();
    }

    @Override
    public void onAttach(Context context) {
        if(context instanceof OnViewClickListener){
            onViewClickListener=(OnViewClickListener)context;
        }else{
            throw new RuntimeException(context.toString()+"must implement OnButtonLinstener");
        }
        super.onAttach(context);
    }
}
