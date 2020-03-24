package com.example.effective.chapter3.clauses10;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用getClass做.equals的比较onUnitCircle无法实现
 *
 * @Author: zhenglongze
 * @Date 2019/11/19 15:32
 */
public class CounterPoint extends Point {
    private static  final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public static int numberCreated(){
        return counter.get();
    }

    private static final Set<Point> unitCircle = new HashSet<>();
    static {
        unitCircle.add(new Point(1,0));
        unitCircle.add(new Point(0,1));
        unitCircle.add(new Point(-1,0));
        unitCircle.add(new Point(0,-1));
    }

    public static boolean onUnitCircle(Point point){
        return unitCircle.contains(point);
    }

    public static void main(String[] args) {
        System.out.println("point:"+CounterPoint.onUnitCircle(new Point(0,1)));
        System.out.println("CounterPoint:"+CounterPoint.onUnitCircle(new CounterPoint(1,0)));
    }

}
