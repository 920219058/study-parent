package com.it.study.design.abstactfactory;

public class AbstactFactoryTest {
    public static void main(String[] args) {
        ICourseFactory factory = new JavaCourseFactory();
        factory.createCourse().record();
        factory.createNote();
        factory.createVideo();
    }

}
