package com.it.study.design.Decorator;

public class Cream extends Food {
    private Food baisc_food;

    public Cream(Food basic_food){
        this.baisc_food = basic_food;
    }
    public String make(){
        return baisc_food.make() + "+ 奶油";
    }
}
