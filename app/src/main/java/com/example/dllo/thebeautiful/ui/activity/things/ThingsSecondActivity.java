package com.example.dllo.thebeautiful.ui.activity.things;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_secondBean;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.example.dllo.thebeautiful.ui.adapter.things.Things_secondImgAdapter;
import com.example.dllo.thebeautiful.ui.adapter.things.Things_secondLsAdapter;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/17.
 * 有物界面 点击后进入的 二级界面
 */
public class ThingsSecondActivity extends AbsBaseActivity implements View.OnClickListener {

    private String url;
    private Things_secondBean secondBean;
    private ViewPager vp_things_second;
    private LinearLayout line_pointContainer;
    private Things_secondImgAdapter imgAdapter;
    private List<String> imgUrls;
    private ImageView iv_back;
    private CircleImageView civ_designer;
    private TextView tv_digest, tv_name, tv_label, tv_concept, tv_describe, tv_desc;
    private Things_secondLsAdapter lsAdapter;
    private ListView listView;
    private ScrollView scrollView;

    @Override
    protected int setLayout() {
        return R.layout.activity_things_second;
    }

    @Override
    protected void initViews() {
        iv_back = byView(R.id.iv_back);
        vp_things_second = byView(R.id.vp_things_second);
        line_pointContainer = byView(R.id.line_things_second);
        tv_digest = byView(R.id.tv_things_second_digest);
        civ_designer = byView(R.id.civ_things_second_disigner);
        tv_name = byView(R.id.tv_things_second_name);
        tv_label = byView(R.id.tv_things_second_label);
        tv_concept = byView(R.id.tv_things_second_concept);
        tv_describe = byView(R.id.tv_things_second_describe);
        tv_desc = byView(R.id.tv_things_second_desc);

        listView = byView(R.id.ls_things_second);
        scrollView = byView(R.id.scrollView_things_second);
    }

    @Override
    protected void initDatas() {
        url = getIntent().getStringExtra("url");

        analysis();

        //让scrollView置顶,因为有别的组件抢焦点
        scrollView.scrollTo(0, 0);
        //给组件设置焦点
        iv_back.setFocusable(true);
        iv_back.setFocusableInTouchMode(true);
        iv_back.requestFocus();

        iv_back.setOnClickListener(this);
    }

    private void analysis() {
        OKHttpInstance.getInstance().startRequest(url, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                secondBean = gson.fromJson(response, Things_secondBean.class);
                imgUrls = secondBean.getData().getCover_images();

                imgAdapter = new Things_secondImgAdapter(ThingsSecondActivity.this, imgUrls);
                vp_things_second.setAdapter(imgAdapter);
                //给viewPager添加小点
                addPoints();
                //让小点随着viewPager的切换而改变
                changePoints();

                tv_digest.setText(secondBean.getData().getDigest());
                Picasso.with(ThingsSecondActivity.this).load(secondBean.getData().getDesigner().getAvatar_url()).into(civ_designer);
                tv_name.setText(secondBean.getData().getDesigner().getName());
                tv_label.setText(secondBean.getData().getDesigner().getLabel());
                tv_concept.setText(secondBean.getData().getDesigner().getConcept());
                tv_describe.setText(secondBean.getData().getName());
                tv_desc.setText(secondBean.getData().getDesc());

                lsAdapter = new Things_secondLsAdapter(ThingsSecondActivity.this);
                lsAdapter.setSecondBean(secondBean);
                listView.setAdapter(lsAdapter);


            }

            @Override
            public void onError(Throwable ex) {

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }

    /**
     * 让小点随着viewPager的切换而改变
     */
    private void changePoints() {
        vp_things_second.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < imgUrls.size(); i++) {
                    //线型布局里有n个点,一个一个获取
                    ImageView pointIv = (ImageView) line_pointContainer.getChildAt(i);
                    //如果position是当前页 == i, 那个小点对应是白色的 其他的是灰色的
                    pointIv.setImageResource(R.mipmap.button_action_dark_touch);
                }
                ImageView iv = (ImageView) line_pointContainer.getChildAt(position);
                iv.setImageResource(R.mipmap.button_action);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 添加小点
     */
    private void addPoints() {
        //有多少张图片,加多少个小点
        for (int i = 0; i < imgUrls.size(); i++) {
            ImageView pointIv = new ImageView(this);
            //设置小点的padding
            pointIv.setPadding(5,5,5,5);
            //设置小点的宽高
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30,30);
            pointIv.setLayoutParams(params);
            //将第一个小点设置为白色
            if (i == 0){
                pointIv.setImageResource(R.mipmap.button_action);
            } else {
                pointIv.setImageResource(R.mipmap.button_action_dark_touch);
            }
            line_pointContainer.addView(pointIv);
        }
    }



}
