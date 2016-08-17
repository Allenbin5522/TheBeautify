package com.example.dllo.thebeautiful.ui.activity.designer;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.designer.DesignerBannerBean;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.util.List;


/**
 * Created by dllo on 16/8/17.
 */
public class DesignerSecondActivity extends AbsBaseActivity implements View.OnClickListener {
    private Banner banner;
    private String[] imageurls;
    private List<String> introduce_images;
    private String url;
    private ImageView imageView_return;
    @Override
    protected int setLayout() {
        return R.layout.activity_second_designer;
    }

    @Override
    protected void initViews() {
        banner = byView(R.id.banner);
        imageView_return = byView(R.id.return_designer_second);

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

        OKHttpInstance okHttpInstance = OKHttpInstance.getInstance();
        okHttpInstance.startRequest(url, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                DesignerBannerBean designerBannerBean = gson.fromJson(response,DesignerBannerBean.class);
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


    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
