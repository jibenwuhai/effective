package com.example.effective.chapter2.clauses6;

/**
 * 自动装箱
 * 自动装箱使得基本类型和装箱类型之间的差别变得模糊，但并没有完全消除
 *
 * @Author: zhenglongze
 * @Date 2019/11/18 11:35
 */
public class AutomationEncasement {

    private static long sum(){
        //Long sum = null; 、、多构造了大约2^31 个Long 实例
        long sum = 0L; //优先使用基本类型而不是装箱基本类型，担心无意识的自动装箱
        for (long i = 0; i <=Integer.MAX_VALUE ; i++) {
            sum +=i;
        }
       return sum;
    }


}
