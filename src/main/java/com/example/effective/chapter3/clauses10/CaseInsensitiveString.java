package com.example.effective.chapter3.clauses10;

import java.util.Objects;

/**
 * 求求你写个注解吧 TODO
 *
 * @Author: zhenglongze
 * @Date 2019/11/19 11:46
 */
public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s){
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        //错误写法
//        if(o instanceof CaseInsensitiveString){
//            return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
//
//        }
//        if(o instanceof String){
//            return s.equalsIgnoreCase((String)o);
//        }
//        return false;
        //正确写法
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString)o).s.equalsIgnoreCase(s);

    }

    public static void main(String[] args) {
        CaseInsensitiveString c1 = new CaseInsensitiveString("effective");
        String s = "effective";
        //String 未从写.equals 所以为false
        System.out.println("CaseInsensitiveString.equals(String)="+c1.equals(s));
        System.out.println("String.equals(CaseInsensitiveString)="+s.equals(c1));

        CaseInsensitiveString c2 = new CaseInsensitiveString("effective");
        System.out.println("CaseInsensitiveString.equals(CaseInsensitiveString)="+c1.equals(c2));
    }
}
