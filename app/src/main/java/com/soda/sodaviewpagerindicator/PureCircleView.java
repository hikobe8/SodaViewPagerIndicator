package com.soda.sodaviewpagerindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Ray on 2016/12/5.
 */

public class PureCircleView extends View {


    //默认颜色为红色
    int mColor = Color.RED;
    //设置抗锯齿
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mSelectedColor = Color.BLUE;
    private int mUnSelectedColor = mColor;

    public PureCircleView(Context context) {
        super(context);
        init();
    }


    public PureCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PureCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        paint.setColor(mColor);
    }

    /**
     * 支持wrap_content 和 padding
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            //宽高都为wrap_content, 默认宽高为50
            setMeasuredDimension(50, 50);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(50, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, 50);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;
        int radius = Math.min(width , height) / 2;
        canvas.drawCircle(paddingLeft + width/2, paddingTop + height/2, radius, paint);
    }

    /**
    * 被选中
    */
    public void selected(){
        mColor = mSelectedColor;
        paint.setColor(mColor);
        invalidate();
    }

    public void unSelected(){
        mColor = mUnSelectedColor;
        paint.setColor(mColor);
        invalidate();
    }

    public int getSelectedColor() {
        return mSelectedColor;
    }

    public void setSelectedColor(int selectedColor) {
        mSelectedColor = selectedColor;
    }

    public int getUnSelectedColorColor() {
        return mUnSelectedColor;
    }

    public void setUnSelectedColorColor(int color) {
        mUnSelectedColor = color;
    }

    /*private int mRadius = 5;
    private int mSelectedColor;
    private int mUnSelectedColor;
    private int mColor;

    public PureCircleView(Context context) {
        this(context, null, 0);
    }

    public PureCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PureCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //TODO XML获取属性
        mColor = Color.RED;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRadius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mRadius, new DisplayMetrics());
        Paint paint = new Paint();
        paint.setColor(mColor);
        canvas.drawCircle(getWidth()/2, getHeight()/2, mRadius, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(50, 50);
    }

    public int getRadius() {
        return mRadius;
    }

    public void setRadius(int radius) {
        mRadius = radius;
    }

*/

}
