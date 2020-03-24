package com.example.effective.chapter4.clauses18;

import java.time.Instant;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * 继承转发类的形式,包装类
 *
 * @Author: zhenglongze
 * @Date 2020/1/20 14:45
 */
public class InstrumentedHashSet2<E> extends ForwardingSet<E> {

    private int addCount = 0;

    public InstrumentedHashSet2(Set<E> s) {
        super(s);
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
        Set<Instant> times = new InstrumentedHashSet2<>(new TreeSet<>());
        //Set<E> s = new InstrumentedHashSet2<>(new TreeSet<>());
    }
}
