package com.example.effective.chapter2.clauses2;

/**
 *
 * builder对象
 * @Author: zhenglongze
 * @Date 2019/11/13 15:03
 */
public class NutritionFacts {

    private final int servingsSize;

    private final int servings;

    private final int calories;

    private final int fat;

    private final int sodium;

    private final int carbohydrate;

    public static class Builder{

        private final int servingsSize;

        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingsSize,int servings){
            this.servingsSize = servingsSize;
            this.servings = servings;
        }

        public Builder calories(int value){
            calories = value;
            return this;
        }

        public Builder fat(int value){
            fat = value;
            return this;
        }

        public Builder sodium(int value){
            sodium = value;
            return this;
        }

        public Builder carbohydrate(int value){
            carbohydrate = value;
            return this;
        }

        public  NutritionFacts builder(){
            return new NutritionFacts(this);
        }

    }

    private NutritionFacts(Builder builder){
        this.servingsSize = builder.servingsSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

}
