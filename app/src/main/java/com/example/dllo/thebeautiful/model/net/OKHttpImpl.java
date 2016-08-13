package com.example.dllo.thebeautiful.model.net;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dllo on 16/8/13.
 * 接口实现类
 */
public class OKHttpImpl implements OKNetWork{

    private OkHttpClient mclient;
    //将handler初始化在主线程  Looper.getMainLooper()这样初始化的handler,无论在哪个线程new的,它都属于主线程
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Gson mGson;

    //构造方法
    OKHttpImpl(){
        mGson = new Gson(); //构造方法中初始化gson
        //缓存的文件 过去SD卡目录
        File cacheDir = Environment.getExternalStorageDirectory();
        mclient = new OkHttpClient.Builder()
                //设置网络请求的缓存目录(有时甚至可以没有)   10 * 1024 *1024是10MB左右
                .cache(new Cache(cacheDir, 10 * 1024 * 1024))
                //连接超时的时间  (超过5秒则取消)
                .connectTimeout(5 , TimeUnit.SECONDS)
                .build();
    }


    @Override
    public void startRequest(String url, final OnHttpCallBack<String> callBack) {
        Request request = new Request.Builder().url(url).build();
        mclient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);  //将异常e传回主线程
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String resultStr = response.body().string();
                //要将resultStr回调到主线程
                //这里的mHanlder.post(new Runnable(){}) 意思是:hanlder对象.post一个任务.这个任务Runnable(),让他执行在主线程
                //runOnUiThread是activity的方法,所以这里用handler传回主线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(resultStr);
                    }
                });
            }
        });
    }



    //如果有请求头  public <T> void startRequest(String url, Map<String, String> mapHeaders, final Class<T> Clazz, final OnHttpCallBack<T> callBack){
    @Override
    public <T> void startRequest(String url, final Class<T> clazz, final OnHttpCallBack<T> callBack) {
        Request request = new Request.Builder().url(url).build();
        mclient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String resultStr = response.body().string();
                //解析到类里
                final T resultEntity = mGson.fromJson(resultStr, clazz);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(resultEntity);  //这样接口返回的就是实体类了
                    }
                });
            }
        });
    }




}
