package com.example.effective.chapter2.clauses3;

/**
 * 枚举类单例
 * 更简洁
 * 无偿提供序列化机制
 *绝对防止多次实例化，即使是面对复杂的序列化或者反射攻击
 *
 * @Author: zhenglongze
 * @Date 2019/11/14 14:24
 */
public enum  EnumSingleton {

    INSTANCE;



}
