package com.example.effective.chapter2.clauses9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 求求你写个注解吧 TODO
 *
 * @Author: zhenglongze
 * @Date 2019/11/18 18:00
 */
public class TryWithResourceException {

    //单资源的时候
    public String firstLineOfFile(String path,String defaultValue)   {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }catch (IOException e){
            return defaultValue;
        }
    }
}
