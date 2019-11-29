package com.it.study.design.Decorator;

public class Food {
    private String food_name;

    public Food(){

    }

    public Food(String food_name){
        this.food_name = food_name;
    }

    public String make(){
        return food_name;
    }
}
