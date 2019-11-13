package com.example.effective.chapter2.clauses2;

import java.util.EnumSet;
import java.util.Set;

/**
 * 于类层次结构builder
 *
 * @Author: zhenglongze
 * @Date 2019/11/13 15:40
 */
public abstract class Pizza {

    public enum Topping{HAM ,MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    public Set<Topping> getToppings(){
        return toppings;
    }

    abstract static class Build<T extends Build<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping){
            toppings.add(topping);
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Build<?> build){
        toppings =build.toppings.clone();
    }



}
