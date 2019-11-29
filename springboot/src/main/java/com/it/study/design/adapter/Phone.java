package com.it.study.design.adapter;

public class Phone {
    public static final int v = 220;

    private VoltageAdapter adapter;

    public void charge(){
        adapter.changeVoltage();
    }
    public void setAdapter(VoltageAdapter adapter){
        this.adapter = adapter;
    }
}
