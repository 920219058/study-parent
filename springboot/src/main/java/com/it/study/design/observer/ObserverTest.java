package com.it.study.design.observer;

public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new Subject();
        //subject.attach(new Observera);
        Observer ob1 = new Observera();
        Observer ob2 = new ObserverB();
        subject.attach(ob1);
        subject.attach(ob2);
        subject.notifyEveryOne("111");

    }

}
