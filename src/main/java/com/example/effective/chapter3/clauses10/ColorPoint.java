package com.example.effective.chapter3.clauses10;

import com.sun.prism.paint.Color;

import java.util.Objects;

/**
 * 拓展实例化
 * 我们无法在拓展实例化的类同时，既增加新值的组件，又同时保留.equals的约定。
 *
 * @Author: zhenglongze
 * @Date 2019/11/19 14:50
 */
public class ColorPoint extends Point {

    private final Color color;

    public ColorPoint(int x, int y,Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * 错误示例1 违背对称性
     * point.equals(ColorPoint) = true
     * ColorPoint.equals(Point) = false
     */
//    @Override
//    public boolean equals(Object o) {
//        if(!(o instanceof ColorPoint)){
//            return false;
//        }
//        return super.equals(o) && ((ColorPoint) o).color.equals(color);
//    }


    /**
     * 错误示例2 违背传递性
         p.equals(cp):true
         cp.equals(p):true
         Point p1 = new Point(1,2);
         ColorPoint p2 = new ColorPoint(1,2,Color.BLACK);
         ColorPoint p3 = new ColorPoint(1,2,Color.RED);
         p1.equals(p2):true
         p2.equals(p3):false
         p1.equals(p3):true

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)){
            return false;
        }
        if(!(o instanceof ColorPoint)){
            return o.equals(this);
        }
        return super.equals(o) && ((ColorPoint) o).color.equals(color);
    }
     */


    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        ColorPoint p2 = new ColorPoint(1,2,Color.BLACK);
        ColorPoint p3 = new ColorPoint(1,2,Color.RED);
        System.out.println("p1.equals(p2):"+p1.equals(p2));
        System.out.println("p2.equals(p3):"+p2.equals(p3));
        System.out.println("p1.equals(p3):"+p1.equals(p3));
    }

}
