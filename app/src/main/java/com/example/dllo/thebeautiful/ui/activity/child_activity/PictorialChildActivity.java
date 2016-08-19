package com.example.dllo.thebeautiful.ui.activity.child_activity;

import android.content.Intent;
import android.graphics.Color;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.PictorialDatas;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.example.dllo.thebeautiful.view.richtext.*;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/17.
 */
public class PictorialChildActivity extends AbsBaseActivity {
    private ImageView iv_comment, iv_like, iv_more, iv_back,title_image;
    private CircleImageView head_civ;
    private Button some_btn;
    private RelativeLayout rv_pic;
    private HtmlTextView web_pic;
    private PictorialDatas datas;
    private TextView title_tv,sub_title_tv;

    @Override
    protected int setLayout() {
        return R.layout.activity_child_pictorial;
    }

    @Override
    protected void initViews() {
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
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        datas = intent.getParcelableExtra("pictorial_datas");
        title_tv.setText(datas.getHeaderTitle());
        sub_title_tv.setText(datas.getSub_title());
        Picasso.with(PictorialChildActivity.this).load(datas.getImage_url()).into(title_image);
        web_pic.setHtmlFromString(datas.getContent());
        web_pic.setTextSize(20);
        web_pic.setPadding(10,10,10,20);
        web_pic.setTextColor(Color.BLACK);
    }
}
