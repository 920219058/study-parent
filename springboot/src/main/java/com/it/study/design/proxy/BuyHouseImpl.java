package com.it.study.design.proxy;

public class BuyHouseImpl implements BuyHouse {
    @Override
    public void buyHouse() {
        System.out.println("买房前的准备");
    }
}
