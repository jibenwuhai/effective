package com.example.effective.chapter4.clauses17;

import java.math.BigDecimal;
import java.util.BitSet;

/**
 * 不可变对象改变一位
 *
 * @Author: zhenglongze
 * @Date 2020/1/20 11:46
 */
public class ChangeNum {


    public static void main(String[] args) {
        //不可变对象。每改变一次就会产生一个新的对象，回造成性能问题
        BigDecimal moby = new BigDecimal(1235467896.2334);

        //可变对象
        BitSet bitSet = new BitSet(1123);
        bitSet.flip(0);
    }
}
