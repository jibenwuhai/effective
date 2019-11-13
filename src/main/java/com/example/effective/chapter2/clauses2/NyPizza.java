package com.example.effective.chapter2.clauses2;

import java.util.Objects;

/**
 * 纽约pizza
 *
 * @Author: zhenglongze
 * @Date 2019/11/13 16:22
 */
public class NyPizza extends Pizza {

    public enum Size{SMALL,MEDIUM,LARGE}

    private final Size size;

    public Size getSize(){
        return size;
    }

    public static class Builder extends Pizza.Build<Builder>{

        private final Size size;

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build(){
            return new NyPizza(this);
        }

        @Override
        protected Builder self(){return this;}

    }


    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
