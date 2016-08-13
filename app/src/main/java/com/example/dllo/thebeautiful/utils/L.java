package com.example.dllo.thebeautiful.utils;

import android.util.Log;

/**
 * Created by dllo on 16/8/12.
 */
public class L {

    /**被final修饰的类 不能被继承*/
    public L() {}

    //调试模式 目前定义为true
    private static boolean isDebug = true;   /**当我app上线的时候,这里全改成false,这样继承这里的log全没了*/

    //log日志的标签,定义的是应用名(app名)
    private static String TAG = "MyDemo";

    /**
     * 使用默认TAG标签的
     * @param msg
     */
    public static void e(String msg){
        if (isDebug){
            Log.e(TAG, msg);
        }
    }

    public static void i(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
        }
    }

    /**
     * 使用自定义TAG标签的
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg){
        if (isDebug){
            Log.e(tag, msg);
        }
    }

    public static void i(String tag, String msg){
        if (isDebug){
            Log.e(tag, msg);
        }
    }

}
