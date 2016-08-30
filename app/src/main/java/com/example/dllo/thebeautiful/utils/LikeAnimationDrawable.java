package com.example.dllo.thebeautiful.utils;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;

/**
 * Created by dllo on 16/8/27.
 */
public abstract class LikeAnimationDrawable extends AnimationDrawable{
    
    Handler finishHandler;  //判断结束的Handler

    public LikeAnimationDrawable(AnimationDrawable drawable) {
        // 这里得自己把每一帧加进去
        for (int i = 0; i < drawable.getNumberOfFrames(); i++) {
            this.addFrame(drawable.getFrame(i), drawable.getDuration(i));
        }
    }

    @Override
    public void start() {
        super.start();
        /**
         * 首先用父类的start();
         * 然后启动线程, 来调用onAnimationEnd();
         */
        finishHandler = new Handler();
        finishHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onAnimationEnd();
            }
        }, getTotalDuration());
    }

    /**
     * 这个方法获得动画的持续时间(之后调用onAnimationEnd())
     */
    public int getTotalDuration() {
        int durationTime = 0;
        for (int i = 0; i < this.getNumberOfFrames(); i++) {
            durationTime += this.getDuration(i);
        }
        return durationTime;
    }

    /**
     * 结束时调用的方法, 一定要实现
     */
    public abstract void onAnimationEnd();



}
