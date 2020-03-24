package com.example.effective.chapter3.clauses13;

import java.util.HashMap;
import java.util.Map;

/**
 * 重写.equals问自己三个问题:对称,传递,一致
 * 自反和非空也要满足。但是一般都会自动满足
 * 1.覆盖.equals 也要覆盖 hashCode 见十一条
 * 2.不要妄图让.equals过于智能
 * 3.不要将.equals方法中的Object换成其他声明类型
 *
 * @Author: zhenglongze
 * @Date 2019/11/19 16:05
 */
public class PhoneNumber implements Cloneable {

    private final short areaCode,prefix,lineNum;

    public PhoneNumber(int areaCode, int prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode,999,"areaCode");
        this.prefix = rangeCheck(prefix,999,"prefix");
        this.lineNum = rangeCheck(lineNum,9999,"lineNum");

    }

    private static short rangeCheck(int val,int max,String arg){
        if(val<0||val>max){
            throw new IllegalArgumentException(arg+":"+val);
        }
        return (short)val;
    }


    @Override
    public boolean equals(Object o){
        if(o==this){
            return true;
        }
        if(!(o instanceof PhoneNumber)){
            return false;
        }
        PhoneNumber pn = (PhoneNumber)o;
        return pn.areaCode == areaCode && pn.lineNum == lineNum && pn.prefix == prefix;
    }

    public static void main(String[] args) {
        Map<PhoneNumber,String> map = new HashMap<>();
        Short s = 4567;
        map.put(new PhoneNumber(707,867,s),"ZhengLongze");
        //未重写hashCode前map取出key=new PhoneNumber(707,867,s)的对象是null
        System.out.println(map.get(new PhoneNumber(707,867,s)));
    }


    @Override
    public int hashCode(){
        int result = Short.hashCode(areaCode);
        result = 31*result +Short.hashCode(prefix); //31奇素数。可防止乘法溢出
        result = 31*result +Short.hashCode(lineNum);
        return result;
    }

    @Override
    protected PhoneNumber clone() throws CloneNotSupportedException {
        try {
            return (PhoneNumber)super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}
