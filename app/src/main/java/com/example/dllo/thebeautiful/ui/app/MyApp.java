package com.example.dllo.thebeautiful.ui.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/8/12.
 */
public class MyApp extends Application{

    /**
     * 记得注册
     */

    /**static修饰之后,可以用MyApp类直接调用方法,不用创建对象,因为Application,Activity等也不能创建对象调用方法*/
    /**所有带on的方法(如onClick,onCreate等), 都是会自动触发的, 不用创建对象来调用*/

    //Application 是当前应用,只存在一个  (一个工程只有一个,所以这里写一些全局的东西)相当于我的应用的对象
    /**注意application在清单文件注册, 在application里写name, 就会出来一个提示,也仅此一个*/
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    //对外提供get方法,因为上面的context是私有的,加入外面的想用这个类的context.在外面的类里就可以用这个get方法 得到
    public static Context getContext(){
        return context;
    }

}
