package com.example.effective.chapter4.clauses17;

import sun.font.CreatedFontTracker;

import java.util.Objects;

/**
 * 复数（具有时部和虚部）
 *
 * @Author: zhenglongze
 * @Date 2020/1/19 11:13
 */
public final class Complex {

    public static final Complex ZERO = new Complex(0,0);
    public static final Complex ONE = new Complex(1,0);
    public static final Complex I = new Complex(0,1);

    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re,double im){
        return new Complex(re,im);
    }

    public double realPart(){
        return re;
    }

    public double imaginaryPart(){
        return im;
    }

    public Complex plus(Complex c){
        return new Complex(re+c.re,im+c.im);
    }

    public Complex minus(Complex c){
        return new Complex(re-c.re,re-c.im);
    }

    public Complex times(Complex c){
        return new Complex(re*c.re-im*c.im,re*c.im+im*c.re);
    }

    public Complex dividedBy(Complex c){
        double tmp = c.re*c.re+c.im*c.im;
        return new Complex((re*c.re+im*c.im)/tmp,(im*c.re-re*c.im)/tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.re, re) == 0 &&
                Double.compare(complex.im, im) == 0;
    }


    @Override
    public int hashCode() {
        //return Objects.hash(re, im);
        return 31*Double.hashCode(re)+Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "Complex{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }
}
