package com.example.dllo.thebeautiful.ui.fragment.designer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.designer.DesignerBean;
import com.example.dllo.thebeautiful.model.bean.mine.CollectFocusBean;
import com.example.dllo.thebeautiful.model.db.LiteOrmTool;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.ui.adapter.designer.DesignerAdapter;
import com.example.dllo.thebeautiful.model.net.URLValues;


import com.example.dllo.thebeautiful.ui.activity.designer.DesignerSecondActivity;


import com.example.dllo.thebeautiful.ui.fragment.AbsBaseFragment;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dllo on 16/8/12.
 * 设计师界面
 */
public class DesignerFragment extends AbsBaseFragment implements AdapterView.OnItemClickListener {
    private ListView listView;
    private DesignerAdapter adapter;
    private List<DesignerBean.DataBean.DesignersBean> designersBeen;

    @Override
    protected int setLayout() {
        return R.layout.fragment_designer;
    }

    @Override
    protected void initViews() {
        listView = ByView(R.id.listView_designer);

    }

    @Override
    protected void initDatas() {

        listView.setOnItemClickListener(this);

        OKHttpInstance okHttpInstance = OKHttpInstance.getInstance();
        okHttpInstance.startRequest(URLValues.DESIGNER, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                DesignerBean designerBean = gson.fromJson(response,DesignerBean.class);
                DesignerBean.DataBean dataBean = designerBean.getData();
                designersBeen = dataBean.getDesigners();
                adapter = new DesignerAdapter(context);
                adapter.setDesignersBeen(designersBeen);
                listView.setAdapter(adapter);
                Bundle bundle = new Bundle();
                bundle.putParcelable("qqq",designerBean);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DesignerBean.DataBean.DesignersBean bean = (DesignerBean.DataBean.DesignersBean) parent.getItemAtPosition(position);
        String intentUrl = URLValues.DESIGNER_BANNER_BEFORE + bean.getId() + URLValues.DESIGHER_BANNER_AFTER;
        Intent intent = new Intent(getContext(),DesignerSecondActivity.class);
        intent.putExtra("url_banner",intentUrl);
        startActivity(intent);


    }



}
