package com.example.dllo.thebeautiful.ui.fragment;


import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.ui.activity.mine.CollectionActivity;
import com.example.dllo.thebeautiful.ui.activity.mine.FeedbackActivity;
import com.example.dllo.thebeautiful.ui.activity.mine.FocusActivity;
import com.example.dllo.thebeautiful.ui.activity.mine.SettingActivity;
import com.example.dllo.thebeautiful.ui.activity.mine.WishActivity;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import de.hdodenhof.circleimageview.CircleImageView;

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
    private CircleImageView circleImageView; // dialog 用户头像
    private TextView textView_name;    // 用户名
    private PlatformActionListener platformActionListener = new PlatformActionListener() {
        @Override
        public void onComplete(final Platform platform, int i, HashMap<String, Object> hashMap) {
            circleImageView.post(new Runnable() {
                @Override
                public void run() {
                    Picasso.with(context).load(platform.getDb().getUserIcon()).into(circleImageView);
                    textView_name.setText(platform.getDb().getUserName());
                    Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();

                }
            });


        }

        @Override
        public void onError(Platform platform, int i, Throwable throwable) {

        }

        @Override
        public void onCancel(Platform platform, int i) {

        }
    };


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
        circleImageView = ByView(R.id.circleImageView);
        textView_name = ByView(R.id.user_name);

    }

    @Override
    protected void initDatas() {
        button_setting.setOnClickListener(this);
        button_feedback.setOnClickListener(this);
        rl_collection.setOnClickListener(this);
        rl_attention.setOnClickListener(this);
        rl_wish.setOnClickListener(this);
        circleImageView.setOnClickListener(this);
        ShareSDK.initSDK(context);
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
            case R.id.circleImageView:
                showDialog();
                break;
            case R.id.share_sina:
                Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
                weibo.setPlatformActionListener(platformActionListener);
                weibo.authorize();
                break;
            case R.id.share_qq:
                Platform qq = ShareSDK.getPlatform(QQ.NAME);
                qq.setPlatformActionListener(platformActionListener);
                qq.authorize();
                break;
        }

    }
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = getLayoutInflater(getArguments()).inflate(R.layout.item_dialog, null);
        CircleImageView circleImageView_sina = (CircleImageView) view.findViewById(R.id.share_sina);
        CircleImageView circleImageView_qq = (CircleImageView) view.findViewById(R.id.share_qq);
        circleImageView_sina.setOnClickListener(this);
        circleImageView_qq.setOnClickListener(this);
        builder.setView(view);
        builder.show();
    }
}
