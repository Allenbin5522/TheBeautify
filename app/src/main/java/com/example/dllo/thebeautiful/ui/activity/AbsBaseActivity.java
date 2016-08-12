package com.example.dllo.thebeautiful.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;


/**
 * Created by dllo on 16/8/12.
 */
public abstract class AbsBaseActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在setContentView上方, 去掉信息栏 (这里参数是:宽和高改成全屏)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //绑定布局
        setContentView(setLayout());
        //订制流程
        // 1.初始化组件
        initViews();
        // 2.初始化数据
        initDatas();
    }


    /**
     * 设置xml布局文件:
     * (返回值int: 因为xml文件R.layout是int类型)
     * @return layout布局文件 eg:R.layout.activity_main
     */
    protected abstract int setLayout();

    /**
     * 初始化组件
     */
    protected abstract void initViews();

    /**
     * 初始化数据
     */
    protected abstract void initDatas();

    /**
     * 简化findViewById
     * T 泛型:泛指一系列类型 T这里指View的子类(也就是说这里返回值的类型是View的子类)
     * 泛型(尖括号里的T是对后面的T(返回值类型)的要求)
     */
    protected <T extends View> T byView(int resId){
        T t = (T) findViewById(resId);
        return t;
    }

    /**
     * 简化intent跳转
     * @param from intent里的 xx.this
     * @param to   intent里的 xx.class
     *             这里的限制条件是:要是我们写的基类的子类
     */
    protected void goTo(Context from, Class<? extends AbsBaseActivity> to){
        Intent intent = new Intent(from, to);
        startActivity(intent);
    }

    //这里能起同名的方法 是方法的重载
    //隐式intent的方法
    protected void goTo(String action, String uri){
        Intent intent = new Intent(action);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    /**
     * 带值跳转
     * @param from
     * @param to
     * @param values Bundle类型的值
     *               Bundle 是一个轻量级存储数据的类,存储的形式是key—value
     */
    protected void goTo(Context from, Class<? extends AbsBaseActivity> to, Bundle values){
        Intent intent = new Intent(from, to);
        intent.putExtras(values);  /**注意: 这里是putExtras 有个s*/
        startActivity(intent);
    }

}
