package com.estebanbula.mscourses.service.impl;

import com.estebanbula.mscourses.model.entity.Course;
import com.estebanbula.mscourses.repository.CourseRepository;
import com.estebanbula.mscourses.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> listCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course findCourse(String id) {
        return courseRepository.findById(id)
                .orElseThrow();
    }

    @Override
    @Transactional
    public Course saveCourse(Course course) {
        course.setId(UUID.randomUUID().toString());
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course updateCourse(String id, Course course) {
        return courseRepository.findById(id)
                .map(current -> {
                    current.setId(id);
                    current.setName(course.getName());
                    return courseRepository.save(current);
                })
                .orElseThrow();
    }

    @Override
    @Transactional
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
