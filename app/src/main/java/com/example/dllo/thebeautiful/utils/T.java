package com.example.dllo.thebeautiful.utils;

import android.widget.Toast;

import com.example.dllo.thebeautiful.ui.app.MyApp;

/**
 * Created by dllo on 16/8/12.
 * Toast 吐司的工具类
 */
public class T {

    private static boolean isDebug = true;

    //吐司时间长的
    public static void longMsg(String msg){
        Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    //吐司时间短的
    public static void shotrMsg(String msg){
        Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
