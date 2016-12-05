package com.soda.sodaviewpagerindicator;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //new Random().nextInt(4) 不包括4
            int index = new Random().nextInt(4);
            Log.e("switch", "切换至"+index+"页");
            pointIndicator.setSelectedIndex(index);
            mHandler.sendEmptyMessageDelayed(0, 1000);
        }
    };
    private PointIndicator pointIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pointIndicator = (PointIndicator) findViewById(R.id.indicator);
        pointIndicator.setSelectedIndex(1);
        mHandler.sendEmptyMessageDelayed(0, 500);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeMessages(0);
    }
}
