package com.example.dllo.thebeautiful.ui.fragment;


import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.ui.activity.CollectionActivity;
import com.example.dllo.thebeautiful.ui.activity.FeedbackActivity;
import com.example.dllo.thebeautiful.ui.activity.FocusActivity;
import com.example.dllo.thebeautiful.ui.activity.SettingActivity;
import com.example.dllo.thebeautiful.ui.activity.WishActivity;

/**
 * Created by dllo on 16/8/12.
 * 我 界面
 */
public class MineFragment extends AbsBaseFragment implements View.OnClickListener {
    private Button button_setting; // 设置
    private Button button_feedback; // 反馈
    private RelativeLayout rl_collection; // 收藏的画报
    private RelativeLayout rl_attention;  // 关注的设计师
    private RelativeLayout rl_wish; // 我的心愿单


    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViews() {
        button_setting = ByView(R.id.btn_setting);
        button_feedback = ByView(R.id.btn_feedback);
        rl_collection = ByView(R.id.rl_collection);
        rl_attention = ByView(R.id.rl_attention);
        rl_wish = ByView(R.id.rl_wish);
    }

    @Override
    protected void initDatas() {
        button_setting.setOnClickListener(this);
        button_feedback.setOnClickListener(this);
        rl_collection.setOnClickListener(this);
        rl_attention.setOnClickListener(this);
        rl_wish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_setting:
                goTo(getContext(), SettingActivity.class);
                break;
            case R.id.btn_feedback:
                goTo(getContext(), FeedbackActivity.class);
                break;
            case R.id.rl_collection:
                goTo(getContext(), CollectionActivity.class);
                break;
            case R.id.rl_attention:
                goTo(getContext(), FocusActivity.class);
                break;
            case R.id.rl_wish:
                goTo(getContext(), WishActivity.class);
                break;
        }
    }
}
