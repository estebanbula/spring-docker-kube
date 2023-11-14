package com.estebanbula.mscourses.repository;

import com.estebanbula.mscourses.model.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
}
