package com.it.study.design.adapter;

public class VoltageAdapter {
    public void changeVoltage(){
        System.out.println("正在充电。。。");
        System.out.println("原始充电：" + Phone.v + "V");
        System.out.println("经过变压器转换之后的电压：" + (Phone.v-200) + "V");
    }
}
