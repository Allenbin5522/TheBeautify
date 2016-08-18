package com.example.dllo.thebeautiful.ui.fragment.things;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_thingsBean;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.model.net.URLValues;
import com.example.dllo.thebeautiful.ui.activity.MainActivity;
import com.example.dllo.thebeautiful.ui.activity.things.ThingsSecondActivity;
import com.example.dllo.thebeautiful.ui.adapter.things.Things_thingsAdapter;
import com.example.dllo.thebeautiful.ui.fragment.AbsBaseFragment;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/8/16.
 */
public class Things_thingsFragment extends AbsBaseFragment implements AdapterView.OnItemClickListener {

    private ListView listView;
    private Things_thingsBean thingsBean;
    private Things_thingsAdapter adapter;
    private String product_id;

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

        listView.setOnItemClickListener(this);
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

    /**
     * listview点击事件,跳转到二级界面
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Things_thingsBean thingsBean = (Things_thingsBean) parent.getItemAtPosition(position);
        //对应要传到二级界面的id
        product_id = String.valueOf(thingsBean.getData().getActivities().get(position).getProduct().getId());
        String url = URLValues.THINGS_SECOND.replace("913",  product_id);
        Intent intent = new Intent(context, ThingsSecondActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);

    }


}
