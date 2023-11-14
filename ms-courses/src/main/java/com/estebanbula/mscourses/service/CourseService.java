package com.estebanbula.mscourses.service;

import com.estebanbula.mscourses.model.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> listCourses();
    Course findCourse(String id);
    Course saveCourse(Course course);
    Course updateCourse(String id, Course course);
    void deleteCourse(String id);

}
