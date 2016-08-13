package com.example.dllo.thebeautiful.ui.activity;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.thebeautiful.R;

/**
 * Created by dllo on 16/8/13.
 * 我 -> 设置界面
 */
public class SettingActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView imageView_return; // 返回键

    @Override
    protected int setLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initViews() {
        imageView_return = byView(R.id.iv_setting_return);

    }

    @Override
    protected void initDatas() {
        imageView_return.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_setting_return:
                finish();
                break;
        }
    }
}
