package com.example.effective.chapter4.clauses23;

/**
 * 表示圆或者矩形
 * 标签类过于冗长，容易出错，并且效率低下。
 *
 * @Author: zhenglongze
 * @Date 2020/4/22 15:40
 */
public class Figure {
    //矩形，圆
    enum Shape{RECTANGLE,CIRCLE}

    final Shape shape;

    //矩形时候需要
    double length;

    double width;

    //圆的时候需要
    double radius;

    //初始化一个圆
    Figure(double radius){
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    //初始化一个矩形
    Figure(double length,double width){
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area(){
        switch (shape){
            case RECTANGLE:
                return length*width;
            case CIRCLE:
                return Math.PI *(radius*radius);
            default:
                throw new AssertionError(shape);
        }
    }

}
