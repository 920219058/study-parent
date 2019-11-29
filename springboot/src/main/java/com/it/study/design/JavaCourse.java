package com.it.study.design;

public class JavaCourse implements ICourse{
    @Override
    public void record() {
        System.out.println("java 课程");
    }
}
