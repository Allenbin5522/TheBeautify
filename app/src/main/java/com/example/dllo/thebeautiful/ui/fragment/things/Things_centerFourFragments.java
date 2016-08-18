package com.example.dllo.thebeautiful.ui.fragment.things;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_othersBean;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.model.net.URLValues;
import com.example.dllo.thebeautiful.ui.activity.things.ThingsSecondActivity;
import com.example.dllo.thebeautiful.ui.adapter.things.Things_centerFourAdapter;
import com.example.dllo.thebeautiful.ui.adapter.things.Things_othersAdapter;
import com.example.dllo.thebeautiful.ui.fragment.AbsBaseFragment;
import com.example.dllo.thebeautiful.ui.interfaces.RecyclerClickListener;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/8/16.
 * 有物界面复用的一级界面 (tablayout里的后5个)
 */
public class Things_centerFourFragments extends AbsBaseFragment{

    private RecyclerView recyclerView;
    private Things_othersBean othersBean;
    private Things_centerFourAdapter othersAdapter;
    private String product_id;

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
        othersAdapter = new Things_centerFourAdapter(context);
        //解析
        analysis();

        recyclerClick();
    }

    /**
     * fragment的复用 对ThingsFragment提供的方法,加载时 用复用界面
     * @param url
     * @return
     */
    public static Fragment getFragments(String url){
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        Things_centerFourFragments fourFragments = new Things_centerFourFragments();
        fourFragments.setArguments(bundle);
        return fourFragments;
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


    /**
     * recyclerView的点击事件,点击进入二级界面
     */
    private void recyclerClick() {
        othersAdapter.setListener(new RecyclerClickListener() {
            @Override
            public void recyclerClick(int position) {
                product_id = String.valueOf(othersBean.getData().getProducts().get(position).getId());
                String url = URLValues.THINGS_SECOND.replace("913",  product_id);
                Intent intent = new Intent(context, ThingsSecondActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }


}
