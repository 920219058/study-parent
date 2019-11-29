package com.it.study.design.observer;

public class Observera implements Observer {

    private String observerState;

    //public Observera

    @Override
    public void update(String newState) {
        //更新观察者状态，让目标一致
        //observerState = newState;
        System.out.println("SZH" + "接到消息" + newState + "我是A，快开抢吧");
    }
}
