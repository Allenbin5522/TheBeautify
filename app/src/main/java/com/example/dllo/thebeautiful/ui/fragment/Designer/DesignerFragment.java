package com.example.dllo.thebeautiful.ui.fragment.Designer;

import android.widget.ListView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.DesignerBean;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.model.net.URLValues;
import com.example.dllo.thebeautiful.ui.adapter.DesignerAdapter;
import com.example.dllo.thebeautiful.ui.fragment.AbsBaseFragment;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dllo on 16/8/12.
 * 设计师界面
 */
public class DesignerFragment extends AbsBaseFragment {
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
            }

            @Override
            public void onError(Throwable ex) {

            }
        });

    }
}
