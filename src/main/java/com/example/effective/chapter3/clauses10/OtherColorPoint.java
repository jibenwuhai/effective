package com.example.effective.chapter3.clauses10;

import com.sun.prism.paint.Color;

import java.util.Objects;

/**
 * 权宜之计:复合优先继承
 *
 * @Author: zhenglongze
 * @Date 2019/11/19 15:54
 */
public class OtherColorPoint {

    private final Point point;
    private final Color color;

    OtherColorPoint(int x,int y,Color color){
        this.point = new Point(x,y);
        this.color = color;
    }

    public Point asPoint(){
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof OtherColorPoint){
            return false;
        }
        OtherColorPoint cp = (OtherColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

}
