package com.example.interviewmanager.impl;

import android.support.v4.app.Fragment;
import android.view.View;

public interface OnViewClickListener {
    void onViewClick(View view);
    void onViewClick(View view, Fragment fragment);
}
