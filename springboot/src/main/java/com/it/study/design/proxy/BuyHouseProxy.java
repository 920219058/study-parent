package com.it.study.design.proxy;

public class BuyHouseProxy implements BuyHouse {

    private BuyHouse buyHouse;

    public BuyHouseProxy(final BuyHouse buyHouse){
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        System.out.println("买房前的准备*******");
        buyHouse();
        System.out.println("买房后的装修......");
    }
}
