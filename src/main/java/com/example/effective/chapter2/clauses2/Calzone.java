package com.example.effective.chapter2.clauses2;

/**
 * 半月形pizza
 *
 * @Author: zhenglongze
 * @Date 2019/11/13 16:57
 */
public class Calzone extends Pizza {


    private final boolean scaucInside;

    public static class Builder extends Pizza.Build<Builder>{

        private  boolean scaucInside = false;

        public Builder scaucInside() {
            scaucInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    Calzone(Builder builder) {
        super(builder);
        scaucInside = builder.scaucInside;
    }
}
