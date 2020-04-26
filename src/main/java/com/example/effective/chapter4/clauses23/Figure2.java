package com.example.effective.chapter4.clauses23;

/**
 * 计算面积方法
 *
 * @Author: zhenglongze
 * @Date 2020/4/22 16:00
 */
public abstract class Figure2 {

    abstract double area();

}

//圆
class Circle extends Figure2{

    final double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI*radius*radius;
    }
}
//矩形
class Rectangle extends Figure2{
    final double length;
    final double width;
    Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length*width;
    }
}
//正方形
class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}
