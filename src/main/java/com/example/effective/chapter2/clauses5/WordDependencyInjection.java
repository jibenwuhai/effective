package com.example.effective.chapter2.clauses5;

/**
 * 构造器依赖注入
 *
 * @Author: zhenglongze
 * @Date 2019/11/15 9:53
 */
public class WordDependencyInjection {

    private final Dictionary dictionary;

    public WordDependencyInjection(Dictionary dictionary){
        this.dictionary = dictionary;
    }

}
