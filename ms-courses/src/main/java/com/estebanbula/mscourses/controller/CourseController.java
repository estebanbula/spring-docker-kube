package com.estebanbula.mscourses.controller;

import com.estebanbula.mscourses.model.entity.Course;
import com.estebanbula.mscourses.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {
    
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> retrieveAllCourses() {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.listCourses());
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> retrieveCourse(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findCourse(id));
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course Course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.saveCourse(Course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String id, @RequestBody Course Course) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.updateCourse(id, Course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
