package com.example.dllo.thebeautiful.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by dllo on 16/8/18.
 * 自定义ListView
 */
public class NoScrollListView extends ListView{


    public NoScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 重新定义listview
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,  //如果不设置,系统默认设置是显示两条
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }


    /**
     * 重新分发触摸事件
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }


}