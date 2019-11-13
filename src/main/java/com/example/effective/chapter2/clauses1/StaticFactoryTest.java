package com.example.effective.chapter2.clauses1;

/**
 * 用静态工厂示例
 *
 * @Author: zhenglongze
 * @Date 2019/11/13 17:29
 */
public class StaticFactoryTest {

    public static Boolean valueOf(boolean b){
        return b?Boolean.TRUE:Boolean.FALSE;
    }

}
