package com.it.study.design.factorymethod;

import com.it.study.design.ICourse;

public class FactoryMethodTest {
    public static void main(String[] args) {
        ICourseFactory facutor = new PythonCourseFactory();
        ICourse course = facutor.create();
        course.record();
    }

}
