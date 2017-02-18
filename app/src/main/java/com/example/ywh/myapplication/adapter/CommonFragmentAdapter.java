package com.example.ywh.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by ywh on 2017/2/18.
 *
 */

public class CommonFragmentAdapter extends BaseAdapter {


    private final Context context;
    private final String[] datas;

    public CommonFragmentAdapter(Context context, String[] datas){
        this.context = context;
        this.datas = datas;
    }
    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setPadding(30,30,20,20);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(20);
        textView.setText(datas[i]);
        return textView;
    }
}
