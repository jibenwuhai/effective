package com.example.effective.chapter3.clauses13;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 内存泄漏
 *
 * @Author: zhenglongze
 * @Date 2019/11/18 11:51
 */
public class Stack {

    //类自己管理内存，应注意内存泄漏问题,数组为可变类型clone将引用与原始Stack实例相同的数组
    private Object[] elements;
    private int size = 0 ;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++]=e;
    }

    public Object pop(){
        if(size==0){
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null ; //过期引用，给null，以便垃圾回收
        return result;
    }

    private void ensureCapacity() {
        if(elements.length == size){
            elements = Arrays.copyOf(elements,2*size+1);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}
