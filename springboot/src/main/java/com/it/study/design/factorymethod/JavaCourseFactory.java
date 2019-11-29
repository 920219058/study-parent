package com.it.study.design.factorymethod;

import com.it.study.design.ICourse;
import com.it.study.design.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
