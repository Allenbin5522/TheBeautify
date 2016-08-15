package com.example.dllo.thebeautiful.ui.activity.mine;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;

/**
 * Created by dllo on 16/8/13.
 * 我 -> 我的心愿单 界面
 */
public class WishActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView imageView_return; // 返回键

    @Override
    protected int setLayout() {
        return R.layout.activity_wish;
    }

    @Override
    protected void initViews() {
        imageView_return = byView(R.id.iv_wish_return);

    }

    @Override
    protected void initDatas() {
        imageView_return.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_wish_return:
                finish();
                break;
        }
    }
}
