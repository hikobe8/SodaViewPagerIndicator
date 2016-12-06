package com.soda.sodaviewpagerindicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by soda on 2016/12/6.
 */

public class MViewPager extends ViewPager {
    /**
     * 是否是用户触摸滑动
     */
    private boolean mTouchFromUser;


    public boolean isTouchFromUser() {
        return mTouchFromUser;
    }


    public MViewPager(Context context) {
        super(context);
    }

    public MViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP)
            mTouchFromUser = true;
        return super.onTouchEvent(ev);
    }
}
