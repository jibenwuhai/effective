package com.example.effective.chapter4.clauses16;

/**
 * 如果累可以在它所在的包之外进行访问，就提供访问方法
 *
 * @Author: zhenglongze
 * @Date 2020/1/17 11:45
 */
public class Point {
    //不可取
    //public double x;
    //public double y;

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
