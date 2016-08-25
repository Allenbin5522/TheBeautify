package com.example.dllo.thebeautiful.model.db;

import android.content.Context;

import com.example.dllo.thebeautiful.ui.app.MyApp;
import com.litesuits.orm.LiteOrm;

import java.util.List;

/**
 * Created by dllo on 16/8/19.
 */
public class LiteOrmTool {

    //静态对象
    private static LiteOrmTool dbInstance;

    //数据库名字
    private static final String DB_NAME = "collect.db";
    private final LiteOrm liteOrm;

    //对外提供获得数据库操作的单例对象
    public static LiteOrmTool getDbInstance(){
        if (dbInstance == null){
            synchronized (LiteOrmTool.class){
                if (dbInstance == null){
                    dbInstance = new LiteOrmTool();
                }
            }
        }
        return dbInstance;
    }

    //私有化构造方法
    private LiteOrmTool(){
        //创建数据库
        liteOrm = LiteOrm.newSingleInstance(MyApp.getContext(), DB_NAME);
    }


    /**增删改查的方法*/

    //对外提供的增加方法
    public <T> void insert(T t) {
        getDbInstance()._insert(t);
    }

    //对内提供的方法
    private <T> void _insert(T t) {
        liteOrm.save(t);
    }


    public <T> void query(Class<T> t){
        getDbInstance()._query(t);
    }

    private <T> void _query(Class<T> t) {
        List<T> datas = liteOrm.query(t);
    }


    public <T> void delete(T t){
        getDbInstance()._delete(t);
    }

    private <T> void _delete(T t) {
        liteOrm.delete(t);
    }



}
