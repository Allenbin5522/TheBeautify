package com.example.dllo.thebeautiful.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;

/**
 * Created by dllo on 16/8/12.
 */
public abstract class AbsBaseFragment extends Fragment{

    protected Context context;

    /**
     * 当Acitivity和Fragment关联时会被调用  (这样我就不用去找activity了,安卓给了我一个context给我使用)
     * 传入一个Context给你使用
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayout(), container, false);
    }

    /*
     * 抽象方法:设置布局
     */
    protected abstract int setLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    /*
     * 初始化组件
     */
    protected abstract void initViews();

    /**
     * 简化findViewById
     */
    protected <T extends View> T ByView(int resId){
        return (T) getView().findViewById(resId);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
    }

    protected abstract void initDatas();

    protected void goTo(Context from, Class<? extends AbsBaseActivity> to){
        Intent intent = new Intent(from, to);
        from.startActivity(intent);
    }

}
