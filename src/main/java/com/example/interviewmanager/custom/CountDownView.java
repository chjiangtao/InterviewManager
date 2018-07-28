package com.example.interviewmanager.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * 倒计时
 */
public class CountDownView extends View {

    public CountDownView(Context context) {
        this(context,null);
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    }
}
