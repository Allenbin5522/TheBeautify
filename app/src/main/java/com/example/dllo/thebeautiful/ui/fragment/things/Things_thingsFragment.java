package com.example.dllo.thebeautiful.ui.fragment.things;

import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_thingsBean;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.model.net.URLValues;
import com.example.dllo.thebeautiful.ui.adapter.things.Things_thingsAdapter;
import com.example.dllo.thebeautiful.ui.fragment.AbsBaseFragment;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/8/16.
 */
public class Things_thingsFragment extends AbsBaseFragment {

    private ListView listView;
    private Things_thingsBean thingsBean;
    private Things_thingsAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_things_things;
    }

    @Override
    protected void initViews() {
        listView = ByView(R.id.ls_things_things);
    }

    @Override
    protected void initDatas() {
        adapter = new Things_thingsAdapter(context);
        analysis();
    }

    /**
     * 解析有物界面的数据
     */
    private void analysis() {
        OKHttpInstance.getInstance().startRequest(URLValues.THINGS_THINGS, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                thingsBean = gson.fromJson(response, Things_thingsBean.class);
                adapter.setBean(thingsBean);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });

    }


}
