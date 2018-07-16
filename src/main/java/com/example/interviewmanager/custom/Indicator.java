package com.example.interviewmanager.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.interviewmanager.R;

public class Indicator extends View {
    private int fillColor,strokeColor;
    private int pageNumber;
    private int currentIndex;//当前圆点下标
    private int radius;
    private int distance;//两个圆间的距离
    private Paint mStrokePaint;
    private Paint mFillPaint;
    public Indicator(Context context) {
        this(context,null);
    }

    public Indicator(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Indicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.Indicator);
        fillColor=a.getColor(R.styleable.Indicator_fillColor, Color.parseColor("#F96A0E"));
        strokeColor=a.getColor(R.styleable.Indicator_strokeColor,Color.parseColor("#cecece"));
        pageNumber=a.getInteger(R.styleable.Indicator_pager_number,0);
        radius=a.getDimensionPixelSize(R.styleable.Indicator_radius,10);
        distance=a.getDimensionPixelSize(R.styleable.Indicator_circleInterval,10);
        a.recycle();
        mStrokePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mStrokePaint.setColor(strokeColor);

        mFillPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mFillPaint.setColor(fillColor);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
    }

    private int measureHeight(int heightMeasureSpec) {
        int height=0;
        int mode=MeasureSpec.getMode(heightMeasureSpec);
        int size=MeasureSpec.getSize(heightMeasureSpec);
        if(mode==MeasureSpec.EXACTLY){
            height=size;
        }else{
            height=getPaddingBottom()+getPaddingTop()+radius*2;
            if(mode==MeasureSpec.AT_MOST){
                height=Math.min(height,size);
            }
        }
        return height;
    }

    private int measureWidth(int widthMeasureSpec) {
        int mode=MeasureSpec.getMode(widthMeasureSpec);
        int size=MeasureSpec.getSize(widthMeasureSpec);
        int width=0;
        if(mode==MeasureSpec.EXACTLY){
            width=size;
        }else{
            width=getPaddingLeft()+getPaddingRight()+pageNumber*2*radius+(pageNumber-1)*distance;
            if(mode==MeasureSpec.AT_MOST){
                width=Math.min(width,size);
            }
        }
        return width;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e("test","开始绘制");
        super.onDraw(canvas);
        for (int i=0;i<pageNumber;i++){
            canvas.drawCircle(getPaddingLeft()+radius+(radius*2+distance)*i,
                    getPaddingTop()+radius,radius,mStrokePaint);
        }
        //画当前页的圆
        canvas.drawCircle(getPaddingLeft()+radius+(radius*2+distance)*currentIndex,
                getPaddingTop()+radius,radius,mFillPaint);
    }
    public void setCurrentIndex(int index){
        currentIndex=index;
        Log.e("test","setCurrentIndex "+index);
        invalidate();
    }
}
