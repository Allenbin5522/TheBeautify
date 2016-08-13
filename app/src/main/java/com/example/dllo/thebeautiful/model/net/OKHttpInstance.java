package com.example.dllo.thebeautiful.model.net;

/**
 * Created by dllo on 16/8/13.
 * 封装第一层okhttp
 */
public class OKHttpInstance {

    //将这个类写成单例类
    /**静态内部类(SingletonHolder)形式的单例*/  //就是在这个内部类里只创建一次
    private static final class SingletonHolder{
        private static final OKHttpInstance INSTANCE = new OKHttpInstance();
    }

    //对外提供的方法
    public static OKHttpInstance getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private OKNetWork netTool;  //实现接口后,重新声明一个接口对象

    //因为单例,所以构造方法改成私有的
    private OKHttpInstance() {
        netTool = new OKHttpImpl();  /**多态:父类声明对象,子类实例化,这样就去了对应的子类去执行任务*/
    }

    //封装1:
    /**
     * @param url 解析返回的结果,
     * @param callBack 回调的接口
     */
    public void startRequest(String url , OnHttpCallBack<String> callBack){
        netTool.startRequest(url, callBack);
    }

    //封装2:
    public <T> void startRequest(String url, Class<T> clazz, OnHttpCallBack<T> callBack){
        netTool.startRequest(url, clazz, callBack);
    }



}
