package com.example.effective.chapter4.clauses15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数组静态final域
 *
 * @Author: zhenglongze
 * @Date 2020/1/17 11:25
 */
public class ArrayFinal {

    //让类具有公有的静态final数组域，或者返回这种域的访问方法，这是错误的
    //public static final Thing[] VALUES = {};

    private static final Thing[] PRIVATE_VALUES = {};
    //方法一
    public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
    //方法二
    public static final Thing[] values(){
        return PRIVATE_VALUES.clone();
    }
}
