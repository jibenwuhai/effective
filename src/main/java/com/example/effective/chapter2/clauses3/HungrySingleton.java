package com.example.effective.chapter2.clauses3;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 单例
 *
 * @Author: zhenglongze
 * @Date 2019/11/14 10:29
 */
public class HungrySingleton implements Serializable {

    private HungrySingleton(){

        //防止反射破坏单例
        if(null!=singleton){
            throw new RuntimeException("禁止反射调用");
        }
    }

    private final static HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getInstance(){
        return singleton;
    }

    //增加这个方法后，序列化和反序列化无法破坏单例。
    private Object readResolve(){
        return singleton;
    }


}
