package com.example.dllo.thebeautiful.ui.activity.pictorial;

import android.content.Intent;
import android.support.annotation.BinderThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.picbeans.PicThirdBean;
import com.example.dllo.thebeautiful.model.bean.picbeans.PictorialDatas;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.example.dllo.thebeautiful.ui.adapter.pictorial.PicThirdAdapter;

/**
 * Created by dllo on 16/8/26.
 */
public class PictorialThirdActivity extends AbsBaseActivity{
    private ImageView arImage,back_befor;
    private EditText talk_et;
    private TextView send_tv;
    private ListView picThirdLs;
    private PictorialDatas datas;
    private String thirdUrl;

    @Override
    protected int setLayout() {
        return R.layout.activity_picthird;
    }

    @Override
    protected void initViews() {
        arImage = byView(R.id.picthird_imageView);
        talk_et = byView(R.id.picthird_editText);
        send_tv = byView(R.id.picthird_tv);
        picThirdLs = byView(R.id.ls_picthird);
        back_befor = byView(R.id.back_picthird);
    }

    @Override
    protected void initDatas() {
        parseDatas();
        back_befor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void parseDatas() {
        Intent intent = getIntent();
        datas = intent.getParcelableExtra("picThird");
        thirdUrl = "http://design.zuimeia.com/api/v1/comments/article/"+datas.getId()+"/?page=1&page_size=30&device_id=000000000000000&platform=android&lang=zh&appVersion=1.1.7_1&appVersionCode=10171&systemVersion=22&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
        OKHttpInstance.getInstance().startRequest(thirdUrl, PicThirdBean.class, new OnHttpCallBack<PicThirdBean>() {
            @Override
            public void onSuccess(PicThirdBean response) {
                PicThirdAdapter thirdAdapter = new PicThirdAdapter(PictorialThirdActivity.this);
                thirdAdapter.setDatas(response.getData().getComments());
                picThirdLs.setAdapter(thirdAdapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }
}
