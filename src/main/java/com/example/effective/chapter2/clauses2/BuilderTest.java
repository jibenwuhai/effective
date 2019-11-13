package com.example.effective.chapter2.clauses2;

import java.util.Set;

/**
 * builder 客户端测试
 *
 * @Author: zhenglongze
 * @Date 2019/11/13 15:24
 */
public class BuilderTest {

    NutritionFacts nutritionFacts = new NutritionFacts.Builder(1,2).
            calories(3).carbohydrate(4).fat(5).builder();



    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.ONION).addTopping(Pizza.Topping.HAM).build();

        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.PEPPER).scaucInside()
                .addTopping(Pizza.Topping.MUSHROOM).build();
        Set<Pizza.Topping> toppings = nyPizza.getToppings();
        NyPizza.Size size = nyPizza.getSize();


    }

}
