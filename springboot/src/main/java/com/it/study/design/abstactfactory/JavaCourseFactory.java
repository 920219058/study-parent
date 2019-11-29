package com.it.study.design.abstactfactory;

import com.it.study.design.ICourse;
import com.it.study.design.JavaCourse;

public class JavaCourseFactory implements ICourseFactory{


    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
