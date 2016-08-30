package com.example.dllo.thebeautiful.ui.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.mine.CollectFocusBean;
import com.example.dllo.thebeautiful.model.db.LiteOrmTool;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.example.dllo.thebeautiful.ui.adapter.mine.CollectionFocusAdapter;
import com.example.dllo.thebeautiful.utils.L;
import com.example.dllo.thebeautiful.utils.T;

import java.util.List;

/**
 * Created by dllo on 16/8/13.
 * 我 -> 关注的设计师 界面
 */
public class FocusActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView imageView_return; // 返回键
    private ListView listView;
    private List<CollectFocusBean> collectFocusBeen;
    private CollectionFocusAdapter adapter;

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
        //collectFocusBeen = LiteOrmTool.getDbInstance().query();
        adapter = new CollectionFocusAdapter(this);
        adapter.setCollectFocusBeen(collectFocusBeen);
        listView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_focus_return:
                finish();
                break;
        }
    }
}
