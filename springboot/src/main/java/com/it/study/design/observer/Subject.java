package com.it.study.design.observer;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    //保存注册的观察者对象
    private List<Observer> mObervers = new ArrayList<>();

    //注册观察者对象
    public void attach(Observer observer){
        mObervers.add(observer);
        //Log.e("SZH","Attach an observer");
    }

    public void detach(Observer observer){
        mObervers.remove(observer);

    }

    public void notifyEveryOne(String newState){
        for(Observer observer : mObervers){
            observer.update(newState);
            //observer.update((Observable) observer,newState);
        }
    }
}
