package com.example.effective.chapter2.clauses3;

import java.io.Serializable;

/**
 * 懒汉式单例
 *
 * @Author: zhenglongze
 * @Date 2019/11/14 13:42
 */
public class LazySingleton implements Serializable {

    private LazySingleton(){
//        if(lazySingleton != null){
//            throw new RuntimeException("禁止反射破坏单例");
//        }
    }

    private static LazySingleton lazySingleton ;

    public static LazySingleton getInstance(){
        if(lazySingleton== null){
            synchronized (LazySingleton.class){
                if(lazySingleton==null){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    //防止序列化反序列化破坏单例
    private Object readResolve(){
        return lazySingleton;
    }

}
