package com.example.interviewmanager.impl;

import android.support.v4.app.Fragment;
import android.view.View;

public interface OnButtonClickListener {
    void onClick(View view,Fragment fragment);
    void onItemClick(Fragment fragment,int position);
}
