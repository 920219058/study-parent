package com.it.study.design.observer;

public class ConcreteSubject extends Subject {
    private String state;

    public String getState(){
        return state;
    }

    public void change(String newState){
        state = newState;
        //状态发生改变，通知观察者
        notifyEveryOne(newState);
    }

}
