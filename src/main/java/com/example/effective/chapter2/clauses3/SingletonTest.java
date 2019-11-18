package com.example.effective.chapter2.clauses3;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 破坏单例测试
 *  创建对象:
 *  1、new 单例构造器私有化
 *  2、clone 单例不能实现cloneable接口
 *  3、反序列化 添加 readResolve 方法。
 *  4、反射
 *
 * @Author: zhenglongze
 * @Date 2019/11/14 10:33
 */
public class SingletonTest {

    public static void main(String[] args) {
        //serializable();
        //reflectMethod();
        //emumTest();

    }

    private static void emumTest() {
        try {
            EnumSingleton s1 = EnumSingleton.INSTANCE;
            EnumSingleton s2 = null;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(s1);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            s2 = (EnumSingleton) ois.readObject();
            System.out.println("序列化反序列化之前:" + s1);
            System.out.println("序列化反序列化之后:" + s2);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    /**
     * 反射破坏单例测试
     */
    public static void reflectMethod(){
        try {

            LazySingleton s2 = null;
            Class singletonClass = LazySingleton.class;
            Constructor constructor = singletonClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            s2 = (LazySingleton)constructor.newInstance();
            LazySingleton s1 = LazySingleton.getInstance();
            System.out.println("正常获取单例:"+s1);
            System.out.println("反射获取单例:"+s2);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 序列化反序列化破坏单例测试
     */
    private static void serializable(){
        try {
            //正常获取
            LazySingleton s1 = LazySingleton.getInstance();
            //序列号反序列化获取
            LazySingleton s2 = null;

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(s1);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            s2 = (LazySingleton)ois.readObject();
            System.out.println("序列化反序列化之前:"+s1);
            System.out.println("序列化反序列化之后:"+s2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
