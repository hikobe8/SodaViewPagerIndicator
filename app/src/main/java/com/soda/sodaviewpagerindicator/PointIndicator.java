package com.soda.sodaviewpagerindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;


/**
 * viewpager点数指示器
 * Created by Ray on 2016/12/5.
 */

public class PointIndicator extends LinearLayout {

    /**
     * 点数
     */
    private int mPointCount;


    public PointIndicator(Context context) {
        this(context, null , 0);
    }

    public PointIndicator(Context context, AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public PointIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.PointIndicator);
        mPointCount = typedArray.getInt(R.styleable.PointIndicator_pointCount, 1);
        typedArray.recycle();
        init();
    }

    private void init() {
        for (int i = 0 ; i < mPointCount; i ++) {
            addView(new PureCircleView(getContext()));
        }
    }

    public void  setSelectedIndex(int index){
        for (int i = 0; i < getChildCount(); i ++) {
            PureCircleView pureCircleView = (PureCircleView) getChildAt(i);
            if (i == index) {
                pureCircleView.selected();
                continue;
            }
            pureCircleView.unSelected();
        }
    }
}
