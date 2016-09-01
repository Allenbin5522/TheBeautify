package com.example.dllo.thebeautiful.ui.activity.things;

import android.util.Log;
import android.widget.ListView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_secondBean;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.example.dllo.thebeautiful.ui.adapter.things.Things_commentAdapter;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/8/30.
 */
public class ThingsCommentActivity extends AbsBaseActivity{

    private ListView ls_comment;
    private Things_commentAdapter adapter;
    private Things_secondBean secondBean;

    @Override
    protected int setLayout() {
        return R.layout.activity_things_comment;
    }

    @Override
    protected void initViews() {
        ls_comment = byView(R.id.ls_things_comment);
    }

    @Override
    protected void initDatas() {
        String response = getIntent().getStringExtra("commentResult");
        Log.d("ThingsCommentActivity_______>", response);
        Gson gson = new Gson();
        secondBean = gson.fromJson(response, Things_secondBean.class);
        adapter = new Things_commentAdapter(this);
        adapter.setSecondBean(secondBean);
        ls_comment.setAdapter(adapter);

    }



}
