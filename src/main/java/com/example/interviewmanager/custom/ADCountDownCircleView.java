package com.example.interviewmanager.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

public class ADCountDownCircleView extends View {
    private String close="关闭";
    private Paint mPaint;
    private Paint mTextPaint;
    private int screenWidth;
    private int screenHeight;
    private int rectHeight;
    int width;
    private Context context;
    public ADCountDownCircleView(Context context) {
        this(context,null);
    }

    public ADCountDownCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ADCountDownCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        setBackgroundColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect=getTextRect();
        int width=getMeasuredWidth();
        int height=getMeasuredHeight();
        Paint.FontMetrics fontMetrics=mTextPaint.getFontMetrics();
        int x=(width-rect.width())/2;
        int y=(int)(height/2+(fontMetrics.descent-fontMetrics.ascent)
                /2-fontMetrics.descent);
        canvas.drawText(close,x,y,mTextPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        canvas.drawCircle(width/2,width/2,width/2-3,mPaint);
    }

    private void refitText(int height){
        if(height>0){
            int trySize=height;
            mTextPaint.setTextSize(trySize);
            int availableHeight=height-this.getPaddingTop()-this.getPaddingBottom();
            Log.e("test","mTextPaint.descent() "+mTextPaint.descent()+" mTextPaint.ascent() "+mTextPaint.ascent()+"availableHeight "+availableHeight);
            while(mTextPaint.descent()-mTextPaint.ascent()>availableHeight){
                trySize-=1;
                Log.e("test","trySize  "+trySize);
                mTextPaint.setTextSize(px2sp(trySize));
                Log.e("test","mTextPaint.descent() "+mTextPaint.descent()+" mTextPaint.ascent() "+mTextPaint.ascent());
            }

        }
    }

    private float px2sp(float pxValue){
        float fontScale=context.getResources().getDisplayMetrics().scaledDensity;
        return (pxValue/fontScale);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(h!=oldh){
            refitText(h);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int radius=getCircleRadius();
        int rectWidth=radius*2;
        rectHeight=rectWidth;
        width=MeasureWidth(widthMeasureSpec,rectWidth);
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
        mTextPaint.getTextBounds(close,0,close.length(),rect);
        return rect;
    }
    /**
     * 返回圆半径
     * @return
     */
    private int getCircleRadius(){
        Rect rect=getTextRect();
        int width=rect.width();
        int height=rect.height();
        double length= Math.ceil(Math.sqrt(Math.pow(width,2)+Math.pow(height,2)));
        return (int) Math.ceil(length/2);
    }

    /**
     * 获取屏幕的宽高
     */
    private void getScreenWidthAndHeight(){
        DisplayMetrics dm=getResources().getDisplayMetrics();
        screenWidth=dm.widthPixels;
        screenHeight=dm.heightPixels;
    }
}
