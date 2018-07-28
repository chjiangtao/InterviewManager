package com.example.interviewmanager.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ADCountDownCircleView extends View {
    private String close="关闭";
    private Paint mPaint;
    private int distance=5;

    public ADCountDownCircleView(Context context) {
        this(context,null);
    }

    public ADCountDownCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ADCountDownCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(50);
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
        canvas.drawText(close,x,y,mPaint);
        canvas.drawCircle(rect.centerX(),rect.centerY(),getCircleRadius(),mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int radius=getCircleRadius();
        int rectWidth=radius+distance*2;
        int rectHeight=rectWidth;
        int width=MeasureWidth(widthMeasureSpec,rectWidth);
        int height=MeasureHeight(heightMeasureSpec,rectHeight);
        setMeasuredDimension(width,height);
    }

    private int MeasureWidth(int widthMeasureSpec, int rectWidth) {
        int mode=MeasureSpec.getMode(widthMeasureSpec);
        int size=MeasureSpec.getSize(widthMeasureSpec);
        int width=0;
        if(mode==MeasureSpec.EXACTLY){//Math_parent或者具体值
            width=size;
        }else if(mode==MeasureSpec.AT_MOST){//wrap_content
            width=rectWidth;
        }
        return width;
    }
    private int MeasureHeight(int heightMeasureSpec, int rectHeight) {
        int mode=MeasureSpec.getMode(heightMeasureSpec);
        int size=MeasureSpec.getSize(heightMeasureSpec);
        int height=0;
        if(mode==MeasureSpec.EXACTLY){//Math_parent或者具体值
            height=size;
        }else if(mode==MeasureSpec.AT_MOST){//wrap_content
            height=rectHeight;
        }
        return height;
    }

    private Rect getTextRect(){
        Rect rect=new Rect();
        mPaint.getTextBounds(close,0,close.length(),rect);
        return rect;
    }
    /**
     * 返回内圆半径
     * @return
     */
    private int getCircleRadius(){
        Rect rect=getTextRect();
        int width=rect.width();
        int height=rect.height();
        double length= Math.ceil(Math.sqrt(Math.pow(width,2)+Math.pow(height,2)));
        return (int) Math.ceil(length/2);
    }
}
