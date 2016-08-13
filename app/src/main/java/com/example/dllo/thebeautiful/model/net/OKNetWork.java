package com.example.dllo.thebeautiful.model.net;

/**
 * Created by dllo on 16/8/13.
 */
public interface OKNetWork {
    //对解析方法 通过接口再度封装

    //解析字符串
    void startRequest(String url, OnHttpCallBack<String> callBack);
    //解析放入实体类
    <T> void startRequest(String url, Class<T> tClass, OnHttpCallBack<T> callBack);

}
