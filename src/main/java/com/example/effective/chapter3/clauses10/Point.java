package com.example.effective.chapter3.clauses10;

import java.util.Objects;

/**
 * 求求你写个注解吧 TODO
 *
 * @Author: zhenglongze
 * @Date 2019/11/19 14:25
 */
public class Point {
    private final int x;

    private final int y;
    public  Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    //@Override
    public boolean equals2(Object o) {
        if(!(o instanceof Point)){
            return false;
        }
        Point point = (Point)o;
        return point.x == x && point.y ==y;
    }

    /**
     * 用getClass 代替 instanceof
     * 这方法相同对象才能等同但是子类就不是point，根据
     * 里氏替换原则；一个类的重要属性也将适用于它的子类.
     * 不建议这么做
     */
    @Override
    public boolean equals(Object o) {
        if(o==null||o.getClass()!=getClass()){
            return false;
        }
        Point point = (Point)o;
        return point.x == x && point.y ==y;
    }

}
