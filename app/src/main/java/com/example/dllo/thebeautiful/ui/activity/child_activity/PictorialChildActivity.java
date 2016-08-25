package com.example.dllo.thebeautiful.ui.activity.child_activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.PicThirdBean;
import com.example.dllo.thebeautiful.model.bean.PictorialBean;
import com.example.dllo.thebeautiful.model.bean.PictorialDatas;
import com.example.dllo.thebeautiful.model.bean.designer.DesignerBean;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.example.dllo.thebeautiful.view.richtext.*;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/17.
 */
public class PictorialChildActivity extends AbsBaseActivity implements View.OnScrollChangeListener {
    private ImageView iv_comment, iv_like, iv_more, iv_back, title_image;
    private CircleImageView head_civ, author_pic_child;
    private Button some_btn;
    private RelativeLayout rv_pic;
    private HtmlTextView web_pic;
    private PictorialDatas datas;
    private TextView title_tv, sub_title_tv;
    private ScrollView sv_pic_child;
    private TranslateAnimation translateAnimation;
    private boolean isUp = true, isDown = true;
    private LinearLayout ll;
    private String idUrl;

    @Override
    protected int setLayout() {
        return R.layout.activity_child_pictorial;
    }

    @Override
    protected void initViews() {
        sv_pic_child = byView(R.id.sv_pic_child);
        title_tv = byView(R.id.title_pic_child);
        title_image = byView(R.id.title_image);
        sub_title_tv = byView(R.id.sub_title_pic_child);
        head_civ = byView(R.id.head_image_pic);
        iv_back = byView(R.id.image_pictorial);
        iv_comment = byView(R.id.article_comment_pic);
        iv_like = byView(R.id.article_like_pic);
        iv_more = byView(R.id.article_more_pic);
        web_pic = byView(R.id.web_pic);
        rv_pic = byView(R.id.rv_pictorial);
        some_btn = byView(R.id.something_btn);
        ll = byView(R.id.ll);
        author_pic_child = byView(R.id.author_pic_child);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        datas = intent.getParcelableExtra("pictorial_datas");
        idUrl = "http://design.zuimeia.com/api/v1/article/"+datas.getId() +"/?device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.7_1&appVersionCode=10171&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";

        setHtmlText();
        sv_pic_child.setOnScrollChangeListener(this);
        parseThirdDatas();

    }

    private void setHtmlText() {
        title_tv.setText(datas.getHeaderTitle());
        sub_title_tv.setText(datas.getSub_title());
        Picasso.with(PictorialChildActivity.this).load(datas.getImage_url()).into(title_image);
        web_pic.setHtmlFromString(datas.getContent());
        web_pic.setTextSize(20);
        web_pic.setTextColor(Color.BLACK);

    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

        if (scrollY > oldScrollY) {
            if (isUp) {
                translateAnimation = new TranslateAnimation(0, 0, 0, -220);
                translateAnimation.setDuration(500);
                translateAnimation.setRepeatCount(0);
                translateAnimation.setFillAfter(true);
                ll.startAnimation(translateAnimation);
                isUp = false;
                isDown = true;
            }
        } else {
            if (isDown) {
                translateAnimation = new TranslateAnimation(0, 0, -220, 0);
                translateAnimation.setDuration(500);
                translateAnimation.setRepeatCount(0);
                translateAnimation.setFillAfter(true);
                ll.startAnimation(translateAnimation);
                isDown = false;
                isUp = true;
            }
        }
    }
    public void parseThirdDatas(){
        OKHttpInstance.getInstance().startRequest(idUrl, PicThirdBean.class, new OnHttpCallBack<PicThirdBean>() {
            @Override
            public void onSuccess(PicThirdBean response) {
                List<PicThirdBean.DataBean.DesignersBean> datas = response.getData().getDesigners();
                for (int i = 0;i<datas.size();i++){
                    String articleUrl = response.getData().getDesigners().get(i).getAvatar_url();
                    Picasso.with(PictorialChildActivity.this).load(articleUrl).into(author_pic_child);
                }

            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }
}
