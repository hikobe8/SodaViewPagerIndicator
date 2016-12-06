package com.soda.sodaviewpagerindicator;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soda on 2016/12/6.
 */

public class ViewPagerIndicator extends RelativeLayout {

    private PagerAdapter mPageAdapter;
    private MViewPager mViewPager;
    private PointIndicator mPointIndicator;
    //图片地址集合
    private List<String> mImageUrlList = new ArrayList<>();
    private boolean reverse;

    private int index;

    private int mPageSize;

    @Override
    public Handler getHandler() {
        return mHandler;
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //new Random().nextInt(4) 不包括4
            index = index > mPageSize ? index % mPageSize : index;
            Log.e("switch", "切换至"+index+"页");
            mViewPager.setCurrentItem(index);
            //逆向标记
            if (reverse) {
                index --;
            } else {
                index ++;
            }
            mHandler.sendEmptyMessageDelayed(0, 1000);
        }
    };


    public ViewPagerIndicator(Context context) {
        this(context, null, 0);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewPagerIndicator(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_indicator, this);
        mViewPager = (MViewPager) findViewById(R.id.pager);
        mPointIndicator = (PointIndicator) findViewById(R.id.indicator);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mViewPager.isTouchFromUser())
                    index = position;
                if (position == 0) {
                    reverse = false;
                } else if (position == mPageSize-1)
                    reverse = true;
                mPointIndicator.setSelectedIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mPageAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                TextView tv = new TextView(getContext());
                tv.setText("第"+ ++position + "页");
                container.addView(tv);
                return tv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeViewAt(position);
            }

            @Override
            public int getCount() {
                return mImageUrlList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };
        mViewPager.setAdapter(mPageAdapter);
    }

    public void setImageUrlList(List<String> imageUrlList) {
        if (imageUrlList == null)
            throw new RuntimeException("图片地址列表不能为空");
        mImageUrlList.clear();
        mImageUrlList.addAll(imageUrlList);
        mPageSize = mImageUrlList.size();
        mViewPager.setOffscreenPageLimit(mPageSize - 1);
        mPointIndicator.setPointCount(imageUrlList.size());
        mPageAdapter.notifyDataSetChanged();
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }
}
