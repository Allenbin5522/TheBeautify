package com.example.dllo.thebeautiful.ui.activity.pictorial;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.picbeans.PicChildBean;
import com.example.dllo.thebeautiful.model.bean.picbeans.PicHeadProtraitBean;
import com.example.dllo.thebeautiful.model.bean.picbeans.PictorialDatas;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.model.net.URLValues;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.example.dllo.thebeautiful.view.richtext.*;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/17.
 */
public class PictorialChildActivity extends AbsBaseActivity implements View.OnScrollChangeListener, View.OnClickListener {
    private ImageView iv_comment, iv_like, iv_more, iv_back, title_image,back_pic;
    private CircleImageView head_civ, author_pic_child;
    private Button some_btn;
    private RelativeLayout rv_pic;
    private TextView name_tv,city_tv,commont_tv,favo_tv;
    private HtmlTextView web_pic;
    private PictorialDatas datas;
    private TextView title_tv, sub_title_tv;
    private ScrollView sv_pic_child;
    private TranslateAnimation translateAnimation;
    private boolean isUp = true, isDown = true;
    private RelativeLayout ll;
    private String idUrl;

    @Override
    protected int setLayout() {
        return R.layout.activity_child_pictorial;
    }

    @Override
    protected void initViews() {
        commont_tv = byView(R.id.commont_num_tv);
        favo_tv = byView(R.id.favo_num);
        back_pic = byView(R.id.back_pictorial);
        city_tv = byView(R.id.city_pic);
        name_tv = byView(R.id.name_pictorial);
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
        showNum();
        sv_pic_child.setOnScrollChangeListener(this);
        parseThirdDatas();
        back_pic.setOnClickListener(this);
        iv_comment.setOnClickListener(this);
        iv_like.setOnClickListener(this);

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
        OKHttpInstance.getInstance().startRequest(idUrl, PicHeadProtraitBean.class, new OnHttpCallBack<PicHeadProtraitBean>() {
            @Override
            public void onSuccess(PicHeadProtraitBean response) {
                List<PicHeadProtraitBean.DataBean.DesignersBean> datas = response.getData().getDesigners();
                for (int i = 0;i<datas.size();i++){
                    String articleUrl = response.getData().getDesigners().get(i).getAvatar_url();
                    String name = response.getData().getDesigners().get(i).getName();
                    String city = response.getData().getDesigners().get(i).getCity();
                    name_tv.setText(name);
                    city_tv.setText(city);
                    Picasso.with(PictorialChildActivity.this).load(articleUrl).into(author_pic_child);
                }

            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }
    private void showNum(){
        OKHttpInstance.getInstance().startRequest(URLValues.PIC_CHILD_START + datas.getId() + URLValues.PIC_CHILD_END, PicChildBean.class, new OnHttpCallBack<PicChildBean>() {
            @Override
            public void onSuccess(PicChildBean response) {
                int commont_num = response.getData().getComment_num();
                int fove_use_num = response.getData().getFavor_user_num();
                commont_tv.setText(String .valueOf(commont_num));
                favo_tv.setText(String .valueOf(fove_use_num));
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_pictorial:
                finish();
                break;
            case R.id.article_comment_pic:
                Intent intent = new Intent(this,PictorialThirdActivity.class);
                intent.putExtra("picThird",datas);
                startActivity(intent);
                break;
            case R.id.article_like_pic:

                break;
            case R.id.article_more_pic:

                break;
        }
    }
}
