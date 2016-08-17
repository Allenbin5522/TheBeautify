package com.example.dllo.thebeautiful.ui.fragment.things;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_othersBean;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.ui.adapter.things.Things_othersAdapter;
import com.example.dllo.thebeautiful.ui.fragment.AbsBaseFragment;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/8/16.
 * 有物界面复用的一级界面 (tablayout里的后5个)
 */
public class Things_othersFragments extends AbsBaseFragment{

    private RecyclerView recyclerView;
    private Things_othersBean othersBean;
    private Things_othersAdapter othersAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_things_others;
    }

    @Override
    protected void initViews() {
        recyclerView = ByView(R.id.rv_things_others);
    }

    @Override
    protected void initDatas() {
        othersAdapter = new Things_othersAdapter(context);
        //解析
        analysis();
    }

    /**
     * fragment的复用 对ThingsFragment提供的方法,加载时 用复用界面
     * @param url
     * @return
     */
    public static Fragment getFragments(String url){
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        Things_othersFragments othersFragments = new Things_othersFragments();
        othersFragments.setArguments(bundle);
        return othersFragments;
    }

    /**
     * 解析数据
     */
    private void analysis() {
        Bundle bundle = getArguments();
        String url = bundle.getString("url");

        OKHttpInstance.getInstance().startRequest(url, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                othersBean = gson.fromJson(response, Things_othersBean.class);
                othersAdapter.setOthersBean(othersBean);

                GridLayoutManager gm = new GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(gm);

                recyclerView.setAdapter(othersAdapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }



}
