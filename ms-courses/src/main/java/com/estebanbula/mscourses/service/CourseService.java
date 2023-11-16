package com.estebanbula.mscourses.service;

import com.estebanbula.mscourses.model.entity.Course;
import com.estebanbula.mscourses.model.pojo.User;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> listCourses();
    Optional<Course> findCourse(String id);
    Course saveCourse(Course course);
    Course updateCourse(String id, Course course);
    void deleteCourse(String id);
    Optional<User> assignUser(String courseId, String userId);
    Optional<User> createUser(String courseId, User user);
    Optional<User> deleteUserFromCourse(String courseId, String userId);

}
