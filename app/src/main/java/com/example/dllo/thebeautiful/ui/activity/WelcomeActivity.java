package com.example.dllo.thebeautiful.ui.activity;

import android.content.Intent;
import android.os.CountDownTimer;

import com.example.dllo.thebeautiful.R;

/**
 * Created by dllo on 16/9/1.
 */
public class WelcomeActivity extends AbsBaseActivity{
    private CountDownTimer timer;

    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        timer = new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }


}
