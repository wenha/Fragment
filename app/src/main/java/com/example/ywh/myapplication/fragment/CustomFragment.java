package com.example.ywh.myapplication.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.ywh.myapplication.base.BaseFragment;

/**
 * Created by ywh on 2017/2/18.
 */

public class CustomFragment extends BaseFragment{

    private static final String TAG = CustomFragment.class.getSimpleName();
    private TextView textView;

    @Override
    protected View initView() {
        Log.e(TAG,"常用Fragment页面被初始化。。。");
        textView = new TextView(mContext);
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG,"常用框架页面被初始化了。。。");
        textView.setText("常用框架页面");
    }
}
