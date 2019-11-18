package com.example.effective.chapter2.clauses6;

import java.util.regex.Pattern;

/**
 *  避免创建不必要的对象
 *
 * @Author: zhenglongze
 * @Date 2019/11/15 10:16
 */
public class NeedlessObject {

    String s = new String("bikini"); //永远不要这么做,会创建多余的实例

    String s2 = "bikini";   //只用了一个实例

    public static void main(String[] args) {
        Boolean b1 = Boolean.valueOf("boolean");
        Boolean b2 = new  Boolean("boolean");
        //b1优于b2
    }

    //确定一个字符串是否为一个有效的罗马数字（正则表达式）
    //String.matches方法最容易于查询一个字符串是否与正则表达式相匹配，但并不适合在注重性能的情景中重复使用。
    //每次调用内部为正则表达式创建一个Pattern实例
    public static boolean isRomanNumeral(String s){
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    //创建一个静态不可变的Pattern实例
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    //调用同一个Pattern实例
    public static boolean isRomanNumeral2(String s){
        return ROMAN.matcher(s).matches();
    }


}
