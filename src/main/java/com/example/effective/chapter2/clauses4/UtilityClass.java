package com.example.effective.chapter2.clauses4;

/**
 * 不想被实例化的类
 *
 * @Author: zhenglongze
 * @Date 2019/11/14 14:55
 */
public class UtilityClass {

    //为禁止实例化而创建的默认构造器
    private UtilityClass(){
        throw new AssertionError();
    }

}
