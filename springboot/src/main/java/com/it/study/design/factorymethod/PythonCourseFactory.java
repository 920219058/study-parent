package com.it.study.design.factorymethod;

import com.it.study.design.ICourse;
import com.it.study.design.PythonCourse;

public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
