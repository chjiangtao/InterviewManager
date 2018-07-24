package com.example.interviewmanager.fragment;


import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.interviewmanager.R;
import com.example.interviewmanager.adapter.RecyclerViewAdapter;
import com.example.interviewmanager.impl.OnButtonClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener{

    private TextView showLeftMenu;
    private DrawerLayout dl;
    private RecyclerView recyclerView;
    private List<String> datas=new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    private OnButtonClickListener onButtonClickListener;
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
        showLeftMenu=view.findViewById(R.id.main_fragment_show_left_menu_tv);
        showLeftMenu.setOnClickListener(this);
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
                onButtonClickListener.onItemClick(new ShowInterviewFragment(),position);
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_fragment_show_left_menu_tv:
                dl.openDrawer(Gravity.START);
                break;
            case R.id.main_fragment_fab:
                onButtonClickListener.onButtonClick(floatingActionButton,new AddNewInterviewFragment());
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
     * by moos on 2017.8.21
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
        if(context instanceof OnButtonClickListener){
            onButtonClickListener=(OnButtonClickListener)context;
        }else{
            throw new RuntimeException(context.toString()+"must implement OnButtonLinstener");
        }
        super.onAttach(context);
    }
}
