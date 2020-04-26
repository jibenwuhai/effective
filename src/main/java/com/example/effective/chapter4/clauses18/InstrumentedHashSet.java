package com.example.effective.chapter4.clauses18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * 功能增强的hashSet
 *
 * @Author: zhenglongze
 * @Date 2020/1/20 14:08
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap,float loadFactor){
        super(initCap,loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount+=c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet instrumentedHashSet = new InstrumentedHashSet();
        instrumentedHashSet.addAll(Arrays.asList("Snap","Crackle","Pop"));
        //希望输出3 实际输出6.因为hashSet addAll->add
        System.out.println(instrumentedHashSet.getAddCount());

    }
}
