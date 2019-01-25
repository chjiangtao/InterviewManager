package com.example.interviewmanager.fragment;


import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.interviewmanager.R;
import com.example.interviewmanager.adapter.RecyclerViewAdapter;
import com.example.interviewmanager.base.BaseFragment;
import com.example.interviewmanager.entity.InterviewMessage;
import com.example.interviewmanager.single.InterviewSingle;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment implements View.OnClickListener{
    private int containerId;
    private DrawerLayout dl;
    private RecyclerView recyclerView;
    private List<String> datas=new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    private RecyclerViewAdapter adapter;
    private InterviewMessage message;
    private List<InterviewMessage> lists;
    private boolean isMoving=false;

    private NavigationView navigationView;

    public static MainFragment newInstance(int containerId) {
        Bundle bundle = new Bundle();
        bundle.putInt("containerId",containerId);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null){
           containerId=bundle.getInt("containerId");
        }
        setHasOptionsMenu(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected boolean onKeyDown(KeyEvent event) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initData(Bundle bundle) {
        lists=LitePal.findAll(InterviewMessage.class,true);
    }

    @Override
    protected void initView() {
        dl=mRootView.findViewById(R.id.drawer_layout);
        floatingActionButton=mRootView.findViewById(R.id.main_fragment_fab);
        floatingActionButton.setOnClickListener(this);
        recyclerView=mRootView.findViewById(R.id.main_fragment_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
        adapter=new RecyclerViewAdapter(lists);
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
                InterviewSingle single=InterviewSingle.getIntance();
                single.setMessages(lists);
                Fragment fragment=ShowInterviewFragment.newInstance(position);
            }
        });

        navigationView=mRootView.findViewById(R.id.main_fragment_left_menu_nv);
        View headerView=navigationView.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.main_fragment_menu_set:
                        Toast.makeText(getActivity(), "点击事件", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.main_fragment_statistics:
                        Toast.makeText(getActivity(), "点击事件", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    protected int getFragmentContainerId() {
        return containerId;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.tool_bar:
//                dl.openDrawer(Gravity.START);
//                break;
            case R.id.main_fragment_fab:
//                InterviewMessageNotification notification=new InterviewMessageNotification(getContext());
//                notification.releaseMessage();
                addFragment(new AddNewInterviewFragment());
                break;
            case R.id.main_fragment_head_image:
                break;
        }
    }

    public void showFABAnimation(View view)
    {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY,pvhZ).setDuration(200).start();
    }

    /**
     * func:隐藏fab的动画
     */

    public void hideFABAnimation(View view)
    {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 0f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 0f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 0f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY,pvhZ).setDuration(200).start();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateEventBus(InterviewMessage message) {
        lists.add(message);
        adapter.notifyDataSetChanged();
    }

}
