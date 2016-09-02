package com.example.dllo.thebeautiful.ui.activity.mine;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.designer.DesignerBean;
import com.example.dllo.thebeautiful.model.bean.mine.CollectFocusBean;
import com.example.dllo.thebeautiful.model.db.LiteOrmTool;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.model.net.URLValues;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.example.dllo.thebeautiful.ui.adapter.mine.CollectionFocusAdapter;
import com.example.dllo.thebeautiful.utils.L;
import com.example.dllo.thebeautiful.utils.T;

import java.util.List;

/**
 * Created by dllo on 16/8/13.
 * 我 -> 关注的设计师 界面
 */
public class FocusActivity extends AbsBaseActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
    private ImageView imageView_return; // 返回键
    private ListView listView;

    private CollectionFocusAdapter adapter;
    private List<CollectFocusBean> been;


    @Override
    protected int setLayout() {
        return R.layout.activity_focus;
    }

    @Override
    protected void initViews() {
        imageView_return = byView(R.id.iv_focus_return);
        listView = (ListView) findViewById(R.id.listView_focus);

    }

    @Override
    protected void initDatas() {
        imageView_return.setOnClickListener(this);
        been = LiteOrmTool.getDbInstance().queryAll(CollectFocusBean.class);

        adapter = new CollectionFocusAdapter(this);
        adapter.setDesignersBeen(been);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_focus_return:
                finish();
                break;
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        CollectFocusBean collectFocusBean = (CollectFocusBean) parent.getItemAtPosition(position);
        LiteOrmTool.getDbInstance().delete(collectFocusBean);
        adapter.delData(position);
        return false;
    }
}
