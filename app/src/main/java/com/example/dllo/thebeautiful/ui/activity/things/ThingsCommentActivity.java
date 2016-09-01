package com.example.dllo.thebeautiful.ui.activity.things;

import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;

import com.example.dllo.thebeautiful.R;
import com.example.dllo.thebeautiful.model.bean.things.Things_secondBean;
import com.example.dllo.thebeautiful.model.net.OKHttpImpl;
import com.example.dllo.thebeautiful.model.net.OKHttpInstance;
import com.example.dllo.thebeautiful.model.net.OnHttpCallBack;
import com.example.dllo.thebeautiful.ui.activity.AbsBaseActivity;
import com.example.dllo.thebeautiful.ui.adapter.things.Things_commentAdapter;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dllo on 16/8/30.
 */
public class ThingsCommentActivity extends AbsBaseActivity{

    private ListView ls_comment;
    private Things_commentAdapter adapter;
    private Things_secondBean secondBean;
    private List<Things_secondBean.DataBean.CommentsBean> commentsBeen;
    private String url;

    @Override
    protected int setLayout() {
        return R.layout.activity_things_comment;
    }

    @Override
    protected void initViews() {
        ls_comment = byView(R.id.ls_things_comment);
    }

    @Override
    protected void initDatas() {
        url = getIntent().getStringExtra("Url");
        adapter = new Things_commentAdapter(this);
        parseUrl();

    }

    private void parseUrl() {
        OKHttpInstance.getInstance().startRequest(url, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                secondBean = gson.fromJson(response, Things_secondBean.class);
                commentsBeen = secondBean.getData().getComments();
                adapter.setCommentsBeen(commentsBeen);
                ls_comment.setAdapter(adapter);
                ls_comment.setLayoutAnimation(getListAnim());
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }

    //listview从上倒下加载的效果
    private LayoutAnimationController getListAnim(){
        AnimationSet set = new AnimationSet(true);
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(700);
        set.addAnimation(animation);
        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        animation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.5f);
        return controller;
    }


}
