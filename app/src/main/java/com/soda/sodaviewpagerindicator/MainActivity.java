package com.soda.sodaviewpagerindicator;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
/*
    private int index = 0;
    private ViewPager mViewPager;
    private boolean reverse;*/
    private ViewPagerIndicator mViewPagerIndicator;
  /*  private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            //new Random().nextInt(4) 不包括4
            index = index > 4 ? index % 4 : index;
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
    private PointIndicator mPointIndicator;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        mViewPagerIndicator = (ViewPagerIndicator) findViewById(R.id.viewpager_indicator);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("asdfas");
        strings.add("asdfas");
        strings.add("asdfas");
        strings.add("asdfas");
        strings.add("asdfas");
        mViewPagerIndicator.setImageUrlList(strings);
        /*mPointIndicator = (PointIndicator) findViewById(R.id.indicator);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    reverse = false;
                } else if (position == 3)
                    reverse = true;
                mPointIndicator.setSelectedIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                TextView tv = new TextView(MainActivity.this);
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
                return 4;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
        mHandler.sendEmptyMessageDelayed(0, 500);*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
/*        mHandler.removeMessages(0);*/
        if (mViewPagerIndicator != null)
            mViewPagerIndicator.getHandler().removeMessages(0);
    }
}
