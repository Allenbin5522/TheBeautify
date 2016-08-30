package com.example.dllo.thebeautiful.ui.activity.designer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.designer.DesignerBannerBean;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by dllo on 16/8/17.
 */
public class DesignerSecondActivity extends AbsBaseActivity implements View.OnClickListener {
    private Banner banner;
    private String[] imageurls;
    private List<String> introduce_images;
    private String url;
    private ImageView imageView_return;
    private TextView textView_name, textView_label, textView_description;
    private CircleImageView circleImageView;
    private String name, label, description, avatar_url;
    private View layoutView, expandView; // RelativeLayout布局和ImageView
    int maxDescripLine = 2; // TextView默认最大展示行数


    @Override
    protected int setLayout() {
        return R.layout.activity_second_designer;
    }

    @Override
    protected void initViews() {
        banner = byView(R.id.banner);
        imageView_return = byView(R.id.return_designer_second);
        textView_name = byView(R.id.tv_design_second_name);
        textView_label = byView(R.id.tv_design_second_label);
        textView_description = byView(R.id.tv_design_second_description);
        circleImageView = byView(R.id.civ_designer_second);
        layoutView = byView(R.id.description_layout);
        expandView = byView(R.id.expand);

    }

    public void showBanner() {
        // 设置小圆点
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
        // 设置位置 居中
        banner.setIndicatorGravity(Banner.CENTER);
        // 设置图片
        banner.setImages(imageurls);
        // 设置轮播时间
        banner.setDelayTime(500000);
    }

    @Override
    protected void initDatas() {
        imageView_return.setOnClickListener(this);
        Intent intent = getIntent();
        url = intent.getStringExtra("url_banner");
        // 解析轮播图
        OKHttpInstance okHttpInstance = OKHttpInstance.getInstance();
        okHttpInstance.startRequest(url, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                DesignerBannerBean designerBannerBean = gson.fromJson(response, DesignerBannerBean.class);
                DesignerBannerBean.DataBean dataBean = designerBannerBean.getData();
                introduce_images = dataBean.getIntroduce_images();
                imageurls = new String[introduce_images.size()];
                for (int i = 0; i < introduce_images.size(); i++) {
                    imageurls[i] = introduce_images.get(i);
                }
                showBanner();
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
        // 解析头像和文字
        okHttpInstance.startRequest(url, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                DesignerBannerBean designerBannerBean = gson.fromJson(response, DesignerBannerBean.class);
                DesignerBannerBean.DataBean dataBean = designerBannerBean.getData();
                name = dataBean.getName();
                label = dataBean.getLabel();
                description = dataBean.getDescription();
                avatar_url = dataBean.getAvatar_url();
                textView_name.setText(name);
                textView_label.setText(label);
                textView_description.setHeight(textView_description.getLineHeight() * maxDescripLine);
                textView_description.setText(description);
                if (avatar_url.isEmpty()) {
                    circleImageView.setImageResource(R.mipmap.ic_launchera);
                } else
                    Picasso.with(DesignerSecondActivity.this).load(avatar_url).into(circleImageView);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });

        layoutView.setOnClickListener(new View.OnClickListener() {
            boolean isExpand; // 是否已展开的状态

            @Override
            public void onClick(View v) {
                isExpand = !isExpand;
                textView_description.clearAnimation();
                final int deltaValue; // 默认高度,即前边由maxLine确定的高度
                final int startValue = textView_description.getHeight();  // 起始高度
                int durationMillis = 200; // 动画持续时间
                if (isExpand) {

                    /**
                     * 折叠动画
                     * 从实际高度缩回起始高度
                     */
                    deltaValue = textView_description.getLineHeight() * textView_description.getLineCount() - startValue;
                    RotateAnimation animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(durationMillis);
                    animation.setFillAfter(true);
                    expandView.startAnimation(animation);
                } else {
                    /**
                     * 展开动画
                     * 从起始高度增长至实际高度
                     */
                    deltaValue = textView_description.getLineHeight() * maxDescripLine - startValue;
                    RotateAnimation animation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(durationMillis);
                    animation.setFillAfter(true);
                    expandView.startAnimation(animation);
                }
                Animation animation = new Animation() {
                    protected void applyTransformation(float interpolateTime, Transformation t) {
                        textView_description.setHeight((int) (startValue + deltaValue * interpolateTime));
                    }
                };
                animation.setDuration(durationMillis);
                textView_description.startAnimation(animation);


            }
        });


    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
