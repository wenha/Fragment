package com.example.ywh.myapplication;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.ywh.myapplication.base.BaseFragment;
import com.example.ywh.myapplication.fragment.CommonFrameFragment;
import com.example.ywh.myapplication.fragment.CustomFragment;
import com.example.ywh.myapplication.fragment.OtherFragment;
import com.example.ywh.myapplication.fragment.ThirdPartyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 */
public class MainActivity extends FragmentActivity {

    private RadioGroup mRg_main;
    private List<BaseFragment> myBaseFragment;

    private int position;

    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();
    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckChangeListener());
        mRg_main.check(R.id.rb_common_frame);
    }

    class MyOnCheckChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                case R.id.rb_common_frame:
                    position = 0;
                    break;
                case R.id.rb_thirdparty:
                    position = 1;
                    break;
                case R.id.rb_custom:
                    position = 2;
                    break;
                case R.id.rb_other:
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }
            //根据位置得到对应的Fragment
            BaseFragment to = getFragment();
            //替换
            switchFragment (mContent,to);
        }
    }

    /**
     *
     * @param from 刚显示的Fragment，马上要被隐藏
     * @param to
     */
    private void switchFragment(Fragment from, Fragment to) {
        if(from != to){
            //才切换
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //判断是否被添加过
            if(!to.isAdded()){
                //没有被添加
                //from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //添加
                if(to!=null){
                    ft.add(R.id.fl_content,to).commit();
                }
            }else {
                //已经被添加
                //from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //显示to
                if(to!=null){
                    ft.show(to).commit();
                }
            }
        }
    }

//    private void switchFragment(BaseFragment fragment) {
//        //得到FragmentManager
//        FragmentManager fm = getSupportFragmentManager();
//        //开启事务
//        FragmentTransaction transaction = fm.beginTransaction();
//        //替换
//        transaction.replace(R.id.fl_content,fragment);
//        //提交事务
//        transaction.commit();
//    }

    private BaseFragment getFragment() {
        BaseFragment fragment = myBaseFragment.get(position);
        return fragment;
    }

    private void initFragment() {
        myBaseFragment = new ArrayList<>();
        myBaseFragment.add(new CommonFrameFragment());
        myBaseFragment.add(new ThirdPartyFragment());
        myBaseFragment.add(new CustomFragment());
        myBaseFragment.add(new OtherFragment());
    }

    private void initView() {
        mRg_main = (RadioGroup) findViewById(R.id.rg_main);
       // mRg_main.check(R.id.rb_common_frame);

    }
}
