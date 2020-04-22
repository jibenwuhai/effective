package com.example.effective.chapter4.clauses19;

import java.time.Instant;

/**
 * 子类
 *
 * @Author: zhenglongze
 * @Date 2020/4/21 10:35
 */
public class Sup extends Super {

    private final Instant instant;

    public Sup() {
        this.instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sup sup = new Sup();
        sup.overrideMe();
    }
}
