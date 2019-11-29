package com.it.study.design.abstactfactory;

import com.it.study.design.ICourse;

public interface ICourseFactory {

    ICourse createCourse();

    INote createNote();

    IVideo createVideo();
}
