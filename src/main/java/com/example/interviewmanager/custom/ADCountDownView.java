package com.example.interviewmanager.custom;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.interviewmanager.impl.OnViewClickListener;

/**
 * 广告页的倒计时
 */
public class ADCountDownView extends View{
    private String prompt="关闭|";
    private int minNumber=0;
    private Paint mPaint;
    private OnViewClickListener onViewClickListener;

    public ADCountDownView(Context context) {
        this(context,null);
    }

    public ADCountDownView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ADCountDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(30);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Rect rect=getTextRect();
        int textWidth=rect.width();
        int textHeight=rect.height();
        int width=measureWidth(widthMeasureSpec,textWidth);
        int height=measureHeight(heightMeasureSpec,textHeight);
        setMeasuredDimension(width,height);
    }

    private int measureHeight(int heightMeasureSpec, int textHeight) {
        int mode=MeasureSpec.getMode(heightMeasureSpec);
        int size=MeasureSpec.getSize(heightMeasureSpec);
        int height=0;
        if(mode==MeasureSpec.EXACTLY){//match_parent或者具体值
            height=size;
        }else if(mode==MeasureSpec.AT_MOST){
            height=textHeight+getPaddingBottom()+getPaddingTop();
        }
        return height;

    }

    private int measureWidth(int widthMeasureSpec, int textWidth) {
        int mode=MeasureSpec.getMode(widthMeasureSpec);
        int size=MeasureSpec.getSize(widthMeasureSpec);
        int width=0;
        if(mode==MeasureSpec.EXACTLY){//match_parent或者具体值
            width=size;
        }else if(mode==MeasureSpec.AT_MOST){
            width=textWidth+getPaddingLeft()+getPaddingRight();
        }
        return width;
    }

    private Rect getTextRect(){
        Rect rect=new Rect();
        mPaint.getTextBounds(prompt,0,prompt.length(),rect);
        return rect;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect=getTextRect();
        int width=getMeasuredWidth();
        int height=getMeasuredHeight();
        Paint.FontMetrics fontMetrics=mPaint.getFontMetrics();
        int x=(width-rect.width())/2;
        int y=(int)(height/2+(fontMetrics.descent-fontMetrics.ascent)
                /2-fontMetrics.descent);
        canvas.drawText(prompt,x,y,mPaint);
    }


    private void startCountDown(){
        ValueAnimator animator=ValueAnimator.ofInt(5,0);
        animator.setDuration(6000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer value= (Integer) valueAnimator.getAnimatedValue();
                prompt="关闭|"+value+"s";
                postInvalidate();
                if(minNumber==value){
                    Log.e("test","minNumber "+minNumber+" value "+value);
                    onViewClickListener.onViewClick(ADCountDownView.this);
                }
            }
        });
        animator.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                onViewClickListener.onViewClick(this);
                break;
        }
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        startCountDown();
    }

    public void setOnViewClickListener(OnViewClickListener onViewClickListener){
        this.onViewClickListener=onViewClickListener;
    }

}
