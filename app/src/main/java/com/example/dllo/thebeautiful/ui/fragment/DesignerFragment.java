package com.example.dllo.thebeautiful.ui.fragment;

import android.widget.ListView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.DesignerBean;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.ui.adapter.DesignerAdapter;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dllo on 16/8/12.
 */
public class DesignerFragment extends AbsBaseFragment{
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
        OKHttpInstance okHttpInstance = OKHttpInstance.getInstance();
        okHttpInstance.startRequest("http://design.zuimeia.com/api/v1/designers/?page=1&page_size=30&device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.5&appVersionCode=10105&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld", new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                DesignerBean designerBean = gson.fromJson(response,DesignerBean.class);
                DesignerBean.DataBean dataBean = designerBean.getData();
                designersBeen = dataBean.getDesigners();
                adapter = new DesignerAdapter(context);
                adapter.setDesignersBeen(designersBeen);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });

    }
}
