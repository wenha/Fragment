package com.example.ywh.myapplication.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ywh.myapplication.R;
import com.example.ywh.myapplication.adapter.CommonFragmentAdapter;
import com.example.ywh.myapplication.base.BaseFragment;

import static android.content.ContentValues.TAG;

/**
 * Created by ywh on 2017/2/18.
 */

public class CommonFrameFragment extends BaseFragment{

    private static final String TAG = CommonFrameFragment.class.getSimpleName();

    private ListView mListView;

    private String[] datas;
    private CommonFragmentAdapter adapter;

    @Override
    protected View initView() {
        Log.e(TAG,"常用框架Fragment页面被初始化。。。");
        View view = View.inflate(mContext, R.layout.fragment_common_frame,null);
        mListView = (ListView) view.findViewById(R.id.listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = datas[i];
                Toast.makeText(mContext,str,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG,"常用框架页面被初始化了。。。");
        //添加数据
        datas = new String[]{"OKHttp", "xUtils3","Retrofit2","Fresco","Glide","greenDao","RxJava","volley","Gson","FastJson","picasso","evenBus","jcvideoplayer","pulltorefresh","Expandablelistview","UniversalVideoView","....."};
        //设置适配器
        adapter = new CommonFragmentAdapter(mContext,datas);
        mListView.setAdapter(adapter);
    }
}
