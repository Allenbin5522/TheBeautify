package com.example.dllo.thebeautiful.model.net;

/**
 * Created by dllo on 16/8/13.
 * 解析回调接口
 */
public interface OnHttpCallBack<T> {
    void onSuccess(T response);
    //Throwable是异常的父类,以便出现异常的时候,对异常进行处理
    void onError(Throwable ex);
}
